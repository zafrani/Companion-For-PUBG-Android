package tech.zafrani.pubgapp.adapters;


import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

import tech.zafrani.pubgapp.adapters.viewholders.ItemViewHolder2;
import tech.zafrani.pubgapp.models.Item;

public class ItemRecyclerViewAdapter extends BaseRecyclerViewAdapterImpl<Item, ItemViewHolder2> {

    public ItemRecyclerViewAdapter(@NonNull final List<Item> items) {
        super(items);
    }

    @Override
    public ItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemViewHolder2.createViewHolder(parent, this);
    }
}
