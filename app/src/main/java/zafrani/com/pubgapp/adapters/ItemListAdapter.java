package zafrani.com.pubgapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import zafrani.com.pubgapp.R;
import zafrani.com.pubgapp.models.Item;
import zafrani.com.pubgapp.viewholders.ItemViewHolder;


public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    @NonNull
    private final List<Item> itemList;

    public ItemListAdapter(@NonNull final List<Item> itemList) {
        this.itemList = itemList;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, @NonNull final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder holder, @NonNull final int position) {
        final Item item = itemList.get(position);
        holder.setItemName(item.getName());
        holder.setItemType(item.getType());
        holder.setItemCategory(item.getCategory());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


}
