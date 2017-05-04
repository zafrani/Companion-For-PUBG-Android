package zafrani.com.pubgapp.adapters;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

import zafrani.com.pubgapp.fragments.BaseFragment;

public class BaseFragmentAdapter extends FragmentStatePagerAdapter {
    @NonNull
    private final List<BaseFragment> fragments;
    @NonNull
    private final Context context;

    private RangeOffset rangeOffset;

    public BaseFragmentAdapter(@NonNull final FragmentManager fm,
                               @NonNull final Context context,
                               @NonNull final List<BaseFragment> fragments) {
        super(fm);
        this.context = context;
        this.fragments = fragments;
        this.rangeOffset = new RangeOffset(0, fragments.size());
    }

    @Override
    public Fragment getItem(int position) {
        final int offsetPosition = getPositionWithOffset(position);
        Log.e(getClass().getSimpleName(), "getPageTitle: " + position + " | " + offsetPosition);
        return this.fragments.get(offsetPosition);
    }

    @Override
    public int getCount() {
        return this.rangeOffset.diff;
    }



    private int getPositionWithOffset(final int position) {
        return this.rangeOffset.min + position;
    }


    public void setRangeOffset(final int min, final int max) {
        this.rangeOffset = new RangeOffset(min, max);
        notifyDataSetChanged();
    }

    private class RangeOffset {
        private final int min;
        private final int diff;

        public RangeOffset(final int min,
                           final int max) {
            this.min = min;
            this.diff = max - this.min;
            Log.e(getClass().getSimpleName(), "min/diff: " + min + " | " + diff);
        }
    }
}