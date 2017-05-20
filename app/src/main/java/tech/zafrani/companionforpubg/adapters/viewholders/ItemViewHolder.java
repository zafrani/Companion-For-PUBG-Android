package tech.zafrani.companionforpubg.adapters.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import tech.zafrani.companionforpubg.models.Item;


public class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public final static String ARG_RAW = "?raw=true";
    public final static String EMPTY_FIELD = " - ";
    public final static String ARG_ITEM = ItemViewHolder.class.getSimpleName() + ".ARG_ITEM";
    public Item item;

    public ItemViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
    }

    public void bind(final Item item) {
    }


    @Override
    public void onClick(View view) {
        //  Intent intent = new Intent(view.getContext(), ItemDetailActivity.class);
        // intent.putExtra(ARG_ITEM, item);
        //view.getContext().startActivity(intent);
        Toast.makeText(view.getContext(), "Coming soon!", Toast.LENGTH_SHORT).show();
    }

}
