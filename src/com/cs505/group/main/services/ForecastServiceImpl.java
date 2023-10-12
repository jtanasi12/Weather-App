package com.cs505.group.main.services;


import com.cs505.group.main.models.FullWeatherForecast;
import com.cs505.group.main.models.GeocodedLocation;
import com.cs505.group.main.models.LocationAndForecast;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * author: Maurice Johnson
 *
 * This class acts as an implementation for the forecast service.
 *
 */
public class ForecastServiceImpl implements ForecastService {

    public static GeocodedLocation geocodedLocation;

    private RestTemplate restTemplate = new RestTemplate();

    /**
     * This method takes in a location string and a unit
     * string (C or F) which corresponds to celsius or fahrenheit.
     * This method will return information about the geocoded location
     * as well as weather information from the openweatherapi
     * @param loc
     * @param unit
     * @return LocationAndForecast
     */
    @Override
    public LocationAndForecast getForecastAndLocation(String loc, String unit) {

        if (geocodedLocation != null) {
            if (geocodedLocation.getFeatures().size() > 0) {

                String longitude = geocodedLocation.getFeatures().get(0).getCoordinates().get(0).toString();
                String latitude = geocodedLocation.getFeatures().get(0).getCoordinates().get(1).toString();

                FullWeatherForecast fullWeatherForecast = getWeather(latitude, longitude, unit);

                if (fullWeatherForecast != null) {
                    return new LocationAndForecast(geocodedLocation, fullWeatherForecast);
                }

            }
        }

        return null;
    }

    /**
     * This method takes in a latitude, longitude, and unit string (C or F) which corresponds to celsius or fahrenheit.
     * An HTTPS endpoint is formed then we preform a GET request on the weather api endpoint and get a JSON response in return.
     * We then cast this response json string to be a FullWeatherForecast object and return.
     * @param lat
     * @param lon
     * @param unit
     * @return FullWeatherForecast
     * @throws RestClientException
     */
    private FullWeatherForecast getWeather(String lat, String lon, String unit) throws RestClientException {
        String apiKey = "f41fd73b971e31844dd49ea032087ae4";
        String temperatureUnit = unit.equalsIgnoreCase("c") ? "metric" : "imperial";
        String reqUrl = "https://api.openweathermap.org/data/2.5/onecall?lat="+lat+"&lon="+lon+"&units="+temperatureUnit+"&appid="+apiKey;
        ResponseEntity<FullWeatherForecast> weatherReq = null;
        try {
            weatherReq = restTemplate.getForEntity(reqUrl, FullWeatherForecast.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return weatherReq.getBody();
    }

}
