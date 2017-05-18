package tech.zafrani.pubgapp.adapters.viewholders;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;

public abstract class BaseViewHolder<Model extends Serializable> extends RecyclerView.ViewHolder {
    private final Listener<Model> listener;


    public BaseViewHolder(@NonNull final View itemView,
                          @NonNull final Listener<Model> listener) {
        super(itemView);
        this.listener = listener;
    }

    public void bind(final int position) {

    }

    @Nullable
    protected Model get(final int position) {
        return this.listener.get(position);
    }

    public interface Listener<Model extends Serializable> {

        @Nullable
        Model get(int position);
    }
}