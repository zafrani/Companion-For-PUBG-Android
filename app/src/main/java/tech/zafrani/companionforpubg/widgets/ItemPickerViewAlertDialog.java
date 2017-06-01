package tech.zafrani.companionforpubg.widgets;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.ItemRecyclerViewAdapter;
import tech.zafrani.companionforpubg.adapters.RecyclerViewAdapter;
import tech.zafrani.companionforpubg.models.items.Item;

public class ItemPickerViewAlertDialog extends AlertDialog
        implements RecyclerViewAdapter.Listener<Item> {

    @NonNull
    private final RecyclerView recyclerView;

    @NonNull
    private final ItemRecyclerViewAdapter<Item> adapter;

    @NonNull
    private final Listener listener;

    //region AlertDialog
    protected ItemPickerViewAlertDialog(@NonNull final Context context,
                                        @NonNull final ViewGroup parent,
                                        @NonNull final Listener listener) {
        this(context, 0, parent, listener);
    }

    protected ItemPickerViewAlertDialog(@NonNull final Context context,
                                        @StyleRes final int themeResId,
                                        @NonNull final ViewGroup parent,
                                        @NonNull final Listener listener) {
        super(context, themeResId);
        final View view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_item_picker_view, parent, false);
        setView(view);
        this.listener = listener;
        this.adapter = new ItemRecyclerViewAdapter<>();
        this.recyclerView = (RecyclerView) view.findViewById(R.id.alert_dialog_item_picker_view_recycler);
        init();

    }

    protected ItemPickerViewAlertDialog(@NonNull final Context context,
                                        final boolean cancelable,
                                        @Nullable final OnCancelListener cancelListener,
                                        @NonNull final ViewGroup parent,
                                        @NonNull final Listener listener) {
        super(context, cancelable, cancelListener);
        final View view = LayoutInflater.from(context).inflate(R.layout.alert_dialog_item_picker_view, parent, false);
        setView(view);
        this.listener = listener;
        this.adapter = new ItemRecyclerViewAdapter<>();
        this.recyclerView = (RecyclerView) view.findViewById(R.id.alert_dialog_item_picker_view_recycler);
        init();
    }
    //endregion

    // region RecyclerViewAdapter.Listener
    @Override
    public void onClick(@NonNull final Item item) {
        this.listener.onItemSelected(item);
    }
    //endregion

    //region Methods
    private void init() {
        this.recyclerView.setLayoutManager(new LinearLayoutManager(this.recyclerView.getContext()));
        this.recyclerView.addItemDecoration(new DividerItemDecoration(this.recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        this.recyclerView.setAdapter(this.adapter);
        this.adapter.setListener(this);
    }

    public void setItems(@NonNull final List<? extends Item> items) {
        this.adapter.clear();
        this.adapter.addAll(items);
    }
    //endregion

    public interface Listener {
        void onItemSelected(@NonNull final Item item);
    }
}
