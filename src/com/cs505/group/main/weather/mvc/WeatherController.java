package com.cs505.group.main.weather.mvc;


import com.cs505.group.main.models.LocationAndForecast;


/**
 * author: Maurice Johnson
 * This class acts as our controller. It acts on both the model and view. It will control
 * the data flow into the Weather model and also updateConditions the weather view. This will keep both the
 * view and model separated.
 */
public class WeatherController {

    private CurrentWeatherForecast model;
    private WeatherView view;

    public WeatherController(CurrentWeatherForecast model, WeatherView view) {
        this.model = model;
        this.view = view;
    }

    public void setLocationAndForecast(LocationAndForecast locationAndForecast) {
        model.setLocationAndForecast(locationAndForecast);
    }

    public void updateView(){
        view.getWeatherView(model.getLocationAndForecast());
    }
    
    public String updateSavedState() {
    	return view.savedStateInfo(model.getLocationAndForecast());
    }
  
   public String getWeatherCondition() {
	   return view.getWeatherCondition();
   }

   public String getLocation() {
	   return view.getLocation();
   }
   
 
}
