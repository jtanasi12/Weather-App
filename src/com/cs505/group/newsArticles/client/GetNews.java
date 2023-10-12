package com.cs505.group.newsArticles.client;

import com.cs505.group.newsArticles.articlefinder.*;
import com.cs505.group.newsArticles.articlehandler.*;
import com.cs505.group.newsArticles.factory.*;



//Author: Sean Oushana & Joseph Tanasi

/* Class Description: The GetNews class is the client class that allows us to create the address, the amount of articles 
 * that we want to request from the News API, and specify the type of news articles that we want (city, state, country).
 * 
 * The client can build a chain of newsHandlers that specify different types of news. The client is able to create any order
 * of newsHandlers that he/she wants. Example: Client has an address and is requesting 5000 news articles starting off at the city-level.
 * When the city-level runs out the client has set it up where state level articles will be pulled and when that runs out, country-level news
 * articles will be pulled.
 * 
 */


public class GetNews {
  
    public void getNews(String address) {

        // 2. Pass the address that we want to find and the amount of articles which is 3 in this case.
        // Now the Handlers that we want to chain to specify the order of handlers
        ArticleFinder ctSearch = new ArticleFinder(address, 3);

        // 3. Create the NewsFactory so we can start creating handlers
        INewsFactory newsArticles = new NewsFactory();

        // 4. Create CityHandler
        IArticle cityHandler  = newsArticles.create("city");

        // 5. Create StateHandler
        IArticle stateHandler = newsArticles.create("State");

        // 6. Create CountryHandler
        IArticle countryHandler = newsArticles.create("Country");

// 7. Pass the handlers to the search object
        ctSearch.addHandler(stateHandler);
        ctSearch.addHandler(cityHandler);
        ctSearch.addHandler(countryHandler);

        // TEST 1: Display a list of the handlers
        ctSearch.displayHandlers();

        System.out.println(ctSearch.getAddress());
    }
}
