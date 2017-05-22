package tech.zafrani.companionforpubg.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import tech.zafrani.companionforpubg.fragments.ItemTabFragment;

public class ItemTabAdapter extends FragmentPagerAdapter {

    public ItemTabAdapter(@NonNull final FragmentManager fm) {
        super(fm);
    }


    @Override
    public int getCount() {
        return 0;
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return ItemTabFragment.newInstance();
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(final int position) {
        return "";
    }
}
