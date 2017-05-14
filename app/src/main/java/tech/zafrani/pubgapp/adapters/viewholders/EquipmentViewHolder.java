package tech.zafrani.pubgapp.adapters.viewholders;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class EquipmentViewHolder extends ItemViewHolder {

    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView capacityTextView;
    private final TextView protectionTextView;
    private final ImageView imageImageView;

    public EquipmentViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
        this.capacityTextView= (TextView) itemView.findViewById(R.id.row_item_capacity);
        this.protectionTextView= (TextView) itemView.findViewById(R.id.row_item_protection);
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

    private void setItemCapacity(@Nullable final float itemCapacity) {
        if (itemCapacity != -1) {
            this.capacityTextView.setText(itemView.getContext().getString(R.string.row_item_capacity, itemCapacity));
        }else {
            this.capacityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemProtection(@Nullable final float itemProtection) {
        if (itemProtection!= -1) {
            this.protectionTextView.setText(itemView.getContext().getString(R.string.row_item_protection, itemProtection));
        }else {
            this.protectionTextView.setText(EMPTY_FIELD);
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
        setItemCapacity(item.getCapacity());
        setItemProtection(item.getProtection());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}


