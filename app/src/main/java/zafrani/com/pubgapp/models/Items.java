package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {
    @SerializedName("categories")
    private final List<Category> categories;

    public Items(@NonNull final List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Items contains: { " +
                " x categories," +
                " y types, " +
                " z items }" ;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
