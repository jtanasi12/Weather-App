package com.cs505.group.newsArticles.articlehandler;
import com.cs505.group.newsArticles.exception.*;

/*
 * Authors: Joseph Tanasi & Sean Oushana
 * 
 * Interface: IArticle - This is an interface that defines methods for ArticleProduct to provide implementation
 * 
 *
 */
public interface IArticle {

	  
	  // Address Getter()
	  public String getAddress();
	  
	  // numOfAritcles Getter() 
	  public int getNumOfArticles();
	    
	  // Sets the address that we want to use when fetching for news articles.
	  public void setAddress(String address);
	  
	  // The number of articles that we want to grab from the News API 
	  public void setNumOfArticles(int numOfArticles);
	   //Sets the successor handler. This creates the chain.
	   public void setNextHandler(IArticle nextHandler);
	   // Returns the successor handler 
	   public IArticle getNext();
	   
	   // Returns the type of ArticleProduct object (CityHandler, StateHandler, CountryHandler)
	   public String getArticleType();
	   
	   /* searchList() calls the News API and fetches the news articles and stores the articles
	     inside of articleList
	    */
	   public String searchList() throws OutOfArticlesException;
	   
	   /* Iterate through the news articles that we fetched from the API
	   Iterates through the articleList Array List
	    */
	   public void iterateList();

}
