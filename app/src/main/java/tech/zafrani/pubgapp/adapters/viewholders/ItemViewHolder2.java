package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.annotation.NonNull;
import android.view.View;

import tech.zafrani.pubgapp.models.Item;

public class ItemViewHolder2 extends BaseViewHolder<Item> {
    public ItemViewHolder2(@NonNull final View itemView,
                           @NonNull final Listener<Item> listener) {
        super(itemView, listener);
    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }
}
