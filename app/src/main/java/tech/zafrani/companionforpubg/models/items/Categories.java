package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Categories {

    @SerializedName("weapon_category")
    private final WeaponCategory weaponCategory;

    public Categories(@NonNull final WeaponCategory weaponCategory) {
        this.weaponCategory = weaponCategory;
    }

    public WeaponCategory getWeaponCategory() {
        return this.weaponCategory;
    }


    @Override
    public String toString() {
        return "Categories{" +
               "weaponCategory=" + this.weaponCategory.toString() +
               '}';
    }
}
