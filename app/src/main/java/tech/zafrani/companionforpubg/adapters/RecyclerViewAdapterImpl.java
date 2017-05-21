package tech.zafrani.companionforpubg.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import tech.zafrani.companionforpubg.adapters.viewholders.BaseViewHolder;

public abstract class RecyclerViewAdapterImpl<Model extends Serializable>
        extends RecyclerView.Adapter<RecyclerView.ViewHolder>
            implements RecyclerViewAdapter<Model>,
                BaseViewHolder.Listener<Model> {

    @NonNull
    private final List<Model> models;

    public RecyclerViewAdapterImpl() {
        this(new ArrayList<Model>());
    }

    public RecyclerViewAdapterImpl(@NonNull final List<Model> models) {
        this.models = models;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder,
                                 final int position) {

    }

    @Override
    public int getItemCount() {
        return this.models.size();
    }

    @Nullable
    @Override
    public Model get(final int position) {
        if (position < 0 || position >= this.models.size()) {
            return null;
        }
        return this.models.get(position);
    }

    public void addAll(@NonNull final List<Model> models) {
        final int startPosition = this.models.size();
        this.models.addAll(models);
        this.notifyItemRangeInserted(startPosition, this.models.size()-1);
    }

    public void add(@NonNull final Model model) {
        this.models.add(model);
        notifyItemInserted(this.models.size() - 1);

    }





}
