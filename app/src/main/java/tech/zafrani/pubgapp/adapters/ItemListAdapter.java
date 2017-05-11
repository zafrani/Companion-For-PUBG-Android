package tech.zafrani.pubgapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.adapters.viewholders.ItemViewHolder;
import tech.zafrani.pubgapp.models.Item;


public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    @NonNull
    private final List<Item> itemList;

    public ItemListAdapter(@NonNull final List<Item> itemList) {
        this.itemList = itemList;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, @NonNull final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ItemViewHolder(view, parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, @NonNull final int position) {
        final Item item = itemList.get(position);
        holder.setItemName(item.getName());
        holder.setItemType(item.getType());
        holder.setItemCategory(item.getCategory());
        holder.setItemAmmo(item.getAmmo());
        holder.setItemMagazine(item.getMagazine());
        holder.setItemCapacity(item.getCapacity());
        holder.setItemDamage(item.getDamage());
        holder.setItemRange(item.getRange());
        holder.setItemRate(item.getRate());
        holder.setItemStability(item.getStability());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
