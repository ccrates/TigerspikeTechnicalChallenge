package com.conradcrates.tigerspiketechnicalchallenge.rest;

import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

/**
 * Created by Conrad on 27/06/2017.
 */

public class RestClientFactory {

    private static RestClientFactory instance;

    public static RestClientFactory getInstance(){
        if(instance == null){
            instance = new RestClientFactory();
        }
        return instance;
    }

    private RestClientFactory(){

    }


    private RestClient client;

    public RestClient getRestClient(){
        if(client != null){
            return client;
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.flickr.com/")
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        client = retrofit.create(RestClient.class);
        return client;
    }
}