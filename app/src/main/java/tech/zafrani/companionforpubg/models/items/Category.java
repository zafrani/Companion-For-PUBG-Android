package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import java.util.List;

import tech.zafrani.companionforpubg.utils.Enums;

public interface Category<T extends Item> {
    List<T> getItems();

    enum Name implements Enums.FromString {
        WEAPON_CATEGORY("weapons"),
        AMMO_CATEGORY("ammo"),
        ATTACHMENT_CATEGORY("attachment"),
        EQUIPMENT_CATEGORY("equipment"),
        CONSUMABLE_CATEGORY("consumables"),
        VEHICLE_CATEGORY("vehicles");

        @NonNull
        public static Category.Name fromString(final @NonNull String string) {
            return Enums.fromString(string, values());
        }


        @NonNull
        private final String value;

        Name(@NonNull final String value) {
            this.value = value;
        }

        @NonNull
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Name{" +
                   "value='" + value + '\'' +
                   '}';
        }
    }


}
