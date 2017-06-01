package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import java.util.EnumMap;

import tech.zafrani.companionforpubg.models.items.ammo.AmmoCategory;
import tech.zafrani.companionforpubg.models.items.attachments.AttachmentCategory;
import tech.zafrani.companionforpubg.models.items.weapons.WeaponCategory;

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
    public WeaponCategory getWeaponCategory() {
        return ((WeaponCategory) (Category<? extends Item>) get(Category.Name.WEAPON_CATEGORY));
    }

    @NonNull
    public AmmoCategory getAmmoCategory() {
        return ((AmmoCategory) (Category<? extends Item>) get(Category.Name.AMMO_CATEGORY));
    }

    @NonNull
    public AttachmentCategory getAttachmentCategory() {
        return ((AttachmentCategory) (Category<? extends Item>) get(Category.Name.ATTACHMENT_CATEGORY));
    }

}
