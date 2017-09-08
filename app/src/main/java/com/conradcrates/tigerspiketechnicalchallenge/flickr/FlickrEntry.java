package com.conradcrates.tigerspiketechnicalchallenge.flickr;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by Conrad on 08/09/2017.
 */

@Root(name = "entry", strict = false)
public class FlickrEntry {

    @Element
    private String title;

    @ElementList(name = "link", inline = true)
    private List<FlickrLink> links;

    @Element
    private String id;

    @Element
    private String published;

    @Element
    private String updated;

    @Element(name = "flickr:date_taken", required = false)
    private String flickrDateTaken;

    @Element(name = "dc:date.Taken", required = false)
    private String dcDateTaken;

    @Element
    private String content;

    @Element
    private FlickrAuthor author;

    @ElementList(name = "category", inline = true)
    private List<FlickrCategory> categories;

    @Element(name = "displaycategories")
    private String displayCategories;
}