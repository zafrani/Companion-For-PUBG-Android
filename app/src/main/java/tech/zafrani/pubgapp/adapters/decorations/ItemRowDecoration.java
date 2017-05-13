package tech.zafrani.pubgapp.adapters.decorations;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ItemRowDecoration extends RecyclerView.ItemDecoration{
    @NonNull
    final private Drawable divider;

    public ItemRowDecoration(@NonNull final Drawable divider) {
        this.divider = divider;
    }

    @Override
    public void getItemOffsets(final Rect outRect,
                               final View view,
                               final RecyclerView parent,
                               final RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) == 0) {
            return;
        }

        outRect.top = divider.getIntrinsicHeight();
    }

    @Override
    public void onDraw(final Canvas canvas,
                       final RecyclerView parent,
                       final RecyclerView.State state) {

        final int dividerLeft = parent.getPaddingLeft();
        final int dividerRight = parent.getWidth() - parent.getPaddingRight();

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);

            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            final int dividerTop = child.getBottom() + params.bottomMargin;
            final int dividerBottom = dividerTop + divider.getIntrinsicHeight();

            divider.setBounds(dividerLeft, dividerTop, dividerRight, dividerBottom);
            divider.draw(canvas);
        }
    }
}
