package tech.zafrani.pubgapp.models;


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
    @NonNull
    @SerializedName("ammo")
    private final String ammo;

    @SerializedName("magazine")
    private final float magazine;
    @SerializedName("capacity")
    private final float capacity;
    @SerializedName("stability")
    private final float stability;
    @SerializedName("rate")
    private final float rate;
    @SerializedName("range")
    private final float range;


    public Item(@NonNull final String category,
                @NonNull final String type,
                @NonNull final String name,
                @NonNull final String ammo,
                final float magazine,
                final float capacity,
                final float range,
                final float stability,
                final float rate) {
        this.category = category;
        this.type = type;
        this.name = name;
        this.ammo = ammo;
        this.magazine = magazine;
        this.capacity = capacity;
        this.range=range;
        this.stability = stability;
        this.rate =rate;

    }

    public void setCategory(@NonNull final String cat_name) {
        this.category = cat_name;
    }

    public void setType(@NonNull final String type_name) {
        this.type = type_name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "category='" + category + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", ammo='" + ammo + '\'' +
                ", magazine=" + magazine +
                ", capacity=" + capacity +
                ", stability=" + stability +
                ", rate=" + rate +
                ", range=" + range +
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

    @NonNull
    public String getAmmo() {
        return ammo;
    }

    public float getMagazine() {
        return magazine;
    }

    public float getCapacity() {
        return capacity;
    }

    public float getStability() {
        return stability;
    }

    public float getRate() {
        return rate;
    }

    public float getRange() {
        return range;
    }
}
