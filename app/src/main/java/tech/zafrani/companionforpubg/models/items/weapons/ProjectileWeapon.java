package tech.zafrani.companionforpubg.models.items.weapons;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class ProjectileWeapon extends Weapon {


    @SerializedName("magazine")
    private final int magazine;

    @SerializedName("ammo_id")
    private final int ammoId;

    @SerializedName("range")
    private final int range;

    @SerializedName("stability")
    private final int stability;

    @SerializedName("rate")
    private final int rate;

    @SerializedName("reload")
    private final int reload;

    public ProjectileWeapon(@NonNull final String name,
                            final int id,
                            @NonNull final String imageUrl,
                            final int capacity,
                            @NonNull final Type type,
                            final int magazine,
                            final int ammoId,
                            final int range,
                            final int stability,
                            final int rate,
                            final int reload) {
        super(name, id, imageUrl, capacity, type);
        this.magazine = magazine;
        this.ammoId = ammoId;
        this.range = range;
        this.stability = stability;
        this.rate = rate;
        this.reload = reload;
    }

    @Override
    public String toString() {
        return "ProjectileWeapon{" +
               "magazine=" + magazine +
               ", ammoId=" + ammoId +
               ", range=" + range +
               ", stability=" + stability +
               ", rate=" + rate +
               ", reload=" + reload +
               '}';
    }

    public int getRate() {
        return this.rate;
    }

    public int getMagazine() {
        return magazine;
    }

    public int getAmmoId() {
        return ammoId;
    }

    public int getRange() {
        return range;
    }

    public int getStability() {
        return stability;
    }

    public int getReload() {
        return reload;
    }

}
