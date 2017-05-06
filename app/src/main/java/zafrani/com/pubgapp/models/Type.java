package zafrani.com.pubgapp.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Type {
    @NonNull
    @SerializedName("type_name")
    private final String name;
    @NonNull
    @SerializedName("items")
    private final List<Item> items;

    public Type(@NonNull final String type_name,
                @NonNull final List<Item> items) {
        this.name = type_name;
        this.items = items;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }

    @NonNull
    public String getType_name() {
        return name;
    }

    @NonNull
    public List<Item> getItems() {
        return items;
    }
}
