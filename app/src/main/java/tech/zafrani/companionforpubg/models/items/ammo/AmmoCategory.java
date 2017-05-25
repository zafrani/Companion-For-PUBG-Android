package tech.zafrani.companionforpubg.models.items.ammo;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tech.zafrani.companionforpubg.models.items.Category;
import tech.zafrani.companionforpubg.models.items.weapons.Weapon;
import tech.zafrani.companionforpubg.models.items.weapons.WeaponList;


public class AmmoCategory implements Category<Ammo> {

    @NonNull
    @SerializedName("ammo")
    private final AmmoList ammoList;


    public AmmoCategory(@NonNull final AmmoList ammoList) {
        this.ammoList = ammoList;
    }

    @Override
    public String toString() {
        return "AmmoCategory{" +
               "ammo=" + this.ammoList.toString() +
               '}';
    }

    @Override
    public List<Ammo> getItems() {
        return this.ammoList;
    }
}
