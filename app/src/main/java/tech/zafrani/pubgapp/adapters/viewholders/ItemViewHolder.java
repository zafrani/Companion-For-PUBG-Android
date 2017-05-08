package tech.zafrani.pubgapp.adapters.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

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

    public void setItemAmmo(@Nullable final String itemAmmo) {
        if (itemAmmo != null) {
            this.ammoTextView.setText(context.getString(R.string.row_item_ammo, itemAmmo));
        } else {
            this.ammoTextView.setText("");
        }
    }
    public void setItemMagazine(final Float itemMagazine) {
        if (itemMagazine != null) {
            this.magazineTextView.setText(context.getString(R.string.row_item_magazine, itemMagazine));
        }else {
            this.magazineTextView.setText("");
        }
    }
    public void setItemCapacity(final Float itemCapacity) {
        if (itemCapacity != null) {
            this.capacityTextView.setText(context.getString(R.string.row_item_capacity, itemCapacity));
        }else {
            this.capacityTextView.setText("");
        }
    }
    public void setItemDamage(@Nullable final HashMap<String,String> itemDamage) {
        if (itemDamage!= null) {
            if(itemDamage.containsKey("chest0")){
                this.damageTextView.setText(context.getString(R.string.row_item_damage, itemDamage.get("chest0")));
            } else {
                this.damageTextView.setText(context.getString(R.string.row_item_damage, itemDamage.get("base")));
            }
        }else {
            this.damageTextView.setText("");
        }
    }
    public void setItemStability(final Float itemStability) {
        if (itemStability!= null) {
            this.stabilityTextView.setText(context.getString(R.string.row_item_stability, itemStability));
        }else {
            this.stabilityTextView.setText("");
        }
    }
    public void setItemRange(final Float itemRange) {
        if (itemRange!= null) {
            this.rangeTextView.setText(context.getString(R.string.row_item_range, itemRange));
        }else {
            this.rangeTextView.setText("");
        }
    }
    public void setItemRate(final Float itemRate) {
        if (itemRate != null) {
            this.rateTextView.setText(context.getString(R.string.row_item_rate, itemRate));
        }else {
            this.rateTextView.setText("");
        }
    }

}
