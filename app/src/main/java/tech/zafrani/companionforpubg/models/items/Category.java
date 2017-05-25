package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tech.zafrani.companionforpubg.models.items.ammo.AmmoCategory;
import tech.zafrani.companionforpubg.models.items.attachments.AttachmentCategory;
import tech.zafrani.companionforpubg.models.items.consumables.ConsumableCategory;
import tech.zafrani.companionforpubg.models.items.equipment.EquipmentCategory;
import tech.zafrani.companionforpubg.models.items.vehicles.VehicleCategory;
import tech.zafrani.companionforpubg.models.items.weapons.WeaponCategory;
import tech.zafrani.companionforpubg.utils.Enums;

public interface Category<T extends Item> {
    List<T> getItems();

    enum Name implements Enums.FromString, Serializable {
        WEAPON_CATEGORY("weapons"),
        AMMO_CATEGORY("ammo"),
        ATTACHMENT_CATEGORY("attachments"),
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

    class JsonAdapter
            implements JsonDeserializer<Category> {

        @Override
        public Category deserialize(final JsonElement json,
                                    final Type typeOfT,
                                    final JsonDeserializationContext context) throws JsonParseException {
            if (json == null) {
                return null;
            }
            final JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject == null) {
                return null;
            }
            final Iterator<Map.Entry<String, JsonElement>> entryIterator = jsonObject.entrySet().iterator();
            if (!entryIterator.hasNext()) {
                return null;
            }
            final String categoryName = entryIterator.next().getKey();
            if (Category.Name.WEAPON_CATEGORY.getValue().equals(categoryName)) {
                return context.deserialize(jsonObject, WeaponCategory.class);
            } else if (Category.Name.AMMO_CATEGORY.getValue().equals(categoryName)) {
                return context.deserialize(jsonObject, AmmoCategory.class);
            } else if (Category.Name.ATTACHMENT_CATEGORY.getValue().equals(categoryName)) {
                return context.deserialize(jsonObject, AttachmentCategory.class);
            } else if (Category.Name.EQUIPMENT_CATEGORY.getValue().equals(categoryName)) {
                return context.deserialize(jsonObject, EquipmentCategory.class);
            } else if (Category.Name.CONSUMABLE_CATEGORY.getValue().equals(categoryName)) {
                return context.deserialize(jsonObject, ConsumableCategory.class);
            } else if (Category.Name.VEHICLE_CATEGORY.getValue().equals(categoryName)) {
                return context.deserialize(jsonObject, VehicleCategory.class);
            }
            return null;
        }
    }

}
