package tech.zafrani.companionforpubg.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import tech.zafrani.companionforpubg.fragments.ItemTabFragment;
import tech.zafrani.companionforpubg.models.Categories;

public class ItemTabAdapter extends FragmentPagerAdapter {
    private Categories categories;



    public ItemTabAdapter(@NonNull final FragmentManager fm,
                          @NonNull final Categories categories) {
        super(fm);
        this.categories = categories;

    }


    @Override
    public int getCount() {
        return categories.size();
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return ItemTabFragment.newInstance(categories.getCategory(position));
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(final int position) {
        return categories.getCategory(position).getName();
    }
}
