package com.conradcrates.tigerspiketechnicalchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.conradcrates.tigerspiketechnicalchallenge.flickr.FlickrAdapter;
import com.conradcrates.tigerspiketechnicalchallenge.flickr.FlickrCallback;
import com.conradcrates.tigerspiketechnicalchallenge.flickr.FlickrFeed;
import com.conradcrates.tigerspiketechnicalchallenge.flickr.FlickrRestHandler;

public class MainActivity extends AppCompatActivity {

    private RecyclerView images;
    private boolean refreshFeed = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = (RecyclerView)findViewById(R.id.list_images);
        images.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

        if(savedInstanceState != null){
            refreshFeed = false;
            images.setAdapter(new FlickrAdapter(FlickrRestHandler.getCurrentFeed()));
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(refreshFeed) {
            FlickrRestHandler.getFlickrFeed(new FlickrCallback() {
                @Override
                public void onResponse(FlickrFeed flickrFeed) {
                    images.setAdapter(new FlickrAdapter(flickrFeed));
                }
            });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        refreshFeed = true;
    }
}