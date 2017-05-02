package zafrani.com.pubgapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import zafrani.com.pubgapp.R;

public class ItemListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Object> feedItemList;
    private Context mContext;

    public ItemListRecyclerViewAdapter(Context context, List<Object> feedItemList) {
        this.feedItemList = feedItemList;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view;
        switch (i) {
            case 0:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_weapon, null);
                return new WeaponViewHolder(view);
            case 2:
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_equipment, null);
                return new EquipmentViewHolder(view);
            default: return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        Object feedItem = feedItemList.get(i);
        switch (holder.getItemViewType()) {
            case 0:
                WeaponViewHolder weaponViewHolder = (WeaponViewHolder) holder;
                weaponViewHolder.tv_name.setText( "This is the name of the Item");
                break;

            case 2:
                WeaponViewHolder equipmentViewHolder = (WeaponViewHolder) holder;

                break;
        }


    }

    @Override
    public int getItemCount() {
        return (null != feedItemList ? feedItemList.size() : 0);
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    private class WeaponViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView tv_name;
        protected TextView tv_type;
        protected TextView tv_ammo;
        protected TextView tv_magazine;

        public WeaponViewHolder(View view) {
            super(view);
            this.tv_name = (TextView) view.findViewById(R.id.item_name);
            this.tv_type = (TextView) view.findViewById(R.id.item_type);
            this.tv_ammo = (TextView) view.findViewById(R.id.item_ammo);
            this.tv_magazine = (TextView) view.findViewById(R.id.item_magazine);
        }
    }
    private class EquipmentViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imageView;
        protected TextView textView;

        public EquipmentViewHolder(View view) {
            super(view);
            this.textView = (TextView) view.findViewById(R.id.item_name);
        }
    }
}
