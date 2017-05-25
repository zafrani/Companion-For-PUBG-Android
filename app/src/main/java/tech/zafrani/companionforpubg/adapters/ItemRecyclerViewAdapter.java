package tech.zafrani.companionforpubg.adapters;


import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.items.Item;
import tech.zafrani.companionforpubg.utils.Constants;

public class ItemRecyclerViewAdapter extends RecyclerViewAdapter<Item, ItemRecyclerViewAdapter.ItemViewHolder> {
    public ItemRecyclerViewAdapter(@NonNull final List<Item> items) {
        super(items);
    }

    @Override
    public ItemRecyclerViewAdapter.ItemViewHolder onCreateViewHolder(final ViewGroup parent,
                                                                     final int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
    }

    public class ItemViewHolder extends RecyclerViewAdapter.ViewHolder {
        private final TextView textView;
        private final ImageView imageView;

        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.row_item_text);
            this.imageView = (ImageView) itemView.findViewById(R.id.row_item_image);
        }

        @Override
        public void bind(int position) {
            super.bind(position);
            final Item item = get(position);
            Picasso.with(this.itemView.getContext())
                   .load(Constants.ITEM_IMAGE_URL + item.getImageUrl())
                   .into(this.imageView);
            this.textView.setText(item.getName());
        }
    }
}
