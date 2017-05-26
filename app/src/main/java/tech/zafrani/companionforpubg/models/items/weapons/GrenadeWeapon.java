package tech.zafrani.companionforpubg.models.items.weapons;


import android.support.annotation.NonNull;


public class GrenadeWeapon extends Weapon {


    public GrenadeWeapon(@NonNull final String name,
                         final int id,
                         @NonNull final String imageUrl,
                         final int capacity,
                         @NonNull final Type type) {
        super(name, id, imageUrl, capacity, type);


    }

    @Override
    public String toString() {
        return super.toString() +
               "GrenadeWeapon{" +
               '}';
    }


}
