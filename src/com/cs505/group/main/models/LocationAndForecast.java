package com.cs505.group.main.models;

/**
 * author: Maurice Johnson
 *
 * This class will be used to store both
 * GeocodedLocation and FullWeatherForecast
 * in a central object
 *
 */
public class LocationAndForecast {

    private GeocodedLocation location;
    private FullWeatherForecast fullWeatherForecast;

    public LocationAndForecast(GeocodedLocation location, FullWeatherForecast fullWeatherForecast) {
        this.location = location;
        this.fullWeatherForecast = fullWeatherForecast;
    }

    public GeocodedLocation getLocation() {
        return location;
    }

    public void setLocation(GeocodedLocation location) {
        this.location = location;
    }

    public FullWeatherForecast getFullWeatherForecast() {
        return fullWeatherForecast;
    }

    public void setFullWeatherForecast(FullWeatherForecast fullWeatherForecast) {
        this.fullWeatherForecast = fullWeatherForecast;
    }
}
