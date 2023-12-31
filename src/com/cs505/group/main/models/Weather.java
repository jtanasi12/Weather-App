package com.cs505.group.main.models;

import org.apache.commons.text.WordUtils;

/**
 * author: Maurice Johnson
 *
 * This class is a POJO that corresponds to an object
 * in the response json from the openweatherapi
 */
public class Weather {

    private long id;
    private String main;
    private String description;
    private String icon;

    public Weather() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return WordUtils.capitalize(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
