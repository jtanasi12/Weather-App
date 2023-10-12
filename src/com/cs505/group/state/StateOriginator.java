package com.cs505.group.state;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Author: Sean Oushana & Joseph Tanasi
 * 
 * Interface Description: Interface State is the interface that will be integrated with the 
 * Observer pattern, and will take in the datum of the weather outside (sun, night, 
 * rain, or snow) and will change the background accordingly
 * @throws IOException
 */
public abstract class StateOriginator implements IState{

	protected String stateType;
 
	
    /**
     * Basic Constructor
     */
    public StateOriginator() {
    	stateType = null;
    }
    
    /**
     * 
     * @param memento - As soon as we create the object we want to automatically transfer the information
     * to a Memento object.
     */
    public StateOriginator(Memento memento) {
    	stateType = memento.getTransferrableInfo();
    }
	 
    /**
     * @return - returns a string that holds the current state.
     */
	 public String toString() {
		 
		 return stateToString();
	 }
	  /** 
     * Handle takes no parameter and is an implementation of the State interface's handle method.
     * It goes into the template.html file and sets the image source attribute to be the path to 
     * the sun image.
     * @param state
     * @see StatePattern#handle()
     */
 	public StateOriginator handle(String newEvent, String dateAndTime, long currentSunRise) {
     
 		
 		try {
 			
 		
 		if(newEvent.equals("Rain")) {
 			return new RainState(dateAndTime);
 		}
 		else if(newEvent.equals("Snow")) {
 			return new SnowState(dateAndTime);
 		}
 		else if(newEvent.equals("Sunny")) {
 			return new SunState(dateAndTime);
 		}
 		else if(newEvent.equals("Clouds")) {
 			return new CloudState(dateAndTime);
 		}
 		else if(newEvent.equals("Clear")) {
 			
 			// If Day Time 
 			Calendar calendar = Calendar.getInstance();
 			calendar.setTimeInMillis(currentSunRise);
 			
 			int h = calendar.get(Calendar.HOUR_OF_DAY);
 			int m = calendar.get(Calendar.MINUTE);
 			// If Night Time 
 			
 			Calendar calendar2 = GregorianCalendar.getInstance(); 
 			if(h == calendar2.get(Calendar.HOUR_OF_DAY) && m == calendar2.get(Calendar.MINUTE)) {
 			 
 				return new SunState(dateAndTime);
 			}
 			else {
 				 
 				return new NightState(dateAndTime);
 			}
 				
 			
 		}
 		else {
           throw new IncorrectStateException("This is not a correct state type");
 		}
 		}
 		catch(IncorrectStateException e) {
    		e.printStackTrace();
    		return null;
    	}

    	
    }
 	
    /** Create a new Memento / create a copy of the Originator 
 	  by copying the state into the Memento object
 	  */
 	public Memento createMemento() {
 		return new Memento(stateType);
 	} 
    
 
 /** Pass the Memento object that we want to restore 
  * 
  */
 	public String restoreFromMemento(Memento memento) {
 		
 		stateType = memento.getTransferrableInfo();
 		 		
 		return stateType;
 	}
 	
    /**
     * Static Internal Class for the StateOriginator 
     */
    public static class Memento{
    	
    	
    	// We need to have a replication of the internal state of 'State'
    	// In other words States attributes need to be copied over
    	private String stateType;
    	
    	/**
    	 * Constructor - copy over the attributes for State to Memento 
    	 */
    	public Memento(String stateType) {
    		setTransferrableInfo(stateType);
    	}
    	
    	
    	/**
    	 * Retrieve the Mementos internal state
    	 */
    	private String getTransferrableInfo() {
			return stateType;
		}

    	/**
    	 * Copies over States internal attributes to the Memento object
    	 */
    	private void setTransferrableInfo(String stateType) {
    		this.stateType = stateType;
    	}
    	
    	@Override
		public String toString() {
			return stateType;
		}

    }
}