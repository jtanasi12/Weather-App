package com.cs505.group.main.validation;

import com.cs505.group.main.models.GeocodedLocation;
import com.cs505.group.main.services.ForecastServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Maurice Johnson
 *
 * This is an implementation of the ValidationStrategy. Within validate()
 * we will provide logic to validate whether an address is valid or not
 */
public class WeatherAddressValidationStrategy implements ValidationStrategy {

    private Set<Character> specialCharsInput;

    /**
     * method to validate an address - implementing from interface
     * @param input
     * @return String
     */
    @Override
    public String validate(String input) {
        if (isEmpty(input.trim())) return "Location cant be empty!";
        if (containsSpecialChars(input)) return "Location cannot contain the character(s): "+specialCharsInput.toString();
        if (!mapboxResultsExist(input)) return "["+input+"] is not a valid location!";
        return null;
    }

    /**
     * check if the users input is null or an empty string
     * @param input
     * @return
     */
    private boolean isEmpty(String input){
        if (input == null) return true;
        if (input.length()==0) return true;
        return false;
    }

    /**
     * check if the users input contains any special characters besides a comma
     * @param input
     * @return
     */
    private boolean containsSpecialChars(String input){
        specialCharsInput = getInputSpecialChars(input);
        if (specialCharsInput.size() > 0) return true;
        return false;
    }

    /**
     * add any special characters besides a comma to set
     * @param input
     * @return
     */
    private Set<Character> getInputSpecialChars(String input){
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))
                    && !Character.isLetter(input.charAt(i))
                    && !Character.isWhitespace(input.charAt(i))) {
                Character theChar = input.charAt(i);
                if (theChar != ',') chars.add(theChar);
            }
        }
        return chars;
    }

    /**
     * check if any locations were found from the user input
     * @param loc
     * @return
     */
    private boolean mapboxResultsExist(String loc){
        GeocodedLocation geocodedLocation = geocodeLocation(loc);
        ForecastServiceImpl.geocodedLocation = geocodedLocation;
        return geocodedLocation.getFeatures().size() > 0;
    }

    /**
     * This method takes in a location string. An HTTPS endpoint is formed then we preform a GET request
     * on the mapbox api endpoint and get a JSON response in return. We then cast this response json string
     * to be a GeocodedLocation object and return.
     * @param loc
     * @return
     */
    private GeocodedLocation geocodeLocation(String loc){
        RestTemplate restTemplate = new RestTemplate();
        String apiKey = "pk.eyJ1IjoibWF1cmljZWo5NSIsImEiOiJjanh1ZnVzMHAxNHV5M2Jyb2I5bXJ3c3BoIn0.sJjb1yKUOJKwtI4Hceqk-A";
        String reqUrl = "https://api.mapbox.com/geocoding/v5/mapbox.places/"+loc+".json?access_token="+apiKey;
        ResponseEntity<GeocodedLocation> latLongReq = restTemplate.getForEntity(reqUrl, GeocodedLocation.class);
        return latLongReq.getBody();
    }



}
