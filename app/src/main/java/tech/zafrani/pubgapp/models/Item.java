package tech.zafrani.pubgapp.models;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {


    @NonNull
    @SerializedName("cat_name")
    private String category;
    @NonNull
    @SerializedName("type_name")
    private String type;
    @NonNull
    @SerializedName("name")
    private final String name;

    @SerializedName("ammo")
    private final String ammo;
    @SerializedName("magazine")
    private final float magazine;
    @SerializedName("capacity")
    private final float capacity;

    @SerializedName("damage")
    private final Damage damage;
    @SerializedName("stability")
    private final float stability;
    @SerializedName("rate")
    private final float rate;
    @SerializedName("range")
    private final float range;
    @SerializedName("reload")
    private final float reload;
    @SerializedName("protection")
    private final float protection;
    @SerializedName("boost")
    private final float boost;
    @SerializedName("heal")
    private final float heal;
    @SerializedName("max_heal")
    private final float max_heal;
    @SerializedName("activate_time")
    private final float activate_time;
    @SerializedName("max_stack")
    private final float max_stack;
    @SerializedName("health")
    private final float health;
    @SerializedName("max_speed")
    private final float max_speed;
    @SerializedName("acceleration")
    private final float acceleration;
    @SerializedName("seats")
    private final float seats;


    @SerializedName("image_url")
    private final String imageUrl;


    public Item(@NonNull final String category,
                @NonNull final String type,
                @NonNull final String name,
                @Nullable final String ammo,
                 final float magazine,
                 final float capacity,
                 @Nullable final Damage damage,
                 final float range,
                 final float stability,
                 final float rate,
                 final float reload,
                 final float protection,
                 final float boost,
                 final float heal,
                 final float max_heal,
                 final float activate_time,
                 final float max_stack,
                 final float health,
                 final float max_speed,
                 final float acceleration,
                 final float seats,
                 final String imageUrl) {
        this.category = category;
        this.type = type;
        this.name = name;
        this.ammo = ammo;
        this.magazine = magazine;
        this.capacity = capacity;
        this.damage=damage;
        this.range=range;
        this.stability = stability;
        this.rate =rate;
        this.reload = reload;
        this.protection = protection;
        this.boost = boost;
        this.heal = heal;
        this.max_heal = max_heal;
        this.activate_time = activate_time;
        this.max_stack = max_stack;
        this.health = health;
        this.max_speed = max_speed;
        this.acceleration= acceleration;
        this.seats = seats;
        this.imageUrl = imageUrl;

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
                ", damage=" + damage +
                ", stability=" + stability +
                ", rate=" + rate +
                ", range=" + range +
                ", imageUrl='" + imageUrl + '\'' +
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

    @Nullable
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

    public float getReload() {
        return reload;
    }

    public float getProtection() {
        return protection;
    }

    public float getBoost() {
        return boost;
    }

    public float getHeal() {
        return heal;
    }

    public float getMax_Heal() {
        return max_heal;
    }

    public float getActivate_Time() {
        return activate_time;
    }

    public float getMax_Stack() {
        return max_stack;
    }

    public float getHealth() {
        return health;
    }

    public float getMax_Speed() {
        return max_speed;
    }

    public float getAcceleration() {
        return acceleration;
    }

    public float getSeats() {
        return seats;
    }
    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

    @Nullable
    public Damage getDamage() {
        return damage;
    }
}
