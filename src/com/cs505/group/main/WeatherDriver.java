package com.cs505.group.main;

import com.cs505.group.main.models.*;
import com.cs505.group.main.services.ForecastService;
import com.cs505.group.main.services.ForecastServiceImpl;
import com.cs505.group.main.util.LoggerUtil;
import com.cs505.group.main.validation.*;
import com.cs505.group.main.weather.Forecast;
import com.cs505.group.main.weather.WeatherObserver;
import com.cs505.group.main.weather.mvc.CurrentWeatherForecast;
import com.cs505.group.main.weather.mvc.WeatherController;
import com.cs505.group.main.weather.mvc.WeatherView;

import com.cs505.group.newsArticles.articlefinder.ArticleFinder;
import com.cs505.group.newsArticles.articlehandler.IArticle;
import com.cs505.group.newsArticles.factory.INewsFactory;
import com.cs505.group.newsArticles.factory.NewsFactory;
import com.cs505.group.state.CareTaker;
import com.cs505.group.state.Context;
import com.cs505.group.state.StateOriginator;

import graph.strategy.GraphProfile;
import javafx.application.Application;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 * author: Maurice Johnson
 * <p>
 * This class contains a main method which kicks off the Weather workflow. Upon
 * running, the application asks the user
 * to enter a location. After the weather details get returned, the user has the
 * option to refresh the weather for the
 * previously entered location or they can enter a new location. If the user
 * wishes to do neither, they can exit the
 * application.
 */
public class WeatherDriver {

    // Global Variables
    private static boolean allowRefresh;

    private static Context createWeatherState = new Context(); // Creates/Handles Weather States
    private static CareTaker weatherList = new CareTaker(); // Holds a list of weatherState Objects
    private static StateOriginator state; // The state that is subject to change
    private static CurrentWeatherForecast model;
    private static WeatherController controller;

    public static void main(String[] args) {
        startApplication();
    }

    /**
     * starts our application
     */
    private static void startApplication() {

        LoggerUtil.log("WeatherDriver.java - startApplication()\n");

        // Load any saved weather states from the .txt file
        loadPreviousStates();

        System.out.println("Welcome to the Weather Application! Please enter a location:");

        Scanner scanner = new Scanner(System.in);
        String location = scanner.nextLine();

        ValidationContext validationContext = new ValidationContext(
                new ValidationStrategy[] { new ContinueValidationStrategy() });
        ValidationResponse validationResponse;

        while (true) {

            startWeatherWorkflow(location);
            weatherList.display();

            // check if user is asking for a refresh
            if (allowRefresh == true) {

                // ask if the user would like to refresh the weather until they answer yes/no
                while (true) {
                    System.out.println("Would you like to refresh the weather? [Yes or No]");
                    String continueStr = scanner.nextLine();
                    validationResponse = validationContext.validate(continueStr);

                    if (validationResponse.getErrors().size() == 0)
                        break;

                }

                // If the user wants to refresh, prompt the user if they want to save the state
                if (!ContinueValidationStrategy.isNo()) {
                    if (updateState()) {
                        long sunRise = model.getLocationAndForecast().getFullWeatherForecast().getCurrent()
                                .getSunrise();
                        stateHandler(controller.getWeatherCondition(), controller.updateSavedState(), sunRise);

                    } else {

                        // The user wants to refresh without saving data
                    }
                }
                // user doesn't want to refresh
                else if (ContinueValidationStrategy.isNo()) {

                    if (!CareTaker.fileIsEmpty()) {
                        weatherList.dumpStates();

                    }
                    // ask if the user would like to enter a new location until they answer yes/no
                    while (true) {
                        System.out.println("Would you like to get the weather for a new location? [Yes or No]");
                        String newLocStr = scanner.nextLine();
                        validationResponse = validationContext.validate(newLocStr);
                        if (validationResponse.getErrors().size() == 0)
                            break;
                    }

                    if (ContinueValidationStrategy.isNo()) {
                        System.out.println("\nGoodbye.");
                        break;
                    } else {
                        allowRefresh = false;
                    }

                    // user enters a new location
                    System.out.println("Please enter a location: ");
                    location = scanner.nextLine();

                } // ContinueValidation if statement

            } // Allow refresh if statement

            else {
                // first run
                System.out.println("\nPlease enter a location: ");
                location = scanner.nextLine();
            }

        } // True Loop

        scanner.close();
    }

