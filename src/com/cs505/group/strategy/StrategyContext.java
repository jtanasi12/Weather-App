package com.cs505.group.strategy;

/**
 * Author: Sean Oushana
 * Class Description: Class StrategyContext is the concrete class that is responsible for 
 * calling on the strategies. This class attempts to get the current temperature,
 * and relies on one of two different API calls to get that data.
 */
package com.cs505.group.strategy;

public class StrategyContext {
    private Strategy stratA = new WeatherGetterA();
    private Strategy stratB = new WeatherGetterA();

    private void displayWeather(){
        //will get the address from the user through a frontend form. Will have to integrate with Maurice's code to accomplish this.
        //arbitrarily setting address to be CCSU, but this will not remain in the future.
        String address = "1615 Stanley St, New Britain 06053";
        int temperature;
        //example condition. will look into API documentation to find a more 
        //realistic reason for why we would choose one
        //'strategy' or API call over the other
        if(1==1){ 
            temperature = stratA.getTemperature(address);
        }
        else{
            temperature = stratB.getTemperature(address);
        }

        System.out.println("Returned temperature = \'"+temperature+"\"");
        return;
    }

    //main method only for testing purposes. We will only have one main method in the future, and it will not be this one.
    public static void main(String[] args) {
        StrategyContext context = new StrategyContext();
        context.displayWeather();
    }
}