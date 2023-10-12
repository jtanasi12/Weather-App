package com.cs505.group.newsArticles.exception;

//Author Joseph Tanasi 


/*
* Extends Exception class and is used when trying to iterate through
* the articlesList and it is null.
*/

public class OutOfArticlesException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public OutOfArticlesException (String message){
		
		super(message);
	}
	

}
