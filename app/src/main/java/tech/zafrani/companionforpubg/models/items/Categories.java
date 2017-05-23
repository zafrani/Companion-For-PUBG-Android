package tech.zafrani.companionforpubg.models.items;

import java.util.HashMap;

public class Categories extends HashMap<String, Category> {

    @Override
    public String toString() {
        String returnString = "Categories{";
        for (final Entry<String, Category> entry : entrySet()) {
            if (entry == null || entry.getValue() == null) {
                continue;
            }
            returnString += "\n" + entry.getKey() + ", " + entry.getValue().toString();
        }
        returnString += " \n}";
        return returnString;
    }
}
