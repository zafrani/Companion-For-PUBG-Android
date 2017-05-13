package tech.zafrani.pubgapp.models.spawns;


import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spawns {
    @SerializedName("vehicles")
    private final List<SpawnPoint> vehicles;

    public Spawns(@NonNull final List<SpawnPoint> vehicles) {
        this.vehicles = vehicles;
    }

    @NonNull
    public List<LatLng> getVehicleLatLngs() {
        final List<LatLng> latLngs = new ArrayList<>();
        for (SpawnPoint spawnPoint : this.vehicles) {
            latLngs.add(spawnPoint.getLatLng());
        }
        return latLngs;
    }

    @Override
    public String toString() {
        return "Spawns{" +
               "vehicles=" + Arrays.toString(vehicles.toArray()) +
               '}';
    }
}
