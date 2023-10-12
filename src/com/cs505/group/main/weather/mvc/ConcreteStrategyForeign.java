package com.cs505.group.main.weather.mvc;

import graph.strategy.GraphProfile;

/**
 * author: Sean Oushana
 * This class is the concrete strategy for creating a graph of foreign weather data.
 */

public class ConcreteStrategyForeign implements Strategy {
        //Foreign version finds weather of countries across the globe to populate the graph
        public void displayGraph(){
        String barTitle = "Temperature Across Various Countries in the World";
        String[] pieRowTitles = {"Temperature"};
        String[] columnTitles = {"Japan", "Spain", "Iceland", "USA"};
        int[][] twoDimData = {{50, 70, 30, 40}};
        String barXAxisTitle = "Country";
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


