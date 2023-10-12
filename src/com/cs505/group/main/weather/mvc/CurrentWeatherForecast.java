package com.cs505.group.main.weather.mvc;

import com.cs505.group.main.models.CurrentForecast;
import com.cs505.group.main.models.FullWeatherForecast;
import com.cs505.group.main.models.LocationAndForecast;




/**
 * author: Maurice Johnson
 * This class acts as our Weather model. It contains various attributes
 * of a weather forecast as well as some getter/setter methods.
 */
public class CurrentWeatherForecast {

    private LocationAndForecast locationAndForecast;

    public LocationAndForecast getLocationAndForecast() {
        return locationAndForecast;
    }

    public void setLocationAndForecast(LocationAndForecast locationAndForecast) {
        this.locationAndForecast = locationAndForecast;
    }


}