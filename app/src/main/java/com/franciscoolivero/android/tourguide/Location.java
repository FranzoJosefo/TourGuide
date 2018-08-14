package com.franciscoolivero.android.tourguide;

import android.net.Uri;

import java.util.ArrayList;

/**
 * Created by franciscoolivero on 6/4/18.
 * {@link Location} Represents a given location the user wants to know about
 * It contains it's name, address, business hour, Image if available.
 */

public class Location {
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final ArrayList NO_MULTIPLE_BUSINESS_HOURS = null;
    private static final String NO_BUSINESS_HOURS = null;
    private String mName;
    private String mDescription;
    private String mAddress;
    private String mBusinessHour = NO_BUSINESS_HOURS;
    private ArrayList mBusinessHourArray = NO_MULTIPLE_BUSINESS_HOURS;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private Uri mGeoLocation = null;

    public Location(String mName, String mDescription, String mAddress, Uri mGeoLocation) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mGeoLocation = mGeoLocation;
    }

    public Location(String mName, String mDescription, String mAddress, int mImageResourceId, Uri mGeoLocation) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mImageResourceId = mImageResourceId;
        this.mGeoLocation = mGeoLocation;
    }

    public Location(String mName, String mDescription, String mAddress, int mImageResourceId) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mImageResourceId = mImageResourceId;
    }

    public Location(String mName, String mDescription, String mAddress) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
    }

    public Location(String mName, String mDescription, String mAddress, String mBusinessHour, Uri mGeoLocation) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mBusinessHour = mBusinessHour;
        this.mGeoLocation = mGeoLocation;
    }

    public Location(String mName, String mDescription, String mAddress, ArrayList mBusinessHourArray, Uri mGeoLocation) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mBusinessHourArray = mBusinessHourArray;
        this.mGeoLocation = mGeoLocation;
    }

    public Location(String mName, String mDescription, String mAddress, ArrayList mBusinessHourArray, int mImageResourceId, Uri mGeoLocation) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mBusinessHourArray = mBusinessHourArray;
        this.mImageResourceId = mImageResourceId;
        this.mGeoLocation = mGeoLocation;
    }

    public Location(String mName, String mDescription, String mAddress, String mBusinessHour, int mImageResourceId, Uri mGeoLocation) {
        this.mName = mName;
        this.mDescription = mDescription;
        this.mAddress = mAddress;
        this.mBusinessHour = mBusinessHour;
        this.mImageResourceId = mImageResourceId;
        this.mGeoLocation = mGeoLocation;
    }


    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmDescription() {
        return mDescription;
    }

    public String getmName() {
        return mName;
    }

    public Uri getmGeoLocation() {
        return mGeoLocation;
    }

    public String getmBusinessHour() {
        return mBusinessHour;
    }

    public ArrayList getmBusinessHourArray() {
        return mBusinessHourArray;
    }

    public String getmAddress() {
        return mAddress;
    }

    /**
     * @return Returns whether there is or not an image for this location.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * @return Returns whether there is or there are multiple Business hours for this location.
     */
    public boolean hasMultipleBusinessHours() {
        return mBusinessHourArray != NO_MULTIPLE_BUSINESS_HOURS;
    }

    /**
     * @return Returns whether there is or there are Business hours for this location.
     */
    public boolean hasBusinessHours() {
        return mBusinessHour != NO_BUSINESS_HOURS;
    }


}


//showMap(Uri.parse("geo:33.8120918, -117.9189742?z=11"));

//    public void showMap(Uri geoLocation) {
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        //Sets URI (Uniform Resource Identifier)
//        intent.setData(geoLocation);
//        //Checks for nullity (if there is no app that supports this intent)
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
//    }