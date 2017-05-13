package tech.zafrani.pubgapp.maps.actions;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.maps.GoogleMapController;
import tech.zafrani.pubgapp.maps.markers.VehicleMarkers;

public class VehicleAction extends Action {
    private final List<LatLng> vehicleSpawns = VehicleMarkers.getVehicleSpawns();
    private final List<Marker> vehicleMarkers = new ArrayList<>();
    @NonNull
    private final GoogleMapController mapController;

    public VehicleAction(@NonNull final GoogleMapController mapController) {
        this.mapController = mapController;
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
