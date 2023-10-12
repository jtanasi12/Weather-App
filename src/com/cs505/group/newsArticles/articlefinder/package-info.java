//Author: Sean Oushana & Joseph Tanasi 

/*
 * Class: ArticleFinder is where the client passes the address to and the amount of articles that 
   we want the News API to fetch back to the client.
   
   ArticleFinder allows the client to chain together the order of article handlers.
   We will pull all the articles into a particular handler such as the CityHandler and, depending on the order 
   of handlers, if the News API runs out of articles to provide and we have requested more articles to search for, we 
   will go to the next handler in the chain until there are no more handlers or we have met our request. 
 */
package com.cs505.group.newsArticles.articlefinder;