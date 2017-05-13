package tech.zafrani.pubgapp.adapters.viewholders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;


public class WeaponsViewHolder extends ItemViewHolder{
    private final String IMAGE_URL_BASE= "https://github.com/Zsteven44/PUBG-Companion-Images/blob/master/images/";
    private final String ARG_RAW = "?raw=true";
    private final static String EMPTY_FIELD = " - ";
    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView ammoTextView;
    private final TextView magazineTextView;
    private final TextView capacityTextView;
    private final TextView damageTextView;
    private final TextView rangeTextView;
    private final TextView stabilityTextView;
    private final TextView rateTextView;
    private final ImageView imageImageView;
    private final Context context;

    public WeaponsViewHolder(@NonNull final View itemView, @NonNull final Context context) {
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
        this.imageImageView= (ImageView) itemView.findViewById(R.id.row_item_icon);


    }

    private void setItemName(@NonNull final String itemName) {
        this.nameTextView.setText(itemName);
    }

    private void setItemType(@NonNull final String itemType) {
        this.typeTextView.setText(itemType);
    }

    private void setItemCategory(@NonNull final String itemCategory) {
        this.categoryTextView.setText(itemCategory);
    }

    private void setItemAmmo(@Nullable final String itemAmmo) {
        if (itemAmmo != null) {
            this.ammoTextView.setText(context.getString(R.string.row_item_ammo, itemAmmo));
        } else {
            this.ammoTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemMagazine(@Nullable final Float itemMagazine) {
        if (itemMagazine != null) {
            this.magazineTextView.setText(context.getString(R.string.row_item_magazine, itemMagazine));
        }else {
            this.magazineTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemCapacity(@Nullable final Float itemCapacity) {
        if (itemCapacity != null) {
            this.capacityTextView.setText(context.getString(R.string.row_item_capacity, itemCapacity));
        }else {
            this.capacityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemDamage(@Nullable final HashMap<String,String> itemDamage) {
        if (itemDamage!= null) {
            if(itemDamage.containsKey("chest0")){
                this.damageTextView.setText(context.getString(R.string.row_item_damage, itemDamage.get("chest0")));
            } else {
                this.damageTextView.setText(context.getString(R.string.row_item_damage, itemDamage.get("base")));
            }
        }else {
            this.damageTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemStability(@Nullable final Float itemStability) {
        if (itemStability!= null) {
            this.stabilityTextView.setText(context.getString(R.string.row_item_stability, itemStability));
        }else {
            this.stabilityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemRange(@Nullable final Float itemRange) {
        if (itemRange!= null) {
            this.rangeTextView.setText(context.getString(R.string.row_item_range, itemRange));
        }else {
            this.rangeTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemRate(@Nullable final Float itemRate) {
        if (itemRate != null) {
            this.rateTextView.setText(context.getString(R.string.row_item_rate, itemRate));
        }else {
            this.rateTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemIcon(final String itemImage, String category) {
        if (itemImage != null) {
            Picasso.with(context).load(IMAGE_URL_BASE + category+ "/" + itemImage + ARG_RAW).into(imageImageView);
        }else {
            Picasso.with(context).load(R.mipmap.ic_launcher).into(imageImageView);

        }
    }

    @Override
    public void bind(Item item) {
        setItemName(item.getName());
        setItemType(item.getType());
        setItemCategory(item.getCategory());
        setItemAmmo(item.getAmmo());
        setItemMagazine(item.getMagazine());
        setItemCapacity(item.getCapacity());
        setItemDamage(item.getDamage());
        setItemRange(item.getRange());
        setItemRate(item.getRate());
        setItemStability(item.getStability());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}
