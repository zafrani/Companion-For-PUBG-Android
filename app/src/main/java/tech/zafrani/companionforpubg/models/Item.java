package tech.zafrani.companionforpubg.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {


    @SerializedName("image_url")
    private final String imageUrl;

    public Item(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
