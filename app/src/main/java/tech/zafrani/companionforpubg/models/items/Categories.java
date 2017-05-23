package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import java.util.EnumMap;

public class Categories extends EnumMap<Category.Name, Category<Item>> {

    public Categories() {
        super(Category.Name.class);
    }

    @Override
    public String toString() {
        String returnString = "Categories{";
        for (final Entry<Category.Name, Category<Item> > entry : entrySet()) {
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
}
