package tech.zafrani.companionforpubg.models.items.consumables;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsumableList extends ArrayList<Consumable> {
    @Override
    public String toString() {
        return "ConsumableList{" +
                Arrays.toString(toArray()) +
                "}";
    }
}
