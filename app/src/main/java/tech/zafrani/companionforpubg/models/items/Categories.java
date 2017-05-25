package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.EnumMap;

import tech.zafrani.companionforpubg.models.items.ammo.Ammo;
import tech.zafrani.companionforpubg.models.items.ammo.AmmoCategory;

public class Categories extends EnumMap<Category.Name, Category<Item>> {

    public Categories() {
        super(Category.Name.class);
    }

    @Override
    public String toString() {
        String returnString = "Categories{";
        for (final Entry<Category.Name, Category<Item>> entry : entrySet()) {
            if (entry == null || entry.getValue() == null) {
                continue;
            }
            returnString += "\n" + entry.getKey() + ", " + entry.getValue().toString();
        }
        returnString += " \n}";
        return returnString;
    }

    public Category<Item> get(@NonNull final Category.Name key) {
        return super.get(key);
    }

    @NonNull
    public AmmoCategory getAmmoCategory() {
        return ((AmmoCategory) (Category<? extends Item>) get(Category.Name.AMMO_CATEGORY));
    }

}
