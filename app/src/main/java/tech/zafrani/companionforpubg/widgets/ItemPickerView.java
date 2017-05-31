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

import tech.zafrani.companionforpubg.R;

public class ItemPickerView extends FrameLayout
        implements View.OnClickListener {
    @NonNull
    private final TextView titleTextView;

    @NonNull
    private final TextView valueTextView;

    @NonNull
    private final ImageView imageView;

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
        this.imageView = (ImageView) findViewById(R.id.view_item_picker_image);

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
        setOnClickListener(this);
    }

    //endregion

    //region OnClickListener
    @Override
    public void onClick(View v) {
        new ItemPickerViewAlertDialog(getContext(),this).show();
    }
    //endregion

    //region Methods

    public void setValueTextView(@Nullable final String text) {
        this.valueTextView.setText(text);
    }

    //endregion

}
