package tech.zafrani.pubgapp.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Type implements Serializable {
    @NonNull
    @SerializedName("type_name")
    private final String name;
    @NonNull
    @SerializedName("items")
    private final List<Item> items;

    public Type(@NonNull final String name,
                @NonNull final List<Item> items) {
        this.name = name;
        this.items = items;
    }

    @NonNull
    @Override
    public String toString() {
        return "Type{" +
               "name='" + name + '\'' +
               ", items=" + Arrays.toString(items.toArray()) +
               '}';
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public List<Item> getItems() {
        return items;
    }

    void updateChildren(@NonNull final String categoryName) {
        for (final Item item : getItems()) {
            item.setCategory(categoryName);
            item.setType(name);
        }
    }
}
