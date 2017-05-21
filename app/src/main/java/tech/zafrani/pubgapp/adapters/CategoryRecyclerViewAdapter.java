package tech.zafrani.pubgapp.adapters;


import android.support.annotation.NonNull;

import tech.zafrani.pubgapp.adapters.viewholders.BaseViewHolder;
import tech.zafrani.pubgapp.models.items.Item;
import tech.zafrani.pubgapp.models.items.categories.Category;

public abstract class CategoryRecyclerViewAdapter<I extends Item, C extends Category<I>, VH extends BaseViewHolder<I>>
        extends RecyclerViewAdapterImpl<I, VH> {

    public CategoryRecyclerViewAdapter(@NonNull final C category) {
        super(category.getItems());
    }
}
