package tech.zafrani.pubgapp.models.items;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import tech.zafrani.pubgapp.models.items.types.WeaponType;

public class WeaponItem extends Item {

    @NonNull
    @SerializedName("name")
    private final String name;

    @NonNull
    @SerializedName("type")
    private final WeaponType weaponType;

    @NonNull
    @SerializedName("image_url")
    private final String imageUrl;

    @NonNull
    @SerializedName("magazine")
    private final String magazine;

    @NonNull
    @SerializedName("ammo")
    private final String ammo;

    @SerializedName("range")
    private final int range;

    @SerializedName("stability")
    private final int stability;

    @SerializedName("rate")
    private final int rate;

    @SerializedName("reload")
    private final int reload;

    @SerializedName("capacity")
    private final int capacity;

    @NonNull
    @SerializedName("damage")
    private final Damage damage;


    public WeaponItem(@NonNull final String name,
                      @NonNull final WeaponType weaponType,
                      @NonNull final String imageUrl,
                      @NonNull final String magazine,
                      @NonNull final String ammo,
                      final int range,
                      final int stability,
                      final int rate,
                      final int reload,
                      final int capacity,
                      @NonNull final Damage damage) {
        this.name = name;
        this.weaponType = weaponType;
        this.imageUrl = imageUrl;
        this.magazine = magazine;
        this.ammo = ammo;
        this.range = range;
        this.stability = stability;
        this.rate = rate;
        this.reload = reload;
        this.capacity = capacity;
        this.damage = damage;
    }


    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public WeaponType getWeaponType() {
        return weaponType;
    }

    @NonNull
    public String getImageUrl() {
        return imageUrl;
    }

    @NonNull
    public String getMagazine() {
        return magazine;
    }

    @NonNull
    public String getAmmo() {
        return ammo;
    }

    public int getRange() {
        return range;
    }

    public int getStability() {
        return stability;
    }

    public int getRate() {
        return rate;
    }

    public int getReload() {
        return reload;
    }

    public int getCapacity() {
        return capacity;
    }

    @NonNull
    public Damage getDamage() {
        return damage;
    }
}
