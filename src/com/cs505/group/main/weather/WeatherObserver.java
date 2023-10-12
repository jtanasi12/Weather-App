package com.cs505.group.main.weather;

/**
 * author: Maurice Johnson
 * Concrete observer class.
 */
public class WeatherObserver extends Observer {

    /**
     * When creating a new WeatherObserver instance, we set our forecast instance variable from the parent
     * to the passed in forecast object. We then attach this class to the list of observers in the forecast.
     * @param forecast
     */
    public WeatherObserver(Forecast forecast){
        this.forecast = forecast;
        this.forecast.attach(this);
    }

    /**
     * This method is called when the current weather conditions change.
     */
    @Override
    public void updateConditions() {
        System.out.println("\nWeatherObserver - updateConditions()");
        System.out.println("Current weather conditions: "+forecast.getCurrentWeatherConditions()+"\n");
    }

}
