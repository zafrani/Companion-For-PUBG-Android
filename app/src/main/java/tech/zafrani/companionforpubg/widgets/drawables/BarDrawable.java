package tech.zafrani.companionforpubg.widgets.drawables;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import tech.zafrani.companionforpubg.R;

public class BarDrawable extends BaseDrawable {
    /**
     * Number of bars.
     */
    private static final int NUMBER_OF_BARS = 10;

    /**
     * Percentage of space there should be between each bar.
     */
    private static final float MARGIN_RATIO = .02f;


    @NonNull
    private final Paint backgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    @NonNull
    private final Paint highlightPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

    @NonNull
    private final List<Bar> bars = new ArrayList<>(NUMBER_OF_BARS);

    private final int width;
    private final int height;
    private final float marginPerBar;
    private final float barWidth;

    private int value = 42;

    public BarDrawable(@NonNull final Context context,
                       final int width,
                       final int height) {
        this.width = width;
        this.height = height;
        this.marginPerBar = (width * MARGIN_RATIO) / (NUMBER_OF_BARS - 1);
        this.backgroundPaint.setColor(ContextCompat.getColor(context, R.color.darkGray));
        this.highlightPaint.setColor(ContextCompat.getColor(context, R.color.accent));
        this.barWidth = width / NUMBER_OF_BARS;

        for (int i = 0; i < NUMBER_OF_BARS; i++) {
            bars.add(new Bar(i));
        }
    }

    @Override
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override
    public void draw(@NonNull final Canvas canvas) {
        for (final Bar bar : bars) {
            bar.draw(canvas);
        }
    }

    public void setValue(final int value) {
        this.value = value;
    }

    private class Bar extends BaseDrawable {
        private final int offset;

        public Bar(final int offset) {
            this.offset = offset;
        }

        @Override
        public void draw(@NonNull final Canvas canvas) {
            final float barWidthToUse;
            if (this.offset == NUMBER_OF_BARS - 1) {
                barWidthToUse = barWidth;
            } else {
                barWidthToUse = barWidth - marginPerBar;
            }
            final float startX = this.offset * barWidth;
            final float endX = startX + barWidthToUse;
            canvas.drawRect(startX, 0, endX, canvas.getHeight(), backgroundPaint);
            final int minOffset = value / 10;
            if (minOffset > this.offset) {
                canvas.drawRect(startX, 0, endX, canvas.getHeight(), highlightPaint);
                return;
            }
            if (value > offset * 10) {
                final int fillRatio = value % 10;
                if (fillRatio > 0) {
                    canvas.drawRect(startX, 0, startX + (barWidthToUse * (fillRatio / 10f)), canvas.getHeight(), highlightPaint);
                }
            }

        }
    }
}
