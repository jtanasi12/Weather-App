package com.cs505.group.state;


/**
 * An interface that defines methods that the StateOriginator will provide implementation for.
 * These methods are in charge of handling a request to change the state. 
 * @author Sean Oushana & Joe
 *
 */


public interface IState {

	/**
	 * 
	 * @param state - the new state that we want to change to.
	 * @return - returns the new state after it has been created
	 */
	public StateOriginator handle(String newEvent, String dateAndTime, long currentSunRise);
	
	/**
	 * 
	 * @returns the String state.
	 */
	public  String stateToString();
	
	/**
	 * In charge of the GUI and loading the new image that represents the weathers state.
	 */
    public  void goToState();
}
