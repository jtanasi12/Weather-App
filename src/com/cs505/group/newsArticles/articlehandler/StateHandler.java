package com.cs505.group.newsArticles.articlehandler;

import com.cs505.group.newsArticles.exception.*;



/*   Author: Sean Oushana & Joseph Tanasi 

 *   Class Description: The CountryHandler class is a specialization of the ArticleProduct class.
     This class will fetch state-level news articles from the news API. If the StateHandler 
     runs out of articles and we still have requested more articles we will call the next link in the chain.
 */

public class StateHandler extends ArticleProduct{
 
	public StateHandler() {
		articleType = "State Handler";
	}
    public String toString() {
		StateHandler state = new StateHandler();
		try {
			return state.searchList();
		} catch (OutOfArticlesException e) {
			System.out.println("Error with State Handler's toString() method");
			throw new RuntimeException(e);
		}
    }
   
    
	/* searchList() calls the News API and fetches state-level news articles related to the address passed and stores the articles
	 * inside of articleList
	 */
	public String searchList() throws OutOfArticlesException {
		return "state Article by Sean";
	}
		
		
	/* Iterate through the news articles that we fetched from the API
	 *  Iterates through the articleList Array List
	 */
	public void iterateList() {
		 System.out.println("State Articles: ");
		 
	}
	
}
