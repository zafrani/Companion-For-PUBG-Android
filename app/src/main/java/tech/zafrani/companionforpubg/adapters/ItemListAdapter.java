package tech.zafrani.companionforpubg.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tech.zafrani.companionforpubg.adapters.viewholders.AmmunitionViewHolder;
import tech.zafrani.companionforpubg.adapters.viewholders.VehicleViewHolder;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.viewholders.AttachmentsViewHolder;
import tech.zafrani.companionforpubg.adapters.viewholders.ConsumablesViewHolder;
import tech.zafrani.companionforpubg.adapters.viewholders.EquipmentViewHolder;
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
    public int getItemViewType(int position) {
        String category = itemList.get(position).getCategory();
        int itemViewType = 0;
        switch(category){
            case WEAPONS:
                itemViewType = ID_WEAPONS;
                break;
            case AMMUNITION:
                itemViewType = ID_AMMUNITION;
                break;
            case ATTACHMENTS:
                itemViewType = ID_ATTACHMENTS;
                break;
            case EQUIPMENT:
                itemViewType = ID_EQUIPMENT;
                break;
            case CONSUMABLES:
                itemViewType = ID_CONSUMABLES;
                break;
            case VEHICLES:
                itemViewType = ID_VEHICLES;
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
            case (ID_WEAPONS):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view);
            case (ID_AMMUNITION):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_ammunition, parent, false);
                return new AmmunitionViewHolder(view);
            case (ID_ATTACHMENTS):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_attachment, parent, false);
                return new AttachmentsViewHolder(view);
            case (ID_EQUIPMENT):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_equipment, parent, false);
                return new EquipmentViewHolder(view);
            case (ID_CONSUMABLES):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_consumables, parent, false);
                return new ConsumablesViewHolder(view);
            case (ID_VEHICLES):
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_vehicles, parent, false);
                return new VehicleViewHolder(view);
            default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_weapon, parent, false);
                return new WeaponsViewHolder(view);
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
