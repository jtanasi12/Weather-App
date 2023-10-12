package com.cs505.group.main.weather.mvc;
/**
 * Strategy Factory class contains the logic that decides which Strategy to go with
 * @author Sean Oushana
 *
 */

public class StrategyFactory {
    // Decides which Strategy to implement. If the location from the User is within the US, find other cities in US
    public static Strategy createStrategy(String locNameStr){
        String location = locNameStr;
        if(location.contains("United States")){
            ConcreteStrategyUS strat = new ConcreteStrategyUS();
            strat.displayGraph();
            return strat;
        }
        //otherwise, find the weather of other countries to populate the graph
        else {
            ConcreteStrategyForeign strat = new ConcreteStrategyForeign();
            strat.displayGraph();
            return strat;
        }
    }
}
