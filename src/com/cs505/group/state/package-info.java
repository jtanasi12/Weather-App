
/**
 * This package contains everything that relates to the state of the weather.
 * This packages uses two design patterns - the State Pattern and the Memento Pattern. 
 *  
 *  IState - defines methods that the StateOriginator will provide implementation for. These methods
 *  revolves around handling a request to change the state of the weather.
 *  
 *  StateOriginator - Provides implementation for IState and handles the request to make a change to the state.
 *  It has an internal class Memento.
 *  
 *  Memento - The internal class inside of StateOriginator and is in charge of creating copies of every state change.
 *  
 *  
 *  RainState, SnowState, SunState, and NightState - extend the StateOriginator and provide implementation for each state.
 *  For example: SnowState is defined with a string that lets us know it is in fact a snow state and will load a snow image.
 *  
 *  Context - is a class that handles the flow of when a request is made to change the state. We will dynamically call 
 *  the appropriate State class to handle the request and then load the appropriate image.
 *  
 *  CareTaker - is the class that stores all the Mementos Object(Copies of the states when created). We store up to 10 copies 
 *  and then delete from the front of the list and add to the back of the list when we exceed that threshold. 
 *  
 *  OutOfBoundsException -  Extends the Exception class and is called when we are requesting an index inside an ArrayList that is out of bounds.

 *  IncorrectStateException -  This class extends Exception and is called when a state that doesn't exist is called.

 */


package com.cs505.group.state;