package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Category {
    @SerializedName("cat_name")
    private String cat_name;

    @Nullable
    @SerializedName("types")
    private List<Type> types;

    @Nullable
    @SerializedName("items")
    private List<Item> items;



    public Category(@NonNull final String cat_name, @Nullable final List<Type> types, @Nullable final List<Item> items) {
        this.cat_name = cat_name;
        this.types = types;
        this.items = items;

    }

    @Nullable
    public List<Type> getTypes() {
        return types;
    }

    @Nullable
    public List<Item> getItems() {
        return items;
    }

    public String getName() {
        return cat_name;
    }

    @Override
    public String toString() {
        return  cat_name;
    }
}
