package tech.zafrani.companionforpubg.adapters;

import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.adapters.viewholders.BaseViewHolder;
import tech.zafrani.companionforpubg.models.Category;
import tech.zafrani.companionforpubg.models.Item;


public abstract class CategoryRecyclerViewAdapter<I extends Item, C extends Category<I>> extends RecyclerViewAdapterImpl<I>{

    public CategoryRecyclerViewAdapter(@NonNull final C category) {
        super(category.getItems());
    }
}
