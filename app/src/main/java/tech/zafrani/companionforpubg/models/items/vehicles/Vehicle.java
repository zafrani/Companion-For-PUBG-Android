package tech.zafrani.companionforpubg.models.items.vehicles;

import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.models.items.Item;

public class Vehicle extends Item{

    public Vehicle(@NonNull final String name,
                   final int id,
                   @NonNull final String imageUrl) {
        super(name, id, imageUrl);
    }
}
