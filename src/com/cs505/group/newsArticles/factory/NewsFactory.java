package com.cs505.group.newsArticles.factory;


import com.cs505.group.newsArticles.articlehandler.*;;

/* Author: Joseph Tanasi & Sean Oushana
 * 
 * Class: NewsFactory implements INewsFactory 
 * 
 * The create() - allows the user to create each of the three handler objects (city, state, country)
 */
public class NewsFactory implements INewsFactory{

	/*
	 * @param handlerType - the type of handler we want to create 
	 */
	@Override 
	public IArticle create(String handlerType) {
		
		if(handlerType.equalsIgnoreCase("city")){
			return new CityHandler();
		}
		
		else if(handlerType.equalsIgnoreCase("state"))
		{
			return new StateHandler();
		}
		else if (handlerType.equalsIgnoreCase("country")) {
			return new CountryHandler();
		}
		else {
			// Default CityHandler
			
			return new CityHandler();
		}
	}

}
