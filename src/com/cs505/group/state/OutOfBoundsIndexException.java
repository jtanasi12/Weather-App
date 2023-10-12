package com.cs505.group.state;


/**
 * Extends the Exception class and is called when we are requesting an index inside an ArrayList that is out of bounds.
 * @author Joseph Tanasi
 *
 */
public class OutOfBoundsIndexException extends Exception{

private static final long serialVersionUID = 1L;
	
	public OutOfBoundsIndexException (String message){
		
		super(message);
	}

}



