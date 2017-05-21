package tech.zafrani.pubgapp.models.items.categories;


import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

import tech.zafrani.pubgapp.models.items.WeaponItem;

public class WeaponCategory extends CategoryImpl<WeaponItem> {
    @NonNull
    @SerializedName("weapons")
    private final List<WeaponItem> weapons;

    public WeaponCategory(@NonNull final List<WeaponItem> weapons) {
        this.weapons = weapons;

    }

    @Override
    public String toString() {
        return "WeaponCategory{" +
               "\nweapons=" + Arrays.toString(this.weapons.toArray()) +
               '}';
    }

    @StringRes
    @Override
    public int getCategoryNameRes() {
        return Name.Weapons.getStringRes();
    }

    @NonNull
    @Override
    public List<WeaponItem> getItems() {
        return this.weapons;
    }


}
