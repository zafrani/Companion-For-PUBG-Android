package zafrani.com.pubgapp.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentPagerAdapter;

import java.util.List;

import zafrani.com.pubgapp.fragments.BaseFragment;

public class FragmentAdapter extends FragmentPagerAdapter {
    @NonNull
    private final List<BaseFragment> fragments;
    @NonNull
    private final Context context;


    public FragmentAdapter(@NonNull final FragmentManager fm,
                           @NonNull final Context context,
                           @NonNull final List<BaseFragment> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return this.context.getResources().getString(this.fragments.get(position).getTabTitle());
    }
}