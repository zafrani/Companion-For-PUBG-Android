package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Categories {

    @NonNull
    @SerializedName("weapon_category")
    private final WeaponCategory weaponCategory;


    public Categories(@NonNull final WeaponCategory weaponCategory) {
        this.weaponCategory = weaponCategory;
    }

    @NonNull
    public WeaponCategory getWeaponCategory() {
        return weaponCategory;
    }

    public Category getCategory(@NonNull final String name) {
        switch(name) {
            case "Weapons":
                return weaponCategory;
        }
        throw new IllegalStateException("unknown category");
    }
    public Category getCategory(final int position) {
        switch(position) {
            case 0:
                return this.weaponCategory;
        }
        throw new IllegalStateException("unknown category");
    }

    @Override
    public String toString() {
        return "Categories{" +
                "weapon_category=" + weaponCategory +
                '}';
    }

    public int size(){
        return weaponCategory == null ? 0 : 1;
    }
}
