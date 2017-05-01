package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

public class Item {

    @NonNull
    private final String category;
    @NonNull
    private final String type;
    @NonNull
    private final String name;

    private final int damage;
    private final int range;
    private final int stability;
    private final int rate;

    private final int capacity;
    private final int magazine;
    private final String ammo;

    public Item(@NonNull String category,
                @NonNull String type,
                @NonNull String name,
                int damage,
                int range,
                int stability,
                int rate,
                int capacity,
                int magazine,
                String ammo) {
        this.category = category;
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.range = range;
        this.stability = stability;
        this.rate = rate;
        this.capacity = capacity;
        this.magazine = magazine;
        this.ammo = ammo;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getStability() {
        return stability;
    }

    public int getRate() {
        return rate;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getMagazine() {
        return magazine;
    }

    public String getAmmo() {
        return ammo;
    }
}
