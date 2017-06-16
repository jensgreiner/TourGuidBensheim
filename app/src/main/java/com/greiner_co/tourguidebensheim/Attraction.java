package com.greiner_co.tourguidebensheim;

/**
 * Created by Jens Greiner on 16.06.17.
 */

public class Attraction {
    /**
     * Constant value that represents no image was provided for this attraction
     */
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final String NO_EVENT = "empty";

    // Attraction title
    private final String mAttractionTitle;

    // Attraction details
    private final String mAttractionDetails;

    // Event day
    private String mEventDay = NO_EVENT;

    // Event month
    private String mEventMonth = NO_EVENT;

    // Attraction image as drawable resource ID
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    // Constructors

    /**
     * Creates a new Attraction object
     *
     * @param title   is the title or name of the attraction
     * @param details is the detailed description of the given attraction
     */
    public Attraction(String title, String details) {
        mAttractionTitle = title;
        mAttractionDetails = details;
    }

    /**
     * Overloaded constructor to create a Attraction object with an image
     */
    public Attraction(String title, String details, int imageResourceId) {
        mAttractionTitle = title;
        mAttractionDetails = details;
        mImageResourceId = imageResourceId;
    }

    /**
     * Overloaded constructor to create a Attraction object with an date (events)
     */
    public Attraction(String title, String details, String day, String month) {
        mAttractionTitle = title;
        mAttractionDetails = details;
        mEventDay = day;
        mEventMonth = month;
    }

    /**
     * Overloaded constructor to create a Attraction object with an image
     */
    public Attraction(String title, String details, String day, String month, int imageResourceId) {
        mAttractionTitle = title;
        mAttractionDetails = details;
        mEventDay = day;
        mEventMonth = month;
        mImageResourceId = imageResourceId;
    }

    public String getmAttractionTitle() {
        return mAttractionTitle;
    }

    public String getmAttractionDetails() {
        return mAttractionDetails;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmEventDay() {
        return mEventDay;
    }

    public String getmEventMonth() {
        return mEventMonth;
    }

    /**
     * Returns whether or not there is an event for this attraction.
     *
     * @return true if there is an image resource id set and false, if not
     */
    // Public methods
    public boolean isEvent() {
        return (mEventDay != NO_EVENT && mEventMonth != NO_EVENT);
    }

    /**
     * Returns whether or not there is an image for this attraction.
     *
     * @return true if there is an image resource id set and false, if not
     */
    // Public methods
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "mAttractionTitle='" + mAttractionTitle + '\'' +
                ", mAttractionDetails='" + mAttractionDetails + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                '}';
    }
}
