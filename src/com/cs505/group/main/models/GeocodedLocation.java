package com.cs505.group.main.models;

import java.util.List;

/**
 * author: Maurice Johnson
 *
 * This class is a POJO that corresponds to an object
 * in the response json from the openweatherapi
 */
public class GeocodedLocation {
    private List<Feature> features;

    public GeocodedLocation() {
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "GeocodedLocation{" +
                "features=" + features +
                '}';
    }
}
