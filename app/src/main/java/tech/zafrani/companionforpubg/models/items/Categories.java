package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class Categories extends HashMap<String, Category> {

    // @SerializedName("weapon_category")
    //private final WeaponCategory weaponCategory;

    public Categories() {

    }


    @Override
    public String toString() {
        String cat = "Categories{";
        for (final Entry<String, Category> entry : entrySet()) {
            if (entry == null || entry.getValue() == null) {
                continue;
            }
            cat += entry.getKey() + ", " + entry.getValue().toString();
        }
        cat += '}';
        return cat;
    }
}
