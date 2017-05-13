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

public class AmmunitionViewHolder extends ItemViewHolder {
    private final String IMAGE_URL_BASE= "https://github.com/Zsteven44/PUBG-Companion-Images/blob/master/images/";
    private final String ARG_RAW = "?raw=true";
    private final static String EMPTY_FIELD = " - ";
    private final TextView nameTextView;
    private final TextView typeTextView;
    private final TextView categoryTextView;
    private final TextView capacityTextView;
    private final ImageView imageImageView;
    private final Context context;

    public AmmunitionViewHolder(@NonNull final View itemView, @NonNull final Context context) {
        super(itemView);
        this.context = context;
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
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
    private void setItemCapacity(@Nullable final Float itemCapacity) {
        if (itemCapacity != null) {
            this.capacityTextView.setText(context.getString(R.string.row_item_capacity, itemCapacity));
        }else {
            this.capacityTextView.setText(EMPTY_FIELD);
        }
    }
    private void setItemIcon(final String itemImage,@NonNull final String category) {
        if (itemImage != null) {
            Picasso.with(context).load(IMAGE_URL_BASE + category+ "/" + itemImage + ARG_RAW).into(imageImageView);
        }else {
            Picasso.with(context).load(R.mipmap.ic_launcher).into(imageImageView);

        }
    }

    @Override
    public void bind(@NonNull final Item item) {

        setItemName(item.getName());
        setItemType(item.getType());
        setItemCategory(item.getCategory());
        setItemCapacity(item.getCapacity());
        setItemIcon(item.getImageUrl(), item.getCategory());
    }
}
