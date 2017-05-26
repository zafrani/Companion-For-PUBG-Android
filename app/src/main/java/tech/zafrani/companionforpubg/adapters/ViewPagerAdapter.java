package tech.zafrani.companionforpubg.adapters;


import android.app.Fragment;
import android.app.FragmentManager;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

import tech.zafrani.companionforpubg.fragments.ItemTabFragment;
import tech.zafrani.companionforpubg.models.items.Category;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    @NonNull
    private final Listener listener;

    public ViewPagerAdapter(@NonNull final FragmentManager fm,
                            @NonNull final Listener listener) {
        super(fm);
        this.listener = listener;
    }

    @Override
    public int getCount() {
        return this.listener.getCount();
    }

    @NonNull
    @Override
    public Fragment getItem(final int position) {
        return this.listener.getItem(position);
    }

    @NonNull
    @Override
    public CharSequence getPageTitle(final int position) {
        return this.listener.getPageTitle(position);
    }

    public interface Listener {
        int getCount();

        Fragment getItem(int position);

        String getPageTitle(int position);
    }
}
