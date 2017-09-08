package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Conrad on 09/09/2017.
 */

@Root(name = "category")
public class FlickrCategory {

    @Attribute
    private String term;

    @Attribute
    private String scheme;
}