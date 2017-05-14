package tech.zafrani.pubgapp.models.spawns;


import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tech.zafrani.pubgapp.utils.FileUtil;

public class Spawns {
    @NonNull
    @SerializedName("vehicles")
    private final List<SpawnPoint> vehicles;
    @NonNull
    @SerializedName("boats")
    private final List<SpawnPoint> boats;

    @NonNull
    public static List<LatLng> getVehicleLatLngs(@NonNull final Context context) {
        final List<LatLng> latLngs = new ArrayList<>();
        Spawns spawns = null;
        try {
            spawns = FileUtil.getSpawns(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (spawns == null) {
            return latLngs;
        }
        for (SpawnPoint spawnPoint : spawns.vehicles) {
            latLngs.add(spawnPoint.getLatLng());
        }
        return latLngs;
    }

    @NonNull
    public static List<LatLng> getBoatLatLngs(@NonNull final Context context) {
        final List<LatLng> latLngs = new ArrayList<>();
        Spawns spawns = null;
        try {
            spawns = FileUtil.getSpawns(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (spawns == null) {
            return latLngs;
        }
        for (SpawnPoint spawnPoint : spawns.boats) {
            latLngs.add(spawnPoint.getLatLng());
        }
        return latLngs;
    }

    public Spawns(@NonNull final List<SpawnPoint> vehicles,
                  @NonNull final List<SpawnPoint> boats) {
        this.vehicles = vehicles;
        this.boats = boats;
    }

    @Override
    public String toString() {
        return "Spawns{" +
               "vehicles=" + Arrays.toString(vehicles.toArray()) +
               "boats=" + Arrays.toString(boats.toArray()) +
               '}';
    }
}
