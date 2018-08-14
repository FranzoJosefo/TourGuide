package com.franciscoolivero.android.tourguide;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by franciscoolivero on 7/29/18.
 */

public class LocationAdapter extends ArrayAdapter<Location> {


    public LocationAdapter(Activity context, ArrayList<Location> locations) {
        super(context, 0, locations);

    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /** Get the {@link Word} object located at this position in the list*/
        Location currentLocation = getItem(position);

        TextView nameTextView = (TextView) listItemView.findViewById(R.id.text_name);
        nameTextView.setText(currentLocation.getmName());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.text_description);
        descriptionTextView.setText(currentLocation.getmDescription());

        handleBusinessHours(listItemView, currentLocation);

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.text_address);
        addressTextView.setText(currentLocation.getmAddress());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentLocation.hasImage()) {
            //Set the ImageView to the image resource specified in the current word.
            imageView.setImageResource(currentLocation.getmImageResourceId());
        } else{
            //Set the ImageView to the place-holder in case the view is re-used.
            imageView.setImageResource(R.drawable.placeholder);
        }

        return listItemView;
    }

    private void handleBusinessHours(View listItemView, Location currentLocation) {

        /**
         * Verify if the location object contains multiple Business hours
         * If it does, check if there are two or three different business hours.
         */
        if (currentLocation.hasMultipleBusinessHours()) {
            ArrayList<String> businessHours = currentLocation.getmBusinessHourArray();
            if (businessHours.size() == 2) {
                TextView hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours);
                hoursTextView.setText(businessHours.get(0));
                hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_two);
                hoursTextView.setText(businessHours.get(1));
                hoursTextView.setVisibility(View.VISIBLE);
                //Make Sure the visibility of the third item is GONE in case the View is reused.
                hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_three);
                hoursTextView.setVisibility(View.GONE);
                //Make sure the visibility of the tittle "Open" TextView is VISIBLE in case the View is reused.
                TextView openTextView = listItemView.findViewById(R.id.text_DefaultHour);
                openTextView.setVisibility(View.VISIBLE);


            } else {
                TextView hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours);
                hoursTextView.setText(businessHours.get(0));
                hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_two);
                hoursTextView.setText(businessHours.get(1));
                hoursTextView.setVisibility(View.VISIBLE);
                hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_three);
                hoursTextView.setText(businessHours.get(2));
                hoursTextView.setVisibility(View.VISIBLE);
                //Make sure the visibility of the tittle "Open" TextView is VISIBLE in case the View is reused.
                TextView openTextView = listItemView.findViewById(R.id.text_DefaultHour);
                openTextView.setVisibility(View.VISIBLE);

            }
        /**
         * Verify if the location object a single line of Business hour.
         * If so, set the text for the business hour textView, and hide the rest of the textViews.
         */
        } else if (currentLocation.hasBusinessHours()) {
            TextView hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours);
            hoursTextView.setText(currentLocation.getmBusinessHour());
            //Make Sure the visibility of the remaining hoursTextViews is GONE in case the Views are reused.
            hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_two);
            hoursTextView.setVisibility(View.GONE);
            hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_three);
            hoursTextView.setVisibility(View.GONE);
            //Make sure the visibility of the tittle "Open" TextView is VISIBLE in case the View is reused.
            TextView openTextView = listItemView.findViewById(R.id.text_DefaultHour);
            openTextView.setVisibility(View.VISIBLE);
        /**
         * If the location has no business hours, hide everything related.
         */
        } else {
            //Make Sure the visibility of all hoursTextViews are GONE.
            TextView hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours);
            hoursTextView.setVisibility(View.GONE);
            hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_two);
            hoursTextView.setVisibility(View.GONE);
            hoursTextView = (TextView) listItemView.findViewById(R.id.text_hours_three);
            hoursTextView.setVisibility(View.GONE);
            //Make sure the visibility of the tittle "Open" TextView is GONE.
            TextView openTextView = listItemView.findViewById(R.id.text_DefaultHour);
            openTextView.setVisibility(View.GONE);
        }
    }
}
