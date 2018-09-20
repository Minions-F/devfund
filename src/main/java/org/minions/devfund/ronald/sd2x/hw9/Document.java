package org.minions.devfund.ronald.sd2x.hw9;

import java.util.Date;

/**
 * @author bsronald on 9/20/18.
 */
public abstract class Document {
    private String title;
    private String author;
    private Date date;
    private PublishingLocation publishingLocation;


    public Document(Date date, String title, String author, String city, String state, String postCode) {
        this.date = date;
		this.publishingLocation = new PublishingLocation(city, state, postCode);
        this.title = title;
		this.author = author;
    }


    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
    }

    public String getCity() {
        return publishingLocation.getCity();
    }

    public String getState() {
        return publishingLocation.getState();
    }

    public String getPostCode() {
        return publishingLocation.getPostCode();
    }


    public boolean sameAuthor(Document document) {

        return this.author.equals(document.author);

    }

    public int compareDates(Document document) {

        return this.date.compareTo(document.date);
    }

    public int compareWithGeneralDate(Date date){
        return this.date.compareTo(date);
    }

}
