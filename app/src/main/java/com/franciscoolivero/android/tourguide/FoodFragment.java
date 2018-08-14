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

public class FoodFragment extends Fragment {
    public FoodFragment() {
        //Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.locations_list, container, false);

        final ArrayList<Location> locations = new ArrayList<>();
        final ArrayList<String> sigaLaVacaHours = new ArrayList<>();
        final ArrayList<String> ponyHours = new ArrayList<>();
        locations.add(new Location(getString(R.string.naturaleza_name),
                getString(R.string.naturaleza_description),
                getString(R.string.naturaleza_address),
                getString(R.string.naturaleza_business_hours),
                R.drawable.naturalezasabia,
                Uri.parse("http://plus.codes/" + getString(R.string.naturaleza_geolocation_uri))));
        locations.add(new Location(getString(R.string.argentine_experience_name),
                getString(R.string.argentine_experience_description),
                getString(R.string.argentine_experience_address),
                getString(R.string.argentine_experience_business_hours),
                R.drawable.argentineexperience,
                Uri.parse("http://plus.codes/" + getString(R.string.argentine_experience_geolocation_uri))));
        sigaLaVacaHours.add(getString(R.string.siga_la_vaca_business_hours_1));
        sigaLaVacaHours.add(getString(R.string.siga_la_vaca_business_hours_2));
        locations.add(new Location(getString(R.string.siga_la_vaca_name),
                getString(R.string.siga_la_vaca_description),
                getString(R.string.siga_la_vaca_address),
                sigaLaVacaHours,
                R.drawable.sigalavaca,
                Uri.parse("http://plus.codes/" + getString(R.string.siga_la_vaca_geolocation_uri))));
        locations.add(new Location(getString(R.string.don_julio_name),
                getString(R.string.don_julio_description),
                getString(R.string.don_julio_address),
                getString(R.string.don_julio_business_hours),
                R.drawable.julio,
                Uri.parse("http://plus.codes/" + getString(R.string.don_julio_geolocation_uri))));
        locations.add(new Location(getString(R.string.ilatina_name),
                getString(R.string.ilatina_description),
                getString(R.string.ilatitna_address),
                getString(R.string.ilatina_business_hours),
                R.drawable.ilatina,
                Uri.parse("http://plus.codes/" + getString(R.string.ilatitna_geolocation_uri))));
        ponyHours.add(getString(R.string.pony_line_business_hours_1));
        ponyHours.add(getString(R.string.pony_line_business_hours_2));
        ponyHours.add(getString(R.string.pony_line_business_hours_3));
        locations.add(new Location(getString(R.string.pony_line_name),
                getString(R.string.pony_line_description),
                getString(R.string.pony_line_address),
                ponyHours,
                R.drawable.ponyline,
                Uri.parse("http://plus.codes/" + getString(R.string.pony_line_geolocation_uri))));


        //Log to check that the list was created correctly.
        for (int i = 0; i < locations.size(); i++) {
            Log.v("FoodFragment", "Current Location Object: " + locations.get(i));

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

