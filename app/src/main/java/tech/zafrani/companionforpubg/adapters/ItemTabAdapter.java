package tech.zafrani.companionforpubg.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import tech.zafrani.companionforpubg.fragments.ItemTabFragment;
import tech.zafrani.companionforpubg.models.Categories;

public class ItemTabAdapter extends FragmentPagerAdapter {
    private Categories categories;
    private Context context;

    public ItemTabAdapter(@NonNull final Context context,
                          @NonNull final FragmentManager fm,
                          @NonNull final Categories categories) {
        super(fm);
        this.categories = categories;
        this.context = context;
    }


    @Override
    public int getCount() {
        return categories.getCount();
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return ItemTabFragment.newInstance();
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(final int position) {
        return categories.getPosition(position).getTitle();
    }
}
