package tech.zafrani.companionforpubg.models.items.weapons;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tech.zafrani.companionforpubg.models.items.Category;


public class WeaponCategory implements Category<Weapon> {

    @NonNull
    @SerializedName("weapons")
    private final WeaponList weaponList;


    public WeaponCategory(@NonNull final WeaponList weaponList) {
        this.weaponList = weaponList;
    }

    @Override
    public String toString() {
        return "WeaponCategory{" +
               "weaponList=" + this.weaponList.toString() +
               '}';
    }

    @Override
    public List<Weapon> getItems() {
        return this.weaponList;
    }


    @NonNull
    public WeaponList getWeaponsUsingAmmo(final int ammoId) {
        final WeaponList weapons = new WeaponList();
        for (final Weapon weapon : weaponList) {
            if (weapon instanceof ProjectileWeapon) {
                if (((ProjectileWeapon) weapon).getAmmoId() == ammoId) {
                    weapons.add(weapon);
                }
            }
        }
        return weapons;
    }

}