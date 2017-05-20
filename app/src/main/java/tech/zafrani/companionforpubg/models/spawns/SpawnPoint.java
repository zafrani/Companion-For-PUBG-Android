package tech.zafrani.companionforpubg.models.spawns;


import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

public class SpawnPoint {
    @NonNull
    @SerializedName("name")
    private final String name;

    @SerializedName("latitude")
    private final double latitude;

    @SerializedName("longitude")
    private final double longitude;

    public SpawnPoint(@NonNull String name,
                      double latitude,
                      double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @NonNull
    public LatLng getLatLng() {
        return new LatLng(latitude, longitude);
    }

    @Override
    public String toString() {
        return "SpawnPoint{" +
               "name='" + name + '\'' +
               ", latitude=" + latitude +
               ", longitude=" + longitude +
               '}';
    }
}
