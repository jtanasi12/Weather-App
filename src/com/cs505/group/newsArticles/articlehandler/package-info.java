
/*
 * This package contains everything that relates to the Articles that we want to pull.
 * 
 * Interface: IArticle - This is an interface that defines methods for ArticleProduct to provide implementation
 * Class: ArticleProduct - is an abstract class that generalizes the CityHandler, StateHandler, and CountryHandler classes.
 * ArticleProduct utilizes the COR design pattern and has a pointer to the next IAticle Object.
 * This will create a chain of type ArticleProduct objects. EX: [city]--->[state]-->[country].
 * 
 * 
 *    Class CityHandler: class is a specialization of the ArticleProduct class.
     This class will fetch city-level news articles related to the address that is stored. If the CityHandler 
     runs out of articles and we still have requested more articles we will call the next link in the chain.
     
     Class CountryHandler: class is a specialization of the ArticleProduct class.
     This class will fetch country-level news articles relevant to the nationwide level. If the CountryHandler 
     runs out of articles and we still have requested more articles we will call the next link in the chain.
     
     
     Class CountryHandler: class is a specialization of the ArticleProduct class.
     This class will fetch state-level news articles from the news API. If the StateHandler 
     runs out of articles and we still have requested more articles we will call the next link in the chain.
 */


package com.cs505.group.newsArticles.articlehandler;