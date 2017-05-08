package tech.zafrani.pubgapp.adapters.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import tech.zafrani.pubgapp.R;


public class ItemViewHolder  extends RecyclerView.ViewHolder{
    private TextView nameTextView;
    private TextView typeTextView;
    private TextView categoryTextView;
    private TextView ammoTextView;
    private TextView magazineTextView;
    private TextView capacityTextView;
    private TextView damageTextView;
    private TextView rangeTextView;
    private TextView stabilityTextView;
    private TextView rateTextView;
    private Context context;

    public ItemViewHolder(@NonNull final View itemView, @NonNull final Context context) {
        super(itemView);
        this.context = context;
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
        this.ammoTextView= (TextView) itemView.findViewById(R.id.row_item_ammo);
        this.magazineTextView= (TextView) itemView.findViewById(R.id.row_item_magazine);
        this.capacityTextView= (TextView) itemView.findViewById(R.id.row_item_capacity);
        this.damageTextView= (TextView) itemView.findViewById(R.id.row_item_damage);
        this.rangeTextView= (TextView) itemView.findViewById(R.id.row_item_range);
        this.stabilityTextView = (TextView) itemView.findViewById(R.id.row_item_stability);
        this.rateTextView= (TextView) itemView.findViewById(R.id.row_item_rate);


    }


    public void setItemName(@NonNull final String itemName) {
        this.nameTextView.setText(itemName);
    }

    public void setItemType(@NonNull final String itemType) {
        this.typeTextView.setText(itemType);
    }

    public void setItemCategory(@NonNull final String itemCategory) {
        this.categoryTextView.setText(itemCategory);
    }

    public void setItemAmmo(@NonNull final String itemAmmo) {
        this.ammoTextView.setText(context.getString(R.string.row_item_ammo, itemAmmo));
    }
    public void setItemMagazine(@NonNull final String itemMagazine) {
        this.magazineTextView.setText(context.getString(R.string.row_item_magazine, itemMagazine));
    }
    public void setItemCapacity(@NonNull final String itemCapacity) {
        this.capacityTextView.setText(context.getString(R.string.row_item_capacity, itemCapacity));
    }
    public void setItemDamage(@NonNull final String itemDamage) {
        this.damageTextView.setText(context.getString(R.string.row_item_damage, itemDamage));
    }
    public void setItemStability(@NonNull final String itemStability) {
        this.stabilityTextView.setText(context.getString(R.string.row_item_stability, itemStability));
    }
    public void setItemRange(@NonNull final String itemRange) {
        this.rangeTextView.setText(context.getString(R.string.row_item_range, itemRange));
    }
    public void setItemRate(@NonNull final String itemRate) {
        this.rateTextView.setText(context.getString(R.string.row_item_rate, itemRate));
    }

}
