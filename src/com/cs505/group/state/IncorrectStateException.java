package com.cs505.group.state;

/**
 * This class extends Exception and is called when a state that doesn't exist is called.
 * @author Joseph Tanasi
 *
 */
public class IncorrectStateException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public IncorrectStateException (String message){
		
		super(message);
	}

}



