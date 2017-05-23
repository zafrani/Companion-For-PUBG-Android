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
import tech.zafrani.companionforpubg.models.items.WeaponCategory;


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
        if (Category.WEAPON.equals(categoryName)) {
            return context.deserialize(jsonObject, WeaponCategory.class);
        } else if (Category.AMMO.equals(categoryName)) {
            //todo
        } else if (Category.ATTACHMENT.equals(categoryName)) {
            //todo
        } else if (Category.EQUIPMENT.equals(categoryName)) {
            //todo
        } else if (Category.CONSUMABLE.equals(categoryName)) {
            //todo
        } else if (Category.VEHICLES.equals(categoryName)) {
            //todo
        }
        return null;
    }
}
