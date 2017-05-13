package tech.zafrani.pubgapp.adapters.viewholders;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class VehicleViewHolder extends ItemViewHolder {
    private final String IMAGE_URL_BASE= "https://github.com/Zsteven44/PUBG-Companion-Images/blob/master/images/";
    private final String ARG_RAW = "?raw=true";
    private final static String EMPTY_FIELD = " - ";
    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView maxSpeedTextView;
    private final TextView accelerationTextView;
    private final TextView healthTextView;
    private final TextView seatsTextView;
    private final ImageView imageImageView;
    private final Context context;

    public VehicleViewHolder(@NonNull final View itemView,
                             @NonNull final Context context) {
        super(itemView);
        this.context = context;
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

    private void setItemMaxSpeed(@Nullable final Float itemMaxSpeed) {
        if (itemMaxSpeed!= null) {
            this.maxSpeedTextView.setText(context.getString(R.string.row_item_max_speed, itemMaxSpeed));
        } else {
            this.maxSpeedTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemAcceleration(@Nullable final Float itemAcceleration) {
        if (itemAcceleration != null) {
            this.accelerationTextView.setText(context.getString(R.string.row_item_acceleration, itemAcceleration));
        }else {
            this.accelerationTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemHealth(@Nullable final Float itemHealth) {
        if (itemHealth!= null) {
            this.healthTextView.setText(context.getString(R.string.row_item_health, itemHealth));
        }else {
            this.healthTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemSeats(@Nullable final Float itemSeats) {
        if (itemSeats != null) {
            this.seatsTextView.setText(context.getString(R.string.row_item_seats, itemSeats));
        }else {
            this.seatsTextView.setText(EMPTY_FIELD);
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
        setItemHealth(item.getHealth());
        setItemAcceleration(item.getAcceleration());
        setItemMaxSpeed(item.getMax_Speed());
        setItemSeats(item.getSeats());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}




