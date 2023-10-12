package com.cs505.group.main.weather.mvc;

import graph.strategy.GraphProfile;

/**
 * author: Sean Oushana
 * This class is the concrete strategy for creating a graph of local weather data
 */

public class ConcreteStrategyUS implements Strategy {
    //Local version finds weather of cities within the US to populate the graph
    public void displayGraph() {
        String barTitle = "Temperatures Across Various Cities in the USA";
        String[] pieRowTitles = {"Temperature"};
        String[] columnTitles = {"Hartford, CT", "New York, NY", "Boston, MA", "Austin, TX"};
        int[][] twoDimData = {{38, 36, 32, 59}};
        String barXAxisTitle = "City";
        String barYAxisTitle = "Temperature in Fahrenheit";
        GraphProfile barProfile = new GraphProfile(
                barTitle,
                pieRowTitles,
                columnTitles,
                twoDimData,
                barXAxisTitle,
                barYAxisTitle);
        System.out.println("Graph of "+barTitle+" created!");
    }
}
