package tech.zafrani.pubgapp.models.items.categories;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

import tech.zafrani.pubgapp.models.items.types.WeaponType;

public class WeaponCategory extends CategoryImpl<WeaponType> {
    @SerializedName("types")
    private final List<WeaponType> weaponTypes;

    public WeaponCategory(@NonNull final List<WeaponType> weaponTypes) {
        super(Name.Weapons);
        this.weaponTypes = weaponTypes;
    }

    @Override
    public String toString() {
        return "WeaponCategory{" +
               "\nweaponTypes=" + Arrays.toString(this.weaponTypes.toArray()) +
               '}';
    }

    @NonNull
    @Override
    public List<WeaponType> getItems() {
        return this.weaponTypes;
    }
}
