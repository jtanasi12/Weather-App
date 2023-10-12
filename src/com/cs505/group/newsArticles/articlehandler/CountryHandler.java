package com.cs505.group.newsArticles.articlehandler;

import com.cs505.group.newsArticles.exception.*;


/*   Author: Sean Oushana & Joseph Tanasi 

 *   Class Description: The CountryHandler class is a specialization of the ArticleProduct class.
     This class will fetch country-level news articles relevant to the nationwide level. If the CountryHandler 
     runs out of articles and we still have requested more articles we will call the next link in the chain.
 */

public class CountryHandler extends ArticleProduct{

	public CountryHandler() {
		articleType = "Country Handler";
	}
	public String toString() {
		CountryHandler country = new CountryHandler();
		try {
			return country.searchList();
		} catch (OutOfArticlesException e) {
			System.out.println("Error with Country Handler's toString() method");
			throw new RuntimeException(e);
		}
	}
	
	
	/* searchList() calls the News API and fetches country-level news articles related to the address passed and stores the articles
	   inside of articleList 
	 */
	public String searchList() throws OutOfArticlesException {
			return "country Article by Sean";
		}
		
		
	/* Iterate through the news articles that we fetched from the API
	   Iterates through the articleList Array List
	 */
	public void iterateList() {
		 System.out.println("Country Articles: ");
		 
		   // NEEDS IMPLEMENTATION

	}
	
  
}
