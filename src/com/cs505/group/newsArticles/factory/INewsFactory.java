package com.cs505.group.newsArticles.factory;
import com.cs505.group.newsArticles.articlehandler.*;

/* Author: Joseph Tanasi & Sean Oushana 
 * 
 * IArticleFactory: Is an interface that has a method for creating different IArticle Handlers.
 * 
 * create() - factory method that returns an object of type IArticle
 * 
 * 
 * 
 */

public interface INewsFactory {
	
	public IArticle create(String handlerType);

}
