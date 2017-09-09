package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import android.util.Log;

import com.conradcrates.tigerspiketechnicalchallenge.rest.RestClientFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Conrad on 09/09/2017.
 */

public class FlickrRestHandler {

    public static void getFlickrFeed(final FlickrCallback callback) {
        RestClientFactory.getInstance().getRestClient().getFeed().enqueue(new Callback<FlickrFeed>() {
            @Override
            public void onResponse(Call<FlickrFeed> call, Response<FlickrFeed> response) {
                if(callback != null){
                    callback.onResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<FlickrFeed> call, Throwable t) {
                Log.e("", t.getLocalizedMessage());
            }
        });
    }
}