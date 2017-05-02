package zafrani.com.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import zafrani.com.pubgapp.R;

public class ItemViewFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_view, container, false);
    }

    @StringRes
    @Override
    public int getTabTitle() {
        return R.string.item_view_tab_title;
    }
}
