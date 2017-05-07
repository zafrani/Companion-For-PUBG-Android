package tech.zafrani.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.adapters.ItemListAdapter;
import tech.zafrani.pubgapp.adapters.ItemTabAdapter;
import tech.zafrani.pubgapp.models.Category;
import tech.zafrani.pubgapp.models.Item;
import tech.zafrani.pubgapp.models.Items;
import tech.zafrani.pubgapp.models.Type;
import tech.zafrani.pubgapp.utils.FileUtil;

public class ItemFragment extends BaseFragment {

    public static String TAG = ItemFragment.class.getSimpleName();
    private RecyclerView recyclerView;



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

        final List<Item> items = new ArrayList<>();
        try {
            Items itemList = FileUtil.getItems(getActivity());
            Log.e(getClass()
                          .getSimpleName(), "Items contents: " + (itemList == null ? "null" : items.toString()));
            for (final Category category: itemList.getCategories()) {
                Log.e(getClass()
                        .getSimpleName(), "Categories: " + (itemList.getCategories() == null ? "null" : category.toString()));
                Log.e(getClass()
                        .getSimpleName(), "Types for category " + category + ": " + (category.getTypes() == null ? "null" : category.getTypes().toString()));
                if (category.getTypes() != null){
                    for (final Type type : category.getTypes()) {
                        Log.e(getClass()
                            .getSimpleName(), "Items for Type " + type + ": " + (type.getItems() == null ? "null" : type.getItems().toString()));
                        items.addAll(type.getItems());

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(getClass().getSimpleName(), "Error: " + e.getLocalizedMessage());
        }


        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new ItemTabAdapter(getFragmentManager()));
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_item_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ItemListAdapter adapter =  new ItemListAdapter(items);
        recyclerView.setAdapter(adapter);
    }


}
