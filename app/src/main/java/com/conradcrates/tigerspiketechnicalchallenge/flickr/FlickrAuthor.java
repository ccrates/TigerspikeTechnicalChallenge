package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by Conrad on 09/09/2017.
 */

@Root(name = "author")
public class FlickrAuthor {

    @Element
    private String name;

    @Element
    private String uri;

    @Element(name = "nsid")
    private String flickrNSID;

    @Element(name = "buddyicon")
    private String flickrBuddyIcon;

    public String getFlickrNSID() {
        return flickrNSID;
    }
}
