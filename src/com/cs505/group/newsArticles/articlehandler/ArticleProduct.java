package com.cs505.group.newsArticles.articlehandler;


import com.cs505.group.newsArticles.exception.OutOfArticlesException;
import  com.cs505.group.main.iterator.*;

//Author: Sean Oushana & Joseph Tanasi 
/*
 * 
 * ArticleProduct is an abstract class that generalizes the CityHandler, StateHandler, and CountryHandler classes.
 * ArticleProduct utilizes the COR design pattern and has a pointer to the next IAticle Object.
 * This will create a chain of type ArticleProduct objects. EX: [city]--->[state]-->[country].
 * 
 * articleList will store the news articles for a particular handler inside an ArrayList data structure.
 * For example: articleList would store all the local city news articles that are fetched from the News API inside CityHandler.
 */

public abstract class ArticleProduct implements IArticle{
	
	  // nextHandler is the successor that will point to the next handler 
	  // EX: nextHandler = new StateHandler()
	  protected IArticle nextHandler = null; 
	  
	  // Used to store news articles inside an ArrayList data structure 
	  protected IList articleList;
	  
	  protected String address;
	  protected int numOfArticles;
	  protected String articleType;

	  // Address Getter()
	  public String getAddress() {
		  return this.address;
	  }
	  
	  // numOfAritcles Getter() 
	  public int getNumOfArticles() {
		  return this.numOfArticles;
	  }
	    
	  // Sets the address that we want to use when fetching for news articles.
	  public void setAddress(String address) {
		  this.address = address;
	  }
	  
	  // The number of articles that we want to grab from the News API 
	  public void setNumOfArticles(int numOfArticles) {
		  this.numOfArticles = numOfArticles;
	  }
	   //Sets the successor handler. This creates the chain.
	   public void setNextHandler(IArticle nextHandler) {
		   this.nextHandler = nextHandler;
	   }
	   
	   // Returns the successor handler 
	   public IArticle getNext() {
		  return this.nextHandler;
	   }
	   
	   // Returns the type of ArticleProduct object (CityHandler, StateHandler, CountryHandler)
	   public String getArticleType() {
		   return this.articleType;
	   }
	   
	
	   /* searchList() calls the News API and fetches the news articles and stores the articles
	    */
	   public abstract String searchList() throws OutOfArticlesException;
	   
	   /* Iterate through the news articles that we fetched from the API
	      Iterates through the articleList Array List
	    */
	   public abstract void iterateList();
	   
}
