package com.franciscoolivero.android.tourguide;

/**
 * Created by franciscoolivero on 6/4/18.
 * {@link Location} Represents a given location the user wants to know about
 * It contains it's name, address, business hour, Image if available.
 */

public class Location {
    private static final int NO_IMAGE_PROVIDED = -1;
    private static final int NO_AUDIO_PROVIDED = -1;
    private int mImageResourceId;
    private String mDescription;
    private String mLocationName;
    private String mGeoLocation;
    //Business hours only applies to Business can also extend class.
    private String mLocationBusHour;
    private String adress;
    //Probably will extend this class and create gigLocations which will inherit everything from this class.
    private int mAudioResourceId;

    public Location() {
    }

    /**
     * @return Returns whether there is or not an image for this location.
     */
    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * @return Returns whether there is or not an audio file for this location.
     */
    public boolean hasAudio(){
        return mAudioResourceId != NO_AUDIO_PROVIDED;
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