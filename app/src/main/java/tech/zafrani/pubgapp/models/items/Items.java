package tech.zafrani.pubgapp.models.items;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import tech.zafrani.pubgapp.models.items.categories.Categories;

public class Items implements Serializable {
    @NonNull
    @SerializedName("categories")
    private final Categories categories;


    public Items(@NonNull final Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Items{" +
               "\ncategories=" + categories +
               '}';
    }

    @NonNull
    public Categories getCategories() {
        return this.categories;
    }
}
