package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.conradcrates.tigerspiketechnicalchallenge.R;
import com.conradcrates.tigerspiketechnicalchallenge.gallery.GalleryViewHolder;

import java.util.List;

/**
 * Created by Conrad on 09/09/2017.
 */

public class FlickrAdapter extends RecyclerView.Adapter {

    private FlickrFeed feed;

    public FlickrAdapter(FlickrFeed feed){
        this.feed = feed;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_gallery, parent, false);
        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof GalleryViewHolder){
            GalleryViewHolder vh = (GalleryViewHolder)holder;

            List<FlickrLink> links = feed.getEntries().get(position).getLinks();

            for (FlickrLink link : links){
                if(link.getType().contains("image")){
                    Glide.with(vh.itemView.getContext())
                            .load(link.getHref())
                            .into(vh.getImage());
                }
            }
        }
    }

    @Override
    public int getItemCount() {
        if(feed == null){
            return 0;
        }
        return feed.getEntries().size();
    }
}