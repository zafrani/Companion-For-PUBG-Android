package tech.zafrani.companionforpubg.models.items.weapons;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class MeleeWeapon extends Weapon {


    @SerializedName("rate")
    private final int rate;

    public MeleeWeapon(@NonNull final String name,
                       final int id,
                       @NonNull final String imageUrl,
                       final int capacity,
                       @NonNull final Type type,
                       final int rate) {
        super(name, id, imageUrl, capacity, type);
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "MeleeWeapon{" +
               "rate=" + rate +
               '}';
    }

    public int getRate() {
        return this.rate;
    }
}
