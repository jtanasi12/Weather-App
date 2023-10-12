package com.cs505.group.strategy;

/**
 * Author: Sean Oushana
 * Class Description: Class WeatherGetterA that realizes the 'Strategy' Interface. 
 * It implements the 'getTemperature' hook method from the interface and in this case, makes the call to
 * Weather.gov to find and return the current temperature in integer format.
 */
package com.cs505.group.strategy;

public class WeatherGetterA implements Strategy {
    public int getTemperature(String address){
        //this is where the API call to Weather.gov would go. Currently a print statement as the code for the call hasn't been finalized yet.
        //arbitrarily setting the temperature to be 50, but this will be set with the API call and not hard-coded test lines in the future
        System.out.println("API call to https://www.weather.gov/documentation/services-web-api#/default/gridpoint_forecast");
        int temperature = 50; 
        return temperature;
    }
}
