package tech.zafrani.pubgapp.models;

import android.support.annotation.NonNull;

public class Weapon extends BaseItem {

    private final int damage;
    private final int range;
    private final int stability;
    private final int rate;

    private final int capacity;
    private final int magazine;
    private final String ammo;

    public Weapon(@NonNull String category,
                  @NonNull String type,
                  @NonNull String name,
                  int damage,
                  int range,
                  int stability,
                  int rate,
                  int capacity,
                  int magazine,
                  String ammo) {
        super(category, type, name);
        this.damage = damage;
        this.range = range;
        this.stability = stability;
        this.rate = rate;
        this.capacity = capacity;
        this.magazine = magazine;
        this.ammo = ammo;
    }
}
