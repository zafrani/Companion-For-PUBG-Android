package tech.zafrani.pubgapp.adapters.viewholders;

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
    private TextView rangeTextView;
    private TextView stabilityTextView;
    private TextView rateTextView;


    public ItemViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
        this.ammoTextView= (TextView) itemView.findViewById(R.id.row_item_ammo);
        this.magazineTextView= (TextView) itemView.findViewById(R.id.row_item_magazine);
        this.capacityTextView= (TextView) itemView.findViewById(R.id.row_item_capacity);
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
        this.ammoTextView.setText(itemAmmo);
    }
    public void setItemMagazine(@NonNull final String itemMagazine) {
        this.magazineTextView.setText(itemMagazine);
    }
    public void setItemCapacity(@NonNull final String itemCapacity) {
        this.capacityTextView.setText(itemCapacity);
    }
}
