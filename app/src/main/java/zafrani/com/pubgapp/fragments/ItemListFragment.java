package zafrani.com.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zafrani.com.pubgapp.R;
import zafrani.com.pubgapp.adapters.ItemListRecyclerViewAdapter;
import zafrani.com.pubgapp.models.BaseItem;
import zafrani.com.pubgapp.models.ItemList;
import zafrani.com.pubgapp.utils.UtilityFunctions;

public class ItemListFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private ArrayList<BaseItem> feedsList;
    private ItemListRecyclerViewAdapter adapter;
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
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_itemlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ItemList items = UtilityFunctions.generateItemList(getActivity().getBaseContext());


        adapter = new ItemListRecyclerViewAdapter(getActivity(), feedsList);
        recyclerView.setAdapter(adapter);
    }




}
