package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Conrad on 08/09/2017.
 */

@Root(name = "feed")
public class FlickrFeed {

    @Element
    private String title;

    @ElementList(name = "link", inline = true)
    private List<FlickrLink> links;

    @Element
    private String id;

    @Element
    private String icon;

    @Element(required = false)
    private String subtitle;

    @Element
    private String updated;

    @Element
    private String generator;

    @ElementList(name = "entry", inline = true)
    private List<FlickrEntry> entries;

    public String getTitle() {
        return title;
    }

    public List<FlickrEntry> getEntries() {
        return entries;
    }
}