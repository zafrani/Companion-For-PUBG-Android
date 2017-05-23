package tech.zafrani.companionforpubg.utils;


import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;

import tech.zafrani.companionforpubg.models.items.Category;
import tech.zafrani.companionforpubg.models.items.ammo.AmmoCategory;
import tech.zafrani.companionforpubg.models.items.weapons.WeaponCategory;


public class CategoryJsonAdapter
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
            //todo
        } else if (Category.Name.EQUIPMENT_CATEGORY.getValue().equals(categoryName)) {
            //todo
        } else if (Category.Name.CONSUMABLE_CATEGORY.getValue().equals(categoryName)) {
            //todo
        } else if (Category.Name.VEHICLE_CATEGORY.getValue().equals(categoryName)) {
            //todo
        }
        return null;
    }
}
