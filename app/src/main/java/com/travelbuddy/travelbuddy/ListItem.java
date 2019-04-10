package com.travelbuddy.travelbuddy;

public class ListItem {

    private String mHeading;
    private String mDescription;
    private String mImageURL;
    private String mDetailURL;

    public ListItem(String mHeading, String mDescription, String mImageURL, String mDetailURL) {
        this.mHeading = mHeading;
        this.mDescription = mDescription;
        this.mImageURL = mImageURL;
        this.mDetailURL = mDetailURL;
    }

    public String getmHeading() {
        return mHeading;
    }

    public void setmHeading(String mHeading) {
        this.mHeading = mHeading;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmImageURL() {
        return mImageURL;
    }

    public void setmImageURL(String mImageURL) {
        this.mImageURL = mImageURL;
    }

    public String getmDetailURL() {
        return mDetailURL;
    }

    public void setmDetailURL(String mDetailURL) {
        this.mDetailURL = mDetailURL;
    }
}
