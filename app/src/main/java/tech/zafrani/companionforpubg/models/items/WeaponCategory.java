package tech.zafrani.companionforpubg.models.items;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class WeaponCategory extends Category {

    @NonNull
    @SerializedName("weapons")
    private final Weapons weapons;


    public WeaponCategory(@NonNull final Weapons weapons) {
        this.weapons = weapons;
    }

    @Override
    public String toString() {
        return "WeaponCategory{" +
               "weapons=" + this.weapons.toString() +
               '}';
    }
}
