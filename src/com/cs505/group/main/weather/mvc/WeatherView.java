package com.cs505.group.main.weather.mvc;

import com.cs505.group.main.models.*;
import com.cs505.group.main.util.LoggerUtil;
import com.cs505.group.newsArticles.client.GetNews;
import graph.strategy.GraphProfile;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

/**
 * author: Maurice Johnson & Sean Oushana
 * This class represents the visualization of data the Weather model contains
 */
public class WeatherView {
    private Strategy strategy;
    private GetNews article = new GetNews();

    /**
     * This method acts as the view in our MVC pattern
     * and prints weather details to the console
     * @param locationAndForecast
     */
	
	private String weatherCondition;
	private String location;
	
	
    public void getWeatherView(LocationAndForecast locationAndForecast) {
        GeocodedLocation loc = locationAndForecast.getLocation();
        FullWeatherForecast forecast = locationAndForecast.getFullWeatherForecast();
        CurrentForecast currentForecast = forecast.getCurrent();
        Weather weather = currentForecast.getWeather().get(0);

        Instant instant = Instant.ofEpochSecond(currentForecast.getDt());
        Date currentDate = Date.from(instant);

        instant = Instant.ofEpochSecond(currentForecast.getSunrise());
        Date sunrise = Date.from(instant);
        

        instant = Instant.ofEpochSecond(currentForecast.getSunset());
        Date sunset = Date.from(instant);

        SimpleDateFormat sd1 = new SimpleDateFormat("hh:mm a");
        SimpleDateFormat sd2 = new SimpleDateFormat("EEEE, MMMM dd Y, hh:mm a");
        
        // Keep track of the hours and minutes 
        SimpleDateFormat sd3 = new SimpleDateFormat("hh"); 
        SimpleDateFormat sd4 = new SimpleDateFormat("mm");

        
        String locNameStr = loc.getFeatures().get(0).getPlaceName();
        
        //Calls Strategy/Factory to integrate Team Dash's graphics API
        Strategy strategy = StrategyFactory.createStrategy(locNameStr);

        //Integrate Team Devil Logger's API
        LoggerUtil.log("WeatherView - getWeatherView()");
        System.out.println("\n\n"+locNameStr);
        
        //Calls the Chain of Responsibility to generate articles
        article.getNews(locNameStr);


        System.out.println("\nWeatherView - getWeatherView()\n");
        System.out.println(locNameStr);
        
        location = locNameStr;
        
        System.out.println("\nCurrent: "+sd2.format(currentDate)+"\n");
        
       
        System.out.println("Sunrise: "+sd1.format(sunrise));
        
         
        System.out.println("Sunset: "+sd1.format(sunset));

        System.out.println("Current conditions: "+ weather.getMain());
        
        // Save the weather condition
        weatherCondition = weather.getMain();
        
        System.out.println("Wind Speed: "+currentForecast.getWindSpeed()+"MPH");
        System.out.println("Current Temp: "+currentForecast.getTemp()+" degrees fahrenheit");
        System.out.println("Current Feels Like: "+currentForecast.getFeelsLike()+" degrees fahrenheit");
        System.out.println("Humidity: "+currentForecast.getHumidity()+"%");
        System.out.println("Cloud Coverage: "+currentForecast.getClouds()+"%\n");

       
    }
    
    
    public String savedStateInfo(LocationAndForecast locationAndForecast) {
    	
    	String savedState = "";

        FullWeatherForecast forecast = locationAndForecast.getFullWeatherForecast();
        CurrentForecast currentForecast = forecast.getCurrent();
        
        Instant instant = Instant.ofEpochSecond(currentForecast.getDt());
        Date currentDate = Date.from(instant);
        
        SimpleDateFormat sd2 = new SimpleDateFormat("MMMM dd Y, hh:mm a");
        
        savedState = sd2.format(currentDate);
        
        return savedState;
    }

    public String getWeatherCondition() {
    	return weatherCondition;
    }
    public String getLocation() {
    	return location;
    }
    
  
}