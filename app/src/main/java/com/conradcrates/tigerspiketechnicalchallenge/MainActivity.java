package com.conradcrates.tigerspiketechnicalchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.conradcrates.tigerspiketechnicalchallenge.flickr.FlickrFeed;
import com.conradcrates.tigerspiketechnicalchallenge.rest.RestClientFactory;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RestClientFactory.getInstance().getRestClient().getFeed().enqueue(feedCallback);
    }

    Callback<FlickrFeed> feedCallback = new Callback<FlickrFeed>() {
        @Override
        public void onResponse(Call<FlickrFeed> call, Response<FlickrFeed> response) {
            Log.d("", response.body().toString());
        }

        @Override
        public void onFailure(Call<FlickrFeed> call, Throwable t) {
            Log.e("", t.getLocalizedMessage());
        }
    };
}