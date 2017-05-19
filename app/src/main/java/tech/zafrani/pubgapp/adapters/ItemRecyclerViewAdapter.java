package tech.zafrani.pubgapp.adapters;


import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

import tech.zafrani.pubgapp.adapters.viewholders.ItemViewHolder2;
import tech.zafrani.pubgapp.adapters.viewholders.WeaponViewHolder2;
import tech.zafrani.pubgapp.models.Item;

public class ItemRecyclerViewAdapter extends BaseRecyclerViewAdapterImpl<Item, ItemViewHolder2> {

    private static final int WEAPON_TYPE = 0;

    public ItemRecyclerViewAdapter(@NonNull final List<Item> items) {
        super(items);
    }

    @Override
    public ItemViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == WEAPON_TYPE) {
            return WeaponViewHolder2.createViewHolder(parent, this);
        }
        throw new IllegalStateException("Unknown view ty[e");
    }

    @Override
    public int getItemViewType(int position) {
        return WEAPON_TYPE;
    }
}
