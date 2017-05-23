package tech.zafrani.companionforpubg.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class RecyclerViewAdapter<Model extends Serializable, VH extends RecyclerViewAdapter.ViewHolder> extends RecyclerView.Adapter<VH> {

    private final List<Model> models = new ArrayList<>();

    public RecyclerViewAdapter() {

    }

    public RecyclerViewAdapter(@NonNull final List<Model> models) {
        addAll(models);

    }

    //region RecyclerViewAdapter

    @Override
    public void onBindViewHolder(final VH holder,
                                 final int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return this.models.size();
    }

    //endregion

    //region methods
    public void add(@NonNull final Model model) {
        this.models.add(model);
        notifyItemChanged(this.models.size() - 1);
    }

    public void addAll(@NonNull final List<Model> models) {
        final int startPosition = getItemCount();
        this.models.addAll(models);
        notifyItemRangeInserted(startPosition, models.size());
    }

    @NonNull
    public Model get(final int position) {
        if (position < 0 || position >= this.models.size()) {
            throw new IllegalStateException("Position out of models bounds.");
        }
        return this.models.get(position);
    }
    //endregion


    public static abstract class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
        }

        public abstract void bind(int position);

    }
}
