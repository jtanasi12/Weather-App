package com.cs505.group.main.models;

/**
 * author: Maurice Johnson
 *
 * This class is a POJO that corresponds to an object
 * in the response json from the openweatherapi
 */
public class FeelsLike {

    private int day;
    private int night;
    private int eve;
    private int morn;

    public FeelsLike() {
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getNight() {
        return night;
    }

    public void setNight(int night) {
        this.night = night;
    }

    public int getEve() {
        return eve;
    }

    public void setEve(int eve) {
        this.eve = eve;
    }

    public int getMorn() {
        return morn;
    }

    public void setMorn(int morn) {
        this.morn = morn;
    }

    @Override
    public String toString() {
        return "FeelsLike{" +
                "day=" + day +
                ", night=" + night +
                ", eve=" + eve +
                ", morn=" + morn +
                '}';
    }
}