    /**
     * kicks off the weather workflow for a given location
     *
     * @param location
     */
    private static void startWeatherWorkflow(String location) {
        // validate location (strategy pattern)
        if (validLocation(location)) {
            allowRefresh = true;

            // getWeatherAndLocation
            LocationAndForecast locationAndForecast = getWeatherAndLocation(location);

            FullWeatherForecast fullWeatherForecast = locationAndForecast.getFullWeatherForecast();

            String mainConditions = fullWeatherForecast.getCurrent().getWeather().get(0).getMain();

            // set current conditions (observer pattern)
            setObserverCurrentConditions(mainConditions);

            // updateConditions view (model view controller pattern)
            updateView(locationAndForecast);

        } else {
            allowRefresh = false;
        }
    }

    /**
     * Updates the weather view in our [MVC pattern]
     *
     * @param locationAndForecast
     */
    private static void updateView(LocationAndForecast locationAndForecast) {
        model = new CurrentWeatherForecast();
        model.setLocationAndForecast(locationAndForecast);

        WeatherView view = new WeatherView();
        controller = new WeatherController(model, view);

        controller.updateView();

    }

    /**
     * sets the current condition in our [observer pattern]
     *
     * @param condition
     */
    private static void setObserverCurrentConditions(String condition) {
        Forecast forecast = new Forecast();
        new WeatherObserver(forecast);
        forecast.setCurrentWeatherConditions(condition);
    }

    /**
     * method that actually kicks off the GET request to the openweatherapi
     *
     * @param location
     * @return
     */
    private static LocationAndForecast getWeatherAndLocation(String location) {
        ForecastService forecastService = new ForecastServiceImpl();
        LocationAndForecast locationAndForecast = forecastService.getForecastAndLocation(location, "f");
        return locationAndForecast;
    }

    /**
     * validates the weather input to make sure it is valid text using our
     * [validation strategy pattern]
     *
     * @param location
     */
    private static boolean validLocation(String location) {
        if (allowRefresh)
            return true;
        ValidationResponse validationResponse = new ValidationContext(
                new ValidationStrategy[] { new WeatherAddressValidationStrategy() }).validate(location);

        if (validationResponse.getErrors().size() > 0) {
            return false;
        }
        return true;
    }

    public static void loadPreviousStates() {

        // If no previous data in the .txt file exist we display nothing
        if (CareTaker.fileIsEmpty())
            System.out.println("[No saved weather states..]");
        // If previous data in the .txt file exist, recreate the list
        // and attach it to the current list and then display it

        else
            CareTaker.readMementoFile();

        System.out.println();

    }

    public static boolean updateState() {

        ValidationContext validationContext = new ValidationContext(
                new ValidationStrategy[] { new ContinueValidationStrategy() });
        ValidationResponse validationResponse;

        Scanner scanLine = new Scanner(System.in);
        String saveState = "";
        boolean stateLoop = true;

        while (stateLoop) {
            System.out.println("Would you like to save the state? [Yes or No]");
            saveState = scanLine.nextLine();
            validationResponse = validationContext.validate(saveState);

            if (saveState.equalsIgnoreCase("Yes") || saveState.equalsIgnoreCase("Y")) {

                return true;
            } else if (saveState.equalsIgnoreCase("No") || saveState.equalsIgnoreCase("N")) {

                return false;
            }

        }

        return false;
    }

    public static void stateHandler(String weatherCondition, String dateAndTime, long currentSunRise) {

        if (weatherCondition.equals("Mist") || weatherCondition.equals("Rain") ||
                weatherCondition.equals("Thunderstorm")) {

            state = createWeatherState.request("Rain", dateAndTime, currentSunRise);

            weatherList.addMemento(state.createMemento());

        } else if (weatherCondition.equals("Snow")) {
            state = createWeatherState.request("Snow", dateAndTime, currentSunRise);

            weatherList.addMemento(state.createMemento());
        }

        else if (weatherCondition.equals("Sunny")) {

            state = createWeatherState.request("Sunny", dateAndTime, currentSunRise);

            weatherList.addMemento(state.createMemento());
        } else if (weatherCondition.equals("Clear")) {

            state = createWeatherState.request("Clear", dateAndTime, currentSunRise);

            weatherList.addMemento(state.createMemento());

        } else if (weatherCondition.equals("Clouds")) {
            state = createWeatherState.request("Clouds", dateAndTime, currentSunRise);

            weatherList.addMemento(state.createMemento());
        }
    }
}
