package tech.zafrani.pubgapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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
import tech.zafrani.pubgapp.models.Category;
import tech.zafrani.pubgapp.models.Item;
import tech.zafrani.pubgapp.models.Items;
import tech.zafrani.pubgapp.models.Type;
import tech.zafrani.pubgapp.utils.FileUtil;

public class ItemTabFragment extends BaseFragment{
    public static final String ARG_PAGE = "ARG_PAGE";
    private String page;
    private RecyclerView recyclerView;

    public static ItemTabFragment newInstance(@NonNull final String page) {
        final Bundle args = new Bundle();
        args.putString(ARG_PAGE, page);
        final ItemTabFragment fragment = new ItemTabFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getString(ARG_PAGE);
    }


    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_itemtab, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final List<Item> items = new ArrayList<>();
        try {
            final Items itemList = FileUtil.getItems(getActivity());
            final Category category = itemList.getCategory(page);
            for (final Type type : category.getTypes()) {
                Log.e(getClass()
                        .getSimpleName(), "Items for Type " + type + ": " + (type.getItems() == null ? "null" : type.getItems().toString()));
                items.addAll(type.getItems());

            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(getClass().getSimpleName(), "Error: " + e.getLocalizedMessage());
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_item_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ItemListAdapter adapter =  new ItemListAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}

