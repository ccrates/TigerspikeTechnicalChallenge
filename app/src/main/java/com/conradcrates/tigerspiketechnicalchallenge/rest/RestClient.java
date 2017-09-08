package com.conradcrates.tigerspiketechnicalchallenge.rest;

import com.conradcrates.tigerspiketechnicalchallenge.flickr.FlickrFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Conrad on 27/06/2017.
 */

public interface RestClient {

    @GET("/services/feeds/photos_public.gne")
    Call<FlickrFeed> getFeed();
}