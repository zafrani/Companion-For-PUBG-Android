package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class ItemViewHolder2 extends BaseViewHolder<Item> {

    public static ItemViewHolder2 createViewHolder(@NonNull final ViewGroup parent,
                                                   @NonNull final Listener<Item> listener) {
        return new ItemViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_item, parent, false), listener);
    }

    public ItemViewHolder2(@NonNull final View itemView,
                           @NonNull final Listener<Item> listener) {
        super(itemView, listener);
    }
}
