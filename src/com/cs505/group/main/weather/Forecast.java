package com.cs505.group.main.weather;

import java.util.ArrayList;
import java.util.List;

/**
 * author: Maurice Johnson
 *
 * This forecast class will act as the subject in the observer pattern. The forecast will
 * have a list observers and a current weather condition.
 */
public class Forecast {  

    private List<Observer> observers = new ArrayList<>();
    private String currentWeatherConditions;

    /**
     * retrieves current weather condition
     * @return String
     */
    public String getCurrentWeatherConditions(){
        return currentWeatherConditions;
    }

    /**
     * Sets current weather condition and notifies all observers
     * @param currentWeatherConditions
     */
    public void setCurrentWeatherConditions(String currentWeatherConditions){
        this.currentWeatherConditions = currentWeatherConditions;
        notifyAllObservers();
    }

    /**
     * attaches an observer to the forecast
     * by adding it to the list of observers
     * @param observer
     */
    public void attach(Observer observer){
        observers.add(observer);
    }

    /**
     * This method is called when setting the current weather conditions.
     * Once we set the current conditons, we call the updateConditions method on all observers
     */
    public void notifyAllObservers(){
        for (Observer observer : observers){
            observer.updateConditions();
        }
    }
}
