package com.conradcrates.tigerspiketechnicalchallenge.gallery;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.conradcrates.tigerspiketechnicalchallenge.R;

/**
 * Created by Conrad on 09/09/2017.
 */

public class GalleryViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;

    public GalleryViewHolder(View view){
        super(view);

        image = (ImageView)view.findViewById(R.id.image_image);
    }

    public ImageView getImage() {
        return image;
    }
}