package com.cs505.group.newsArticles.articlefinder;


import com.cs505.group.newsArticles.articlehandler.*;
import com.cs505.group.newsArticles.exception.*;


/** Author: Sean Oushana & Joseph Tanasi 
   Class: ArticleFinder is where the client passes the address to and the amount of articles that 
   we want the News API to fetch back to the client.
   
   ArticleFinder allows the client to chain together the order of article handlers.
   We will pull all the articles into a particular handler such as the CityHandler and, depending on the order 
   of handlers, if the News API runs out of articles to provide and we have requested more articles to search for, we 
   will go to the next handler in the chain until there are no more handlers or we have met our request. 
   
   If go through our entire chain of handlers and we are still looking for more articles we will get a OutOfArticlesException.
 */
public class ArticleFinder {

	protected String address;
	protected int numOfArticles;
	
	
	/** This will keep track of the handlers that are chained together.
	   articleHandler will always point to the last handler added 
	    it can be thought of as a tail.
	    */
	protected IArticle articleHandler = null;
	
	// A pointer to the first handler added to the chain 
	protected IArticle head = null;
	
	/** 
	 * @param address - the address we want the news articles to be based off of.
	 * @param numOfArticles - the number of articles that we want the News API to fetch.
	 */
	public ArticleFinder(String address, int numOfArticles) {
		this.address = address;
		this.numOfArticles = numOfArticles;
	}
	
	/**
	 * 
	 * @returns the address
	 */
	public String getAddress() {
		return this.address;
	}
	
	/** 
	 * Add a link to the chain, or add a handler to the chain
	   @param newHandler - is the next IArticle object we are adding to the chain
	  */
	public void addHandler(IArticle newHandler) {
		
		// If articleHandler is not empty, we attach the handler 
		// to the articleHandlers successor
		if(articleHandler != null) {
			
		articleHandler.setNextHandler(newHandler);
		articleHandler = newHandler;
	
		
		}
		else
		{
			// If the articleHandler is empty, articleHandler will point to this new object
			// and it's successor is still set to null.
			articleHandler = newHandler;
			
			// Since this is the first handler added to the chain, head will point to this object.
			head = newHandler;
		
		}
		
		// We then pass the address/numOfArticles information into the handlers. 
		articleHandler.setAddress(address);
		articleHandler.setNumOfArticles(numOfArticles);
		
	}

	/** Iterate through all of the handlers 
	 * 
	 */
	public void displayHandlers() {
		
		IArticle temp = head;
		
		while(temp != null) {
			System.out.println(temp);
			temp = temp.getNext();
		}
	}
 
	/* Displays the first Handler object
	   If the articleHandler is null we throw an exception
	 */
	public void displayHead() {
		
		try {
			if(articleHandler == null)
				throw new EmptyHandlersException("Empty List");
			
		System.out.println(head);
		
		}
		catch(EmptyHandlersException e) {
			e.printStackTrace();
		}
		
	
	}
	
	/** This method is responsible for searching for news articles from the API
	 * 
	 * @return - will return true if the search is a success and false if we run out of articles 
	 * and requested to search and retrieve more articles.
	 */
	public boolean makeSearch() {
		try 
		{
			/** call searchList() on the first object in the list 
			 Inside of searchList() it will call other links/Handlers if need be which will
			 continue calling searchList(). If an exception instead of any of these searchList() occurs
			 it will propagate back to this method where the exception is dealt with a try/catch block.
			 */
			head.searchList();
		}
		catch(OutOfArticlesException e){
			
			System.out.println(e.getMessage());
			return false;
		}
		
		return true;
	}
	
	
	/* This will iterate through all the Handlers that are chained together
	   Each handler will then iterate through the news articles stored in articleList.
	 */
	public String toString() {
		
		// NEEDS IMPLEMENTATION 
		
		return null;
	}

}
