package com.cs505.group.state;

/**
 * Author: Sean Oushana
 * Class Description: Context class has a request method that gets called when there's a state change and is
 * passing the StateOriginator object that we want to create.
 */


public class Context {
    
    private StateOriginator state; // Reference pointer to a state Object (Delegation)
    
    public Context() {
    	state = new RainState(" "); // Default State. This doesn't get added to the Memento List
    	// Once we first make a change this is essentially erased
    }

    /**
     * The request method when we want to change the state dynamically.
     * @param state - the state that we want to switch to. 
     * @return - returns the new state after it has been created.
     */
    
    public String getCurrentState() {
    	return state.toString();
    	
    }
 
    public StateOriginator request(String newEvent, String dateAndTime, long currentSunRise){

        this.state = state.handle(newEvent, dateAndTime, currentSunRise);
        this.state.goToState();
        
        return state;
    }
    
    /**
     * Prints out the state method
     */
    public String toString() {
    	String result = "";
    	
    	result = state.stateToString();
    	
    	return result;
    }
}