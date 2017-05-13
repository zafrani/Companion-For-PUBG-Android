package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import tech.zafrani.pubgapp.models.Item;


public class ItemViewHolder extends RecyclerView.ViewHolder {
    public final static String IMAGE_URL_BASE= "https://github.com/Zsteven44/PUBG-Companion-Images/blob/master/images/";
    public final static String ARG_RAW = "?raw=true";
    public final static String EMPTY_FIELD = " - ";

    public ItemViewHolder(View itemView) {
        super(itemView);
    }

    public void bind(final Item item){};

}
