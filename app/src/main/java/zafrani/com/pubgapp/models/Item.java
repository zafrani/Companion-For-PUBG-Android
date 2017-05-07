package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Item{


    @NonNull
    @SerializedName("cat_name")
    private String category;
    @NonNull
    @SerializedName("type_name")
    private String type;
    @NonNull
    @SerializedName("name")
    private final String name;

    public Item(@NonNull final String category,
                    @NonNull final String type,
                    @NonNull final String name) {
        this.category = category;
        this.type = type;
        this.name = name;
    }

    public void setCategory(@NonNull final String cat_name) {
        this.category = cat_name;
    }

    public void setType(@NonNull final String type_name) {
        this.type = type_name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getName() {
        return name;
    }



}
