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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        images = (RecyclerView)findViewById(R.id.list_images);
        images.setAdapter(new FlickrAdapter(null));
        images.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();
        FlickrRestHandler.getFlickrFeed(new FlickrCallback() {
            @Override
            public void onResponse(FlickrFeed flickrFeed) {
                images.setAdapter(new FlickrAdapter(flickrFeed));
            }
        });
    }
}