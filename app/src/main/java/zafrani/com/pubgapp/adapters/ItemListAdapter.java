package zafrani.com.pubgapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import zafrani.com.pubgapp.R;
import zafrani.com.pubgapp.models.Item;
import zafrani.com.pubgapp.viewholders.ItemViewHolder;


public class ItemListAdapter extends RecyclerView.Adapter<ItemViewHolder> {
    private final Context mContext;
    private final ArrayList<Item> itemList;

    public ItemListAdapter(@NonNull final Context context, @NonNull final ArrayList<Item> itemList) {
        this.mContext = context;
        this.itemList = itemList;

    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_itemlayout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.setItemName(item.getName());
        holder.setItemType(item.getType());
        holder.setItemCategory(item.getCategory());

    }

    @Override
    public int getItemCount() {
        return (null != itemList ? itemList.size() : 0);
    }


}
