package tech.zafrani.pubgapp.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;


import tech.zafrani.pubgapp.fragments.ItemTabFragment;
import tech.zafrani.pubgapp.models.items.categories.Categories;

public class ItemTabAdapter extends FragmentPagerAdapter {
    private final Categories categories;
    private final Context context;

    public ItemTabAdapter(@NonNull final Context context,
                          @NonNull final FragmentManager fm,
                          @NonNull final Categories categories) {
        super(fm);
        this.context = context;
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
        return context.getString(categories.getCategory(position).getCategoryNameRes());
    }
}
