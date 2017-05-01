package zafrani.com.pubgapp.adapters;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import zafrani.com.pubgapp.MapFragment;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Map", "Gear", "Items" };
    private final Context context;


    public MainFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return MapFragment.newInstance();

            case 1:
                return MapFragment.newInstance();

            case 2:
                return MapFragment.newInstance();

            default:
                break;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }
}
