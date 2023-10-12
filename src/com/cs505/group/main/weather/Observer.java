package com.cs505.group.main.weather;

/**
 * author: Maurice Johnson
 *
 * Observer parent class. Child classes will set the forecast
 * instance variable and provide an updateConditions implementation.
 */
public abstract class Observer {
    protected Forecast forecast;
    public abstract void updateConditions();
}
