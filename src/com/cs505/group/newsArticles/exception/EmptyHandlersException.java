package com.cs505.group.newsArticles.exception;

//Author: Joseph Tanasi 

/*
 * Extends Exception class and is used when trying to iterate through
 * the Handler chain and the chain is null.
 */
public class EmptyHandlersException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmptyHandlersException(String message){
		
		super(message);
	
	}
}
