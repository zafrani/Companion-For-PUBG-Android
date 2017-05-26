package tech.zafrani.companionforpubg.widgets;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import tech.zafrani.companionforpubg.widgets.drawables.BarDrawable;

public class BarView extends FrameLayout {
    private BarDrawable barDrawable;
    private int value = 0;

    public BarView(@NonNull final Context context) {
        this(context, null);
    }

    public BarView(@NonNull final Context context,
                   @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarView(@NonNull final Context context,
                   @Nullable final AttributeSet attrs,
                   final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        post(new Runnable() {
            @Override
            public void run() {
                barDrawable = new BarDrawable(context, getWidth(), getHeight());
                barDrawable.setValue(value);
                setBackground(barDrawable);
            }
        });
    }

    public void setValue(final int value) {
        this.value = value;
        postInvalidate();

    }


}
