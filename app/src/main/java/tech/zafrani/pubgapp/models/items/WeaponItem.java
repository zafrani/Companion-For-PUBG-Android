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


    public WeaponItem(@NonNull final String name,
                      @NonNull final WeaponType weaponType,
                      @NonNull final String imageUrl) {
        this.name = name;
        this.weaponType = weaponType;
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "WeaponItem{" +
               "name='" + name + '\'' +
               ", weaponType=" + weaponType +
               ", imageUrl='" + imageUrl + '\'' +
               '}';
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @NonNull
    public String getImageUrl() {
        return this.imageUrl;
    }

    @NonNull
    public WeaponType getWeaponType() {
        return this.weaponType;
    }
}
