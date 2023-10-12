package com.cs505.group.main.services;


import com.cs505.group.main.models.LocationAndForecast;

/**
 * author: Maurice Johnson
 *
 * This interface contains a single method to get the
 * weather and information about the provided location
 *
 */
public interface ForecastService {

    /**
     * This method takes in a location string and a unit
     * string (C or F) which corresponds to celsius or fahrenheit.
     * This method will return information about the geocoded location
     * as well as weather information from the openweatherapi
     * @param loc
     * @param unit
     * @return LocationAndForecast
     */
    LocationAndForecast getForecastAndLocation(String loc, String unit);

}
