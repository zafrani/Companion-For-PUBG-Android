package tech.zafrani.companionforpubg.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;


public class WeaponItem extends Item {

    private String category;
    @NonNull
    @SerializedName("type")
    private String type;
    @NonNull
    @SerializedName("id")
    private final int id;
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

    /* Not weapon related
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
    */




    public WeaponItem(@NonNull final String category,
                @NonNull final String type,
                @NonNull final String name,
                final int id,
                @Nullable final String ammo,
                final float magazine,
                final float capacity,
                @Nullable final Damage damage,
                final float range,
                final float stability,
                final float rate,
                final float reload,
                final String imageUrl) {
        super(imageUrl);
        this.category = category;
        this.type = type;
        this.name = name;
        this.ammo = ammo;
        this.id= id;
        this.magazine = magazine;
        this.capacity = capacity;
        this.damage=damage;
        this.range=range;
        this.stability = stability;
        this.rate =rate;
        this.reload = reload;

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
                ", imageUrl='" + getImageUrl() + '\'' +
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

    @Nullable
    public Damage getDamage() {
        return damage;
    }
}
