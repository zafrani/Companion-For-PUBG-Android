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

    @Override
    public String toString() {
        return "Categories{" +
                "\nweaponCategory=" + weaponCategory +
                '}';
    }

    @NonNull
    public WeaponCategory getWeaponCategory() {
        return this.weaponCategory;
    }

    @NonNull
    public Category getCategory(@NonNull final Category.Name name) {
        switch (name) {
            case Weapons:
                return weaponCategory;
        }
        throw new IllegalStateException("unknown category");
    }

    @NonNull
    public Category getCategory(final int position) {
        if (position == 0) {
            return this.weaponCategory;
        }
        throw new IllegalStateException("unknown category");
    }

    public int size() {
        return weaponCategory == null ? 0 : 1;
    }
}