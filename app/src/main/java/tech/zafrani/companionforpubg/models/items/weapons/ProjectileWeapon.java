package tech.zafrani.companionforpubg.models.items.weapons;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class ProjectileWeapon extends Weapon {


    @SerializedName("magazine_size")
    private final int magazineSize;

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

    @NonNull
    @SerializedName("damage")
    private final Damage damage;

    @Nullable
    @SerializedName("magazine_ids")
    private final int[] magazinesIds;

    @Nullable
    @SerializedName("muzzle_ids")
    private final int[] muzzleIds;

    @Nullable
    @SerializedName("grip_ids")
    private final int[] gripIds;

    @Nullable
    @SerializedName("sight_ids")
    private final int[] sightIds;

    @Nullable
    @SerializedName("stock_ids")
    private final int[] stockIds;

    public ProjectileWeapon(@NonNull final String name,
                            final int id,
                            @NonNull final String imageUrl,
                            final int capacity,
                            @NonNull final Type type,
                            final int magazineSize,
                            final int ammoId,
                            final int range,
                            final int stability,
                            final int rate,
                            final int reload,
                            @NonNull final Damage damage,
                            @Nullable final int[] magazinesIds,
                            @Nullable final int[] muzzleIds,
                            @Nullable final int[] gripIds,
                            @Nullable final int[] sightIds,
                            @Nullable final int[] stockIds) {
        super(name, id, imageUrl, capacity, type);
        this.magazineSize = magazineSize;
        this.ammoId = ammoId;
        this.range = range;
        this.stability = stability;
        this.rate = rate;
        this.reload = reload;
        this.damage = damage;
        this.magazinesIds = magazinesIds;
        this.muzzleIds = muzzleIds;
        this.gripIds = gripIds;
        this.sightIds = sightIds;
        this.stockIds = stockIds;
    }

    @Override
    public String toString() {
        return "ProjectileWeapon{" +
               "magazineSize=" + magazineSize +
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

    public int getMagazineSize() {
        return magazineSize;
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

    @Nullable
    public int[] getMagazinesIds() {
        return magazinesIds;
    }

    @Nullable
    public int[] getMuzzleIds() {
        return muzzleIds;
    }

    @Nullable
    public int[] getGripIds() {
        return gripIds;
    }

    @Nullable
    public int[] getSightIds() {
        return sightIds;
    }

    @Nullable
    public int[] getStockIds() {
        return stockIds;
    }

    @NonNull
    public Damage getDamage() {
        return damage;
    }
}
