package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.annotation.NonNull;
import android.view.View;

import tech.zafrani.pubgapp.models.Item;

public abstract class ItemViewHolder extends BaseViewHolder<Item> {

    public ItemViewHolder(@NonNull final View itemView,
                          @NonNull final Listener<Item> listener) {
        super(itemView, listener);
    }
}
