package tech.zafrani.companionforpubg.models.items.weapons;

import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.models.items.Item;

public class Weapon extends Item {

    public Weapon(@NonNull final String name,
                  final int id,
                  @NonNull final String imageUrl) {
        super(name, id, imageUrl);
    }
}
