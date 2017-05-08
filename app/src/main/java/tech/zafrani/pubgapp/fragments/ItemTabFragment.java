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

import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.adapters.ItemListAdapter;
import tech.zafrani.pubgapp.models.Category;
import tech.zafrani.pubgapp.models.Item;
import tech.zafrani.pubgapp.models.Type;

public class ItemTabFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private Category category;

    public static ItemTabFragment newInstance(@NonNull final Category category) {
        final Bundle args = new Bundle();
        final ItemTabFragment fragment = new ItemTabFragment(category);
        return fragment;
    }

    public ItemTabFragment(@NonNull final Category category) {
        this.category = category;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        for (final Type type : category.getTypes()) {
            Log.e(getClass()
                    .getSimpleName(), "Items for Type " + type + ": " + (type.getItems() == null ? "null" : type.getItems().toString()));
            items.addAll(type.getItems());
        }
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_itemtab_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ItemListAdapter adapter =  new ItemListAdapter(items);
        recyclerView.setAdapter(adapter);
    }
}

