package zafrani.com.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;

import zafrani.com.pubgapp.R;
import zafrani.com.pubgapp.adapters.ItemListAdapter;
import zafrani.com.pubgapp.models.Category;
import zafrani.com.pubgapp.models.Item;
import zafrani.com.pubgapp.models.Items;
import zafrani.com.pubgapp.models.Type;
import zafrani.com.pubgapp.utils.FileUtil;

public class ItemFragment extends BaseFragment {

    public static String TAG = ItemFragment.class.getSimpleName();
    private RecyclerView mRecyclerView;
    private ItemListAdapter mAdapter;
    private ArrayList<Item> itemList = new ArrayList<>();



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        itemList = new ArrayList<>();
        try {
            Items items = FileUtil.getItems(getActivity());
            Log.e(getClass()
                          .getSimpleName(), "Items contents: " + (items == null ? "null" : items.toString()));
            for (Category category: items.getCategories()) {
                Log.e(getClass()
                        .getSimpleName(), "Categories: " + (items.getCategories() == null ? "null" : category.toString()));
                Log.e(getClass()
                        .getSimpleName(), "Types for category " + category + ": " + (category.getTypes() == null ? "null" : category.getTypes().toString()));
                if (category.getTypes() != null){
                    for (Type type : category.getTypes()) {
                        Log.e(getClass()
                            .getSimpleName(), "Items for Type " + type + ": " + (type.getItems() == null ? "null" : type.getItems().toString()));
                        itemList.addAll(type.getItems());

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(getClass().getSimpleName(), "Error: " + e.getLocalizedMessage());
        }

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_item);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new ItemListAdapter(getActivity(),itemList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
