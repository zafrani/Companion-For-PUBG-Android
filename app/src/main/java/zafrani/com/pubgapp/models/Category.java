package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Category {
    @SerializedName("cat_name")
    private String name;

    public Category(@NonNull final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
               "name='" + name + '\'' +
               '}';
    }
}
