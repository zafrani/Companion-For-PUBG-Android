package tech.zafrani.companionforpubg.models.items.ammo;

import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.models.items.Item;

public class Ammo extends Item {

    public Ammo(@NonNull final String name,
                final int id,
                @NonNull final String imageUrl) {
        super(name, id, imageUrl);
    }
}
