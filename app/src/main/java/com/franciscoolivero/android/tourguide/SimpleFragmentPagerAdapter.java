package com.franciscoolivero.android.tourguide;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentPagerAdapter;


/**
 * Created by franciscoolivero on 7/30/18.
 */

/**
 * Provides the appropriate {@link Fragment} for a view pager.
 */
public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"SHOPPING", "FOOD & DRINKS", "HISTORIC SITES",  "PARKS"};
    private Context context;


    public SimpleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new ShoppingFragment();
        } else if(position==1){
            return new FoodFragment();
        } else if(position==2){
            return new SitesFragment();
        } else
            return new ParksFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}