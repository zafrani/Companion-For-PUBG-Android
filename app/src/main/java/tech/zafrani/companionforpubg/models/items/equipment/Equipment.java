package tech.zafrani.companionforpubg.models.items.equipment;

import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.models.items.Item;

public class Equipment extends Item {

    public Equipment(@NonNull final String name,
                     final int id,
                     @NonNull final String imageUrl,
                     final int capacity) {
        super(name, id, imageUrl, capacity);
    }
}
