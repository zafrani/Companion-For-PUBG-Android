package tech.zafrani.companionforpubg.models.items.consumables;


import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.models.items.Item;

public class Consumable extends Item{
    public Consumable(@NonNull final String name,
                      final int id,
                      @NonNull final String imageUrl,
                      final int capacity) {
        super(name, id, imageUrl, capacity);
    }
}
