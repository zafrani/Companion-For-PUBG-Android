package tech.zafrani.pubgapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.adapters.viewholders.AmmunitionViewHolder;
import tech.zafrani.pubgapp.adapters.viewholders.AttachmentsViewHolder;
import tech.zafrani.pubgapp.adapters.viewholders.ItemViewHolder;
import tech.zafrani.pubgapp.adapters.viewholders.WeaponsViewHolder;
import tech.zafrani.pubgapp.models.Item;


public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private static final String ARG_WEAPONS = "Weapons";
    private static final String ARG_AMMUNITION = "Ammunition";
    private static final String ARG_ATTACHMENTS = "Attachments";
    private static final String ARG_EQUIPMENT = "Equipment";
    private static final String ARG_CONSUMABLES = "Consumables";
    private static final String ARG_VEHICLES = "Vehicles";
    private static final int VAL_WEAPONS = 0;
    private static final int VAL_AMMUNITION = 1;
    private static final int VAL_ATTACHMENTS = 2;
    private static final int VAL_EQUIPMENT = 3;
    private static final int VAL_CONSUMABLES = 4;
    private static final int VAL_VEHICLES = 5;

    @NonNull
    private final List<Item> itemList;

    public ItemListAdapter(@NonNull final List<Item> itemList) {
        this.itemList = itemList;

    }

    @Override
    public int getItemViewType(int position) {
        String category = itemList.get(position).getCategory();
        int itemViewType = 0;
        switch(category){
            case ARG_WEAPONS:
                itemViewType = VAL_WEAPONS;
                break;
            case ARG_AMMUNITION:
                itemViewType = VAL_AMMUNITION;
                break;
            case ARG_ATTACHMENTS:
                itemViewType = VAL_ATTACHMENTS;
                break;
            case ARG_EQUIPMENT:
                itemViewType = VAL_EQUIPMENT;
                break;
            case ARG_CONSUMABLES:
                itemViewType = VAL_CONSUMABLES;
                break;
            case ARG_VEHICLES:
                itemViewType = VAL_VEHICLES;
                break;
            default:
                itemViewType =0;
                break;
        }
        return itemViewType;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, @NonNull final int viewType) {
        View view;
        switch (viewType) {
            case (VAL_WEAPONS):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view, parent.getContext());
            case (VAL_AMMUNITION):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_ammunition, parent, false);
                return new AmmunitionViewHolder(view, parent.getContext());
            case (VAL_ATTACHMENTS):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_attachment, parent, false);
                return new AttachmentsViewHolder(view, parent.getContext());
            case (VAL_EQUIPMENT):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view, parent.getContext());
            case (VAL_CONSUMABLES):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view, parent.getContext());
            case (VAL_VEHICLES):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view, parent.getContext());
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view, parent.getContext());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder viewHolder, final int position) {
        final Item item = itemList.get(position);
        viewHolder.bind(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
