package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Items implements Serializable {
    @NonNull
    @SerializedName("categories")
    private final Categories categories;


    public Items(@NonNull final Categories categories) {
        this.categories = categories;
    }

    @NonNull
    public Categories getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Items{" +
                "categories=" + categories +
                '}';
    }
}
