package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * Created by Conrad on 08/09/2017.
 */

@Root(name = "link")
public class FlickrLink {

    @Attribute
    private String rel;

    @Attribute(name = "type", required = false)
    private String type;

    @Attribute
    private String href;
}