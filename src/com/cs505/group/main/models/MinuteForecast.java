package com.cs505.group.main.models;

/**
 * author: Maurice Johnson
 *
 * This class is a POJO that corresponds to an object
 * in the response json from the openweatherapi
 */
public class MinuteForecast {

    private long dt;
    private int precipitation;

    public MinuteForecast() {
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return "MinuteForecast{" +
                "dt=" + dt +
                ", precipitation=" + precipitation +
                '}';
    }
}
