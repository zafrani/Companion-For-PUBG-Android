package tech.zafrani.companionforpubg.widgets;


import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.items.Item;
import tech.zafrani.companionforpubg.utils.Constants;

public class ItemPickerView extends FrameLayout
        implements ItemPickerViewAlertDialog.Listener {
    @NonNull
    private final TextView titleTextView;

    @NonNull
    private final TextView valueTextView;

    @NonNull
    private final ImageView itemImageView;
    @NonNull
    private final ImageView clearImageView;

    @NonNull
    private final ItemPickerViewAlertDialog alertDialog;

    //region FrameLayout
    public ItemPickerView(@NonNull final Context context) {
        this(context, null);
    }

    public ItemPickerView(@NonNull final Context context,
                          @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ItemPickerView(@NonNull final Context context,
                          @Nullable final AttributeSet attrs,
                          final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_item_picker, this, true);
        this.titleTextView = (TextView) findViewById(R.id.view_item_picker_title_text);
        this.valueTextView = (TextView) findViewById(R.id.view_item_picker_value_text);
        this.itemImageView = (ImageView) findViewById(R.id.view_item_picker_image);
        this.clearImageView = (ImageView) findViewById(R.id.view_item_picker_clear);
        this.alertDialog = new ItemPickerViewAlertDialog(getContext(), ItemPickerView.this, this);
        final TypedArray typedArray = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ItemPickerView,
                0,
                0);

        if (typedArray == null) {
            return;
        }

        try {
            final String text = typedArray.getString(R.styleable.ItemPickerView_titleText);
            titleTextView.setText(text);
        } finally {
            typedArray.recycle();
        }
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
        this.clearImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
    }
    //endregion

    //region ItemPickerViewAlertDialog.Listener
    @Override
    public void onItemSelected(@NonNull final Item item) {
        this.clearImageView.setVisibility(VISIBLE);
        this.alertDialog.dismiss();
        this.valueTextView.setText(item.getName());
        Picasso.with(getContext())
               .load(Constants.ITEM_IMAGE_URL + item.getImageUrl())
               .into(this.itemImageView);
    }
    //endregion

    //region Methods
    private void clear() {
        this.clearImageView.setVisibility(INVISIBLE);
        this.itemImageView.setImageDrawable(null);
        this.valueTextView.setText(null);
    }

    public void setValueTextView(@Nullable final String text) {
        this.valueTextView.setText(text);
    }

    public void setItems(@NonNull final List<? extends Item> items) {
        this.alertDialog.setItems(items);
    }
    //endregion

}
