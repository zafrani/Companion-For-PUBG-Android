package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeaponCategory extends Category {

    @NonNull
    @SerializedName("weapons")
    private final List<WeaponItem> weaponItems;

    public WeaponCategory(@NonNull final List<WeaponItem> weaponItems) {
        this.weaponItems = weaponItems;
    }

    @NonNull
    public List<WeaponItem> getWeaponItems() {
        return weaponItems;
    }

    @Override
    public String toString() {
        return "WeaponCategory{" +
                "weaponItems=" + weaponItems +
                '}';
    }

    @Override
    public String getName() {
        return "Weapons";
    }
}
