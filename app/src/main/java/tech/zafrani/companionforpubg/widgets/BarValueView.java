package tech.zafrani.companionforpubg.widgets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import tech.zafrani.companionforpubg.R;


public class BarValueView extends FrameLayout {

    @NonNull
    private final TextView textView;

    @NonNull
    private final BarView barView;

    public BarValueView(@NonNull final Context context) {
        this(context, null);
    }

    public BarValueView(@NonNull final Context context,
                        @Nullable final AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BarValueView(@NonNull final Context context,
                        @Nullable final AttributeSet attrs,
                        final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.view_bar_value, this, true);
        this.textView = (TextView) findViewById(R.id.view_bar_value_text);
        this.barView = (BarView) findViewById(R.id.view_bar_value_bar);
    }

    public void setValue(@StringRes final int text,
                         final int value) {
        this.textView.setText(getContext().getString(text, value));
        this.barView.setValue(value);
    }

}
