package tech.zafrani.companionforpubg.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.viewholders.ItemViewHolder;
import tech.zafrani.companionforpubg.adapters.viewholders.WeaponsViewHolder;
import tech.zafrani.companionforpubg.models.Item;


public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private static final String WEAPONS = "Weapons";
    private static final String AMMUNITION = "Ammunition";
    private static final String ATTACHMENTS = "Attachments";
    private static final String EQUIPMENT = "Equipment";
    private static final String CONSUMABLES = "Consumables";
    private static final String VEHICLES = "Vehicles";
    private static final int ID_WEAPONS = 0;
    private static final int ID_AMMUNITION = 1;
    private static final int ID_ATTACHMENTS = 2;
    private static final int ID_EQUIPMENT = 3;
    private static final int ID_CONSUMABLES = 4;
    private static final int ID_VEHICLES = 5;

    @NonNull
    private final List<Item> itemList;

    public ItemListAdapter(@NonNull final List<Item> itemList) {
        this.itemList = itemList;

    }



    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, @NonNull final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
        return new WeaponsViewHolder(view);
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
