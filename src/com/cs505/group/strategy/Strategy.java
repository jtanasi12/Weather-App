package com.cs505.group.strategy;

/**
 * Author: Sean Oushana
 * Interface Description: Interface Strategy contains the hook method for getting the current temperature.
 * There are two different APIs available for finding the temperature for any specific location. 
 * This interface contains the hook which will call the respective class for each 'WeatherGetter'
 */
package com.cs505.group.strategy;
 
public interface Strategy {
    public int getTemperature(String address);
}
