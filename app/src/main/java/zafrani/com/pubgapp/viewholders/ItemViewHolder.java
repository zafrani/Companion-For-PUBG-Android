package zafrani.com.pubgapp.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import zafrani.com.pubgapp.R;


public class ItemViewHolder  extends RecyclerView.ViewHolder{
    private TextView itemName_tv;
    private TextView itemType_tv;
    private TextView itemCategory_tv;

    public ItemViewHolder(View itemView) {
        super(itemView);
        this.itemName_tv = (TextView) itemView.findViewById(R.id.item_name);
        this.itemType_tv = (TextView) itemView.findViewById(R.id.item_type);
        this.itemCategory_tv = (TextView) itemView.findViewById(R.id.item_category);
    }

    public void setItemName(String itemName) {
        this.itemName_tv.setText(itemName);
    }

    public void setItemType(String itemType) {
        this.itemType_tv.setText(itemType);
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory_tv.setText(itemCategory);
    }
}
