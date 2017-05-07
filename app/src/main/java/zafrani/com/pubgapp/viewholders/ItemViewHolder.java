package zafrani.com.pubgapp.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import zafrani.com.pubgapp.R;


public class ItemViewHolder  extends RecyclerView.ViewHolder{
    private TextView nameTextView;
    private TextView typeTextView;
    private TextView categoryTextView;

    public ItemViewHolder(@NonNull final View itemView) {
        super(itemView);
        this.nameTextView = (TextView) itemView.findViewById(R.id.row_item_name);
        this.typeTextView= (TextView) itemView.findViewById(R.id.row_item_type);
        this.categoryTextView = (TextView) itemView.findViewById(R.id.row_item_category);
    }

    @NonNull
    public void setItemName(@NonNull final String itemName) {
        this.nameTextView.setText(itemName);
    }
    @NonNull
    public void setItemType(@NonNull final String itemType) {
        this.typeTextView.setText(itemType);
    }
    @NonNull
    public void setItemCategory(@NonNull final String itemCategory) {
        this.categoryTextView.setText(itemCategory);
    }
}
