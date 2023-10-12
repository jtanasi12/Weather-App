package com.cs505.group.main.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * author: Maurice Johnson
 *
 * This class is a POJO that corresponds to an object
 * in the response json from the openweatherapi
 */
public class FullWeatherForecast {

    private double lat;
    private double lon;
    private String timezone;
    @JsonProperty("timezone_offset")
    private long timezoneOffset;
    private CurrentForecast current;
    private List<MinuteForecast> minutely;
    private List<HourForecast> hourly;
    private List<DailyForecast> daily;
    private List<Alert> alerts;

    public FullWeatherForecast() {
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getTimezone() {
        return timezone;
    }

    public long getTimezoneOffset() {
        return timezoneOffset;
    }

    public CurrentForecast getCurrent() {
        return current;
    }

    public List<MinuteForecast> getMinutely() {
        return minutely;
    }

    public List<HourForecast> getHourly() {
        return hourly;
    }

    public List<DailyForecast> getDaily() {
        return daily;
    }

    public List<Alert> getAlerts() {
        return alerts;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public void setTimezoneOffset(long timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public void setCurrent(CurrentForecast current) {
        this.current = current;
    }

    public void setMinutely(List<MinuteForecast> minutely) {
        this.minutely = minutely;
    }

    public void setHourly(List<HourForecast> hourly) {
        this.hourly = hourly;
    }

    public void setDaily(List<DailyForecast> daily) {
        this.daily = daily;
    }

    public void setAlerts(List<Alert> alerts) {
        this.alerts = alerts;
    }

    @Override
    public String toString() {
        return "FullWeatherForecast{" +
                "lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", timezone='" + timezone + '\'' +
                ", timezoneOffset=" + timezoneOffset +
                ", current=" + current +
                ", minutely=" + minutely +
                ", hourly=" + hourly +
                ", daily=" + daily +
                ", alerts=" + alerts +
                '}';
    }
}
