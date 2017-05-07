package tech.zafrani.pubgapp.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import tech.zafrani.pubgapp.fragments.ItemTabFragment;

public class ItemTabAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 5;
    private final String tabTitles[] = new String[] { "Weapons",
            "Ammunition",
            "Attachments",
            "Equipment",
            "Items"
    };


    public ItemTabAdapter(@NonNull final FragmentManager fm) {
        super(fm);

    }

    @NonNull
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(@NonNull final int position) {
        return ItemTabFragment.newInstance(position + 1);
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(@NonNull final int position) {
        return tabTitles[position];
    }
}
