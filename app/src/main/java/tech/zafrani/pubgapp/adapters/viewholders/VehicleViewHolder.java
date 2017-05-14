package tech.zafrani.pubgapp.adapters.viewholders;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class VehicleViewHolder extends ItemViewHolder {

    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView maxSpeedTextView;
    private final TextView accelerationTextView;
    private final TextView healthTextView;
    private final TextView seatsTextView;
    private final ImageView imageImageView;

    public VehicleViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
        this.maxSpeedTextView= (TextView) itemView.findViewById(R.id.row_item_max_speed);
        this.accelerationTextView= (TextView) itemView.findViewById(R.id.row_item_acceleration);
        this.healthTextView= (TextView) itemView.findViewById(R.id.row_item_health);
        this.seatsTextView= (TextView) itemView.findViewById(R.id.row_item_seats);
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

    private void setItemMaxSpeed(@Nullable final float itemMaxSpeed) {
        if (itemMaxSpeed!= -1) {
            this.maxSpeedTextView.setText(itemView.getContext().getString(R.string.row_item_max_speed, itemMaxSpeed));
        } else {
            this.maxSpeedTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemAcceleration(@Nullable final float itemAcceleration) {
        if (itemAcceleration != -1) {
            this.accelerationTextView.setText(itemView.getContext().getString(R.string.row_item_acceleration, itemAcceleration));
        }else {
            this.accelerationTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemHealth(@Nullable final float itemHealth) {
        if (itemHealth!= -1) {
            this.healthTextView.setText(itemView.getContext().getString(R.string.row_item_health, itemHealth));
        }else {
            this.healthTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemSeats(@Nullable final float itemSeats) {
        if (itemSeats != -1) {
            this.seatsTextView.setText(itemView.getContext().getString(R.string.row_item_seats, itemSeats));
        }else {
            this.seatsTextView.setText(EMPTY_FIELD);
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
        setItemHealth(item.getHealth());
        setItemAcceleration(item.getAcceleration());
        setItemMaxSpeed(item.getMax_Speed());
        setItemSeats(item.getSeats());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}




