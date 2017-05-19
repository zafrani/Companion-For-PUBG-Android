package tech.zafrani.pubgapp.models.items.categories;


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
}
