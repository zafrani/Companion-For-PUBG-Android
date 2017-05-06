package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {
    @NonNull
    @SerializedName("categories")
    private final List<Category> categories;

    public Items(@NonNull final List<Category> categories) {
        this.categories = categories;
    }


    @NonNull
    @Override
    public String toString() {
        return "Items{" +
                "categories=" + categories +
                '}';
    }

    @NonNull
    public List<Category> getCategories() {
        return categories;
    }
}
