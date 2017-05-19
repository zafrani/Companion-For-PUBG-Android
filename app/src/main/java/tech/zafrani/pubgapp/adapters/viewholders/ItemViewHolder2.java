package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public abstract class ItemViewHolder2 extends BaseViewHolder<Item> {

    public ItemViewHolder2(@NonNull final View itemView,
                           @NonNull final Listener<Item> listener) {
        super(itemView, listener);
    }
}
