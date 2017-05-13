package tech.zafrani.pubgapp.models;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

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


    @Nullable
    @SerializedName("ammo")
    private final String ammo;
    @SerializedName("magazine")
    private final Float magazine;
    @SerializedName("capacity")
    private final Float capacity;
    @Nullable
    @SerializedName("damage")
    private final HashMap<String, String> damage;
    @SerializedName("stability")
    private final Float stability;
    @SerializedName("rate")
    private final Float rate;
    @SerializedName("range")
    private final Float range;
    @SerializedName("reload")
    private final Float reload;
    @SerializedName("protection")
    private final Float protection;
    @SerializedName("boost")
    private final Float boost;
    @SerializedName("heal")
    private final Float heal;
    @SerializedName("max_heal")
    private final Float max_heal;
    @SerializedName("activate_time")
    private final Float activate_time;
    @SerializedName("max_stack")
    private final Float max_stack;
    @SerializedName("health")
    private final Float health;
    @SerializedName("max_speed")
    private final Float max_speed;
    @SerializedName("acceleration")
    private final Float acceleration;
    @SerializedName("seats")
    private final Float seats;


    @SerializedName("image_url")
    private final String imageUrl;

    public Item(@NonNull final String category,
                @NonNull final String type,
                @NonNull final String name,
                @Nullable final String ammo,
                @Nullable final Float magazine,
                @Nullable final Float capacity,
                @Nullable final HashMap<String, String> damage,
                @Nullable final Float range,
                @Nullable final Float stability,
                @Nullable final Float rate,
                @Nullable final Float reload,
                @Nullable final Float protection,
                @Nullable final Float boost,
                @Nullable final Float heal,
                @Nullable final Float max_heal,
                @Nullable final Float activate_time,
                @Nullable final Float max_stack,
                @Nullable final Float health,
                @Nullable final Float max_speed,
                @Nullable final Float acceleration,
                @Nullable final Float seats,
                @Nullable final String imageUrl) {
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
    @Nullable
    public Float getMagazine() {
        return magazine;
    }
    @Nullable
    public Float getCapacity() {
        return capacity;
    }
    @Nullable
    public Float getStability() {
        return stability;
    }
    @Nullable
    public Float getRate() {
        return rate;
    }
    @Nullable
    public Float getRange() {
        return range;
    }
    @Nullable
    public Float getReload() {
        return reload;
    }
    @Nullable
    public Float getProtection() {
        return protection;
    }
    @Nullable
    public Float getBoost() {
        return boost;
    }
    @Nullable
    public Float getHeal() {
        return heal;
    }
    @Nullable
    public Float getMax_Heal() {
        return max_heal;
    }
    @Nullable
    public Float getActivate_Time() {
        return activate_time;
    }
    @Nullable
    public Float getMax_Stack() {
        return max_stack;
    }
    @Nullable
    public Float getHealth() {
        return health;
    }
    @Nullable
    public Float getMax_Speed() {
        return max_speed;
    }
    @Nullable
    public Float getAcceleration() {
        return acceleration;
    }
    @Nullable
    public Float getSeats() {
        return seats;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    @Nullable
    public HashMap<String, String> getDamage() {
        return damage;
    }
}
