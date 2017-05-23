package tech.zafrani.companionforpubg.models.items;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Items {

    @SerializedName("categories")
    private final Categories categories;

    public Items(@NonNull final Categories categories) {
        this.categories = categories;
    }

    public Categories getCategories() {
        return this.categories;
    }

    @Override
    public String toString() {
        return "Items{" +
               "categories=" + this.categories.toString() +
               '}';
    }

}
