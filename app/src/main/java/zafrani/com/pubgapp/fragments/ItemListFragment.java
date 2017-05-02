package zafrani.com.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zafrani.com.pubgapp.R;
import zafrani.com.pubgapp.models.BaseItem;

public class ItemListFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }


    @StringRes
    @Override
    public int getTabTitle() {
        return R.string.item_list_tab_title;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }



    public ArrayList<BaseItem> generateItemList(){



        return null;
    }

}
