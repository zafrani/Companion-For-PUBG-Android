package zafrani.com.pubgapp.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Type {
    @NonNull
    @SerializedName("type_name")
    private final String type_name;
    @NonNull
    @SerializedName("items")
    private final List<Item> items;

    public Type(@NonNull String type_name,
                @NonNull List<Item> items) {
        this.type_name = type_name;
        this.items = items;
    }

    @Override
    public String toString() {
        return type_name;
    }

    @NonNull
    public String getType_name() {
        return type_name;
    }

    @NonNull
    public List<Item> getItems() {
        return items;
    }
}
