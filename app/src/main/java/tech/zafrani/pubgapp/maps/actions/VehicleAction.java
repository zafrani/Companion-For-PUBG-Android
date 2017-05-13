package tech.zafrani.pubgapp.maps.actions;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.maps.GoogleMapController;
import tech.zafrani.pubgapp.models.spawns.Spawns;
import tech.zafrani.pubgapp.utils.FileUtil;

public class VehicleAction extends Action {
    @NonNull
    private final List<LatLng> vehicleSpawns;
    @NonNull
    private final List<Marker> vehicleMarkers = new ArrayList<>();
    @NonNull
    private final GoogleMapController mapController;

    public VehicleAction(@NonNull final GoogleMapController mapController) {
        this.mapController = mapController;
        Spawns spawns = null;
        try {
            spawns = FileUtil.getSpawns(mapController.getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (spawns == null) {
            vehicleSpawns = new ArrayList<>();
        } else {
            this.vehicleSpawns = spawns.getVehicleLatLngs();

        }
    }

    @Override
    protected void onToggleAction() {
        if (shouldShow()) {
            for (final LatLng latLng : this.vehicleSpawns) {
                final MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                this.vehicleMarkers.add(this.mapController.addMarker(markerOptions));
            }
        } else {
            for (final Marker marker : this.vehicleMarkers) {
                marker.remove();
            }
            this.vehicleMarkers.clear();
        }
    }


}
