package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Damage;
import tech.zafrani.pubgapp.models.Item;


public class WeaponsViewHolder extends ItemViewHolder{

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
    private final TextView reloadTextView;
    private final ImageView imageImageView;

    public WeaponsViewHolder(@NonNull final View itemView) {
        super(itemView);
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
        this.reloadTextView= (TextView) itemView.findViewById(R.id.row_item_reload);
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
            this.ammoTextView.setText(itemView.getContext().getString(R.string.row_item_ammo, itemAmmo));
        } else {
            this.ammoTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemMagazine(@Nullable final float itemMagazine) {
        if (itemMagazine != -1) {
            this.magazineTextView.setText(itemView.getContext().getString(R.string.row_item_magazine, itemMagazine));
        }else {
            this.magazineTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemCapacity(@Nullable final float itemCapacity) {
        if (itemCapacity != -1) {
            this.capacityTextView.setText(itemView.getContext().getString(R.string.row_item_capacity, itemCapacity));
        }else {
            this.capacityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemDamage(@Nullable final Damage itemDamage) {
        if (itemDamage!= null && itemDamage.getChest0() > -1) {
            this.damageTextView.setText(itemView.getContext().getString(R.string.row_item_damage, itemDamage.getChest0()));
        }else {
            this.damageTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemStability(@Nullable final float itemStability) {
        if (itemStability!= -1) {
            this.stabilityTextView.setText(itemView.getContext().getString(R.string.row_item_stability, itemStability));
        }else {
            this.stabilityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemRange(@Nullable final float itemRange) {
        if (itemRange!= -1) {
            this.rangeTextView.setText(itemView.getContext().getString(R.string.row_item_range, itemRange));
        }else {
            this.rangeTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemRate(@Nullable final float itemRate) {
        if (itemRate != -1) {
            this.rateTextView.setText(itemView.getContext().getString(R.string.row_item_rate, itemRate));
        }else {
            this.rateTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemReload(@Nullable final float itemReload) {
        if (itemReload != -1) {
            this.reloadTextView.setText(itemView.getContext().getString(R.string.row_item_reload, itemReload));
        }else {
            this.reloadTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemIcon(final String itemImage,@NonNull final String category) {
        if (itemImage != null) {
            Picasso.with(itemView.getContext()).load(IMAGE_URL_BASE + category+ "/" + itemImage + ARG_RAW).into(imageImageView);
        }else {
            Picasso.with(itemView.getContext()).load(R.mipmap.ic_launcher).into(imageImageView);

        }
    }

    @Override
    public void bind(@NonNull final Item item) {
        setItemName(item.getName());
        setItemType(item.getType());
        setItemCategory(item.getCategory());
        setItemAmmo(item.getAmmo());
        setItemMagazine(item.getMagazine());
        setItemCapacity(item.getCapacity());
        setItemDamage(item.getDamage());
        setItemRange(item.getRange());
        setItemRate(item.getRate());
        setItemReload(item.getReload());
        setItemStability(item.getStability());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}
