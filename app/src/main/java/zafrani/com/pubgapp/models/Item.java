package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

public class Item extends BaseItem{

    public Item(@NonNull String category, @NonNull String type, @NonNull String name) {
        super(category, type, name);
    }

    @Override
    public String toString() {
        return getName();
    }
}
