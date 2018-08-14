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

public class SitesFragment extends Fragment {
    public SitesFragment() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        locations.add(new Location(getString(R.string.obelisco_name),
                getString(R.string.obelisco_description),
                getString(R.string.obelisco_address),
                R.drawable.obelisco,
                Uri.parse("http://plus.codes/" + getString(R.string.obelisco_geolocation_uri))));
        locations.add(new Location(getString(R.string.caminito_name),
                getString(R.string.caminito_description),
                getString(R.string.caminito_address),
                R.drawable.caminito,
                Uri.parse("http://plus.codes/" + getString(R.string.caminito_geolocation_uri))));
        locations.add(new Location(getString(R.string.plaza_de_mayo_name),
                getString(R.string.plaza_de_mayo_description),
                getString(R.string.plaza_de_mayo_address),
                R.drawable.plazamayo,
                Uri.parse("http://plus.codes/" + getString(R.string.plaza_de_mayo_geolocation_uri))));
        locations.add(new Location(getString(R.string.colon_name),
                getString(R.string.colon_description),
                getString(R.string.colon_address),
                R.drawable.colon,
                Uri.parse("http://plus.codes/" + getString(R.string.colon_geolocation_uri))));
        locations.add(new Location(getString(R.string.rosada_name),
                getString(R.string.rosada_description),
                getString(R.string.rosada_address),
                Uri.parse("http://plus.codes/" + getString(R.string.rosada_geolocation_uri))));


        //Log to check that the list was created correctly.
        for (int i = 0; i < locations.size(); i++) {
            Log.v("SitesFragment", "Current Location Object: " + locations.get(i));
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
