package tech.zafrani.pubgapp.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

import tech.zafrani.pubgapp.fragments.ItemTabFragment;
import tech.zafrani.pubgapp.models.Category;

public class ItemTabAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT;
    private List<Category> categories;



    public ItemTabAdapter(@NonNull final FragmentManager fm, List<Category> categories) {
        super(fm);
        PAGE_COUNT = categories.size();
        this.categories = categories;

    }


    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return ItemTabFragment.newInstance(categories.get(position));
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(final int position) {
        return categories.get(position).getName();
    }
}
