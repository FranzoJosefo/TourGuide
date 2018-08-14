package com.franciscoolivero.android.tourguide;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by franciscoolivero on 7/29/18.
 */

/**
 * A simple {@link Fragment} subclass
 * which handles the Shopping category.
 */

public class ShoppingFragment extends Fragment {
    public ShoppingFragment() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        final ArrayList<String> norcenterHours = new ArrayList<>();
        locations.add(new Location(
                getString(R.string.abasto_name),
                getString(R.string.abasto_description),
                getString(R.string.abasto_address),
                getString(R.string.abasto_business_hours),
                R.drawable.abasto,
                Uri.parse("http://plus.codes/" + getString(R.string.abasto_geolocation_uri))));
        ;
        locations.add(new Location(getString(
                R.string.pacifico_name),
                getString(R.string.pacifico_description),
                getString(R.string.pacifico_address),
                getString(R.string.pacifico_business_hours),
                R.drawable.galeriapacifico,
                Uri.parse("http://plus.codes/" + getString(R.string.pacifico_geolocation_uri))));
        ;
        locations.add(new Location(
                getString(R.string.alcorta_name),
                getString(R.string.alcorta_description),
                getString(R.string.alcorta_address),
                getString(R.string.alcorta_business_hours),
                R.drawable.alcortamall,
                Uri.parse("http://plus.codes/" + getString(R.string.alcorta_geolocation_uri))));
        ;
        locations.add(new Location(
                getString(R.string.palermo_name),
                getString(R.string.palermo_description),
                getString(R.string.palermo_address),
                getString(R.string.pacifico_business_hours),
                R.drawable.altopalermo,
                Uri.parse("http://plus.codes/" + getString(R.string.palermo_geolocation_uri))));
        ;
        locations.add(new Location(
                getString(R.string.recoleta_name),
                getString(R.string.recoleta_description),
                getString(R.string.recoleta_address),
                getString(R.string.recoleta_hours),
                R.drawable.recoletamall,
                Uri.parse("http://plus.codes/" + getString(R.string.recoleta_geolocation_uri))));
        ;
        norcenterHours.add(getString(R.string.norcenter_business_hours_1));
        norcenterHours.add(getString(R.string.norcenter_business_hours_2));
        norcenterHours.add(getString(R.string.norcenter_business_hours_3));
        locations.add(new Location(
                getString(R.string.norcenter_name),
                getString(R.string.norcenter_description),
                getString(R.string.norcenter_address), norcenterHours,
                R.drawable.norcenter,
                Uri.parse("http://plus.codes/" + getString(R.string.norcenter_geolocation_uri))));
        ;
        locations.add(new Location(
                getString(R.string.unicenter_name),
                getString(R.string.unicenter_description),
                getString(R.string.unicenter_address),
                getString(R.string.unicenter_business_hours),
                R.drawable.unicenter,
//                Uri.parse("google.navigation:q=" + getString(R.string.unicenter_geolocation_uri))));
                Uri.parse("http://plus.codes/" + getString(R.string.unicenter_geolocation_uri))));
        locations.add(new Location(
                getString(R.string.dot_name),
                getString(R.string.dot_description),
                getString(R.string.dot_address),
                getString(R.string.dot_business_hours),
                R.drawable.dotshopping,
                Uri.parse("http://plus.codes/" + getString(R.string.dot_geolocation_uri))));

        //Log to check that the list was created correctly.
        for (int i = 0; i < locations.size(); i++) {
            Log.v("ShoppingFragment", "Current Location Object: " + locations.get(i));

        }


        LocationAdapter adapter = new LocationAdapter(getActivity(), locations);
        ListView listView = rootView.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showOnMap(i, locations);
            }
        });

        return rootView;

    }

    private void showOnMap(int i, ArrayList<Location> locations) {
        Uri geoLocation = locations.get(i).getmGeoLocation();
        if (geoLocation != null) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            //Sets URI (Uniform Resource Identifier)
            intent.setData(locations.get(i).getmGeoLocation());
            intent.setPackage("com.google.android.apps.maps");
            //Checks for nullity (if there is no app that supports this intent)
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    }
}
