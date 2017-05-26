package tech.zafrani.companionforpubg.models.items;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {

    @NonNull
    @SerializedName("name")
    private final String name;

    @SerializedName("id")
    private final int id;

    @NonNull
    @SerializedName("image_url")
    private final String imageUrl;

    @SerializedName("capacity")
    private final int capacity;

    public Item(@NonNull final String name,
                final int id,
                @NonNull final String imageUrl,
                final int capacity) {
        this.name = name;
        this.id = id;
        this.imageUrl = imageUrl;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Item{" +
               "name='" + name + '\'' +
               ", id=" + id +
               ", imageUrl='" + imageUrl + '\'' +
               ", capacity=" + capacity +
               '}';
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    @NonNull
    public String getImageUrl() {
        return this.imageUrl;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
