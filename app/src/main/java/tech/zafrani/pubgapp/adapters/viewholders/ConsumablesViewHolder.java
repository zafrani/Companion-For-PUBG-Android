package tech.zafrani.pubgapp.adapters.viewholders;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class ConsumablesViewHolder extends ItemViewHolder{

    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView healTextView;
    private final TextView maxHealTextView;
    private final TextView boostTextView;
    private final TextView activateTimeTextView;
    private final TextView maxStackTextView;
    private final TextView capacityTextView;
    private final ImageView imageImageView;

    public ConsumablesViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
        this.healTextView= (TextView) itemView.findViewById(R.id.row_item_heal);
        this.maxHealTextView= (TextView) itemView.findViewById(R.id.row_item_max_heal);
        this.boostTextView= (TextView) itemView.findViewById(R.id.row_item_boost);
        this.activateTimeTextView= (TextView) itemView.findViewById(R.id.row_item_activate_time);
        this.maxStackTextView= (TextView) itemView.findViewById(R.id.row_item_max_stack);
        this.capacityTextView= (TextView) itemView.findViewById(R.id.row_item_capacity);
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

    private void setItemHeal(@Nullable final float itemHeal) {
        if (itemHeal!= -1) {
            this.healTextView.setText(itemView.getContext().getString(R.string.row_item_heal, itemHeal));
        }else {
            this.healTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemMaxHeal(@Nullable final float itemMaxHeal) {
        if (itemMaxHeal!= -1) {
            this.maxHealTextView.setText(itemView.getContext().getString(R.string.row_item_max_heal, itemMaxHeal));
        }else {
            this.maxHealTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemBoost(@Nullable final float itemBoost) {
        if (itemBoost!= -1) {
            this.boostTextView.setText(itemView.getContext().getString(R.string.row_item_boost, itemBoost));
        }else {
            this.boostTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemActivateTime(@Nullable final float itemActivateTime) {
        if (itemActivateTime!= -1) {
            this.activateTimeTextView.setText(itemView.getContext().getString(R.string.row_item_activate_time, itemActivateTime));
        }else {
            this.activateTimeTextView.setText(EMPTY_FIELD);
        }
    }private void setItemMaxStack(@Nullable final float itemMaxStack) {
        if (itemMaxStack != -1) {
            this.maxStackTextView.setText(itemView.getContext().getString(R.string.row_item_max_stack, itemMaxStack));
        }else {
            this.maxStackTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemCapacity(@Nullable final float itemCapacity) {
        if (itemCapacity != -1) {
            this.capacityTextView.setText(itemView.getContext().getString(R.string.row_item_capacity, itemCapacity));
        }else {
            this.capacityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemIcon(final String itemImage, String category) {
        if (itemImage != null) {
            Picasso.with(itemView.getContext()).load(IMAGE_URL_BASE + category+ "/" + itemImage + ARG_RAW).into(imageImageView);
        }else {
            Picasso.with(itemView.getContext()).load(R.mipmap.ic_launcher).into(imageImageView);

        }
    }

    @Override
    public void bind(Item item) {
        setItemName(item.getName());
        setItemType(item.getType());
        setItemCategory(item.getCategory());
        setItemHeal(item.getHeal());
        setItemMaxHeal(item.getMax_Heal());
        setItemBoost(item.getBoost());
        setItemActivateTime(item.getActivate_Time());
        setItemMaxStack(item.getMax_Stack());
        setItemCategory(item.getCategory());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}





