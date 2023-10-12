package com.cs505.group.newsArticles.articlehandler;

import com.cs505.group.newsArticles.exception.*;

/*   Author: Sean Oushana & Joseph Tanasi 

 *   Class Description: The CityHandler class is a specialization of the ArticleProduct class.
     This class will fetch city-level news articles related to the address that is stored. If the CityHandler 
     runs out of articles and we still have requested more articles we will call the next link in the chain.
 */

public class CityHandler extends ArticleProduct{

	public CityHandler() {
		articleType = "City Handler";
	}

	
	/* searchList() calls the News API and fetches city-level news articles related to the address passed and stores the articles
	    inside of articleList  
	 */
	public String searchList() throws OutOfArticlesException {
		return "City Article by Sean";
	}


	public String toString() {
		CityHandler city = new CityHandler();
		try {
			return city.searchList();
		} catch (OutOfArticlesException e) {
			System.out.println("Error with City Handler's toString() method");
			throw new RuntimeException(e);
		}
	}

	/* Iterate through the news articles that we fetched from the API
	    Iterates through the articleList Array List
	    */
     public void iterateList() {
	
		   
		   // NEEDS IMPLEMENTATION
     }
	
 
}
	
