package tech.zafrani.companionforpubg.models.items;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Weapon {

    @NonNull
    @SerializedName("name")
    private final String name;

    @SerializedName("id")
    private final int id;

    public Weapon(@NonNull final String name,
                  final int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Weapon{" +
               "name='" + name + '\'' +
               ", id=" + id +
               '}';
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    public int getId() {
        return id;
    }
}
