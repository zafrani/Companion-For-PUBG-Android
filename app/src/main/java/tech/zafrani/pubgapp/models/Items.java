package tech.zafrani.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
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
                "categories=" + Arrays.toString(categories.toArray()) +
                '}';
    }

    @NonNull
    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategory(@NonNull final String name) {

        for (Category category: categories) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return null;
    }
}
