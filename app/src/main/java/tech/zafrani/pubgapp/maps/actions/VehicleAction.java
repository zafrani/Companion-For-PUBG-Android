package tech.zafrani.pubgapp.maps.actions;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.maps.GoogleMapController;
import tech.zafrani.pubgapp.models.spawns.Spawns;

public class VehicleAction extends Action {
    @NonNull
    private final List<LatLng> vehicleSpawns;
    @NonNull
    private final List<Marker> vehicleMarkers = new ArrayList<>();
    @NonNull
    private final GoogleMapController mapController;

    public VehicleAction(@NonNull final GoogleMapController mapController) {
        this.mapController = mapController;
        this.vehicleSpawns = Spawns.getVehicleLatLngs(mapController.getContext());
    }

    @Override
    protected void onToggleAction() {
        if (shouldShow()) {
            for (final LatLng latLng : this.vehicleSpawns) {
                final MarkerOptions markerOptions = createMarkerOptions();
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

    @DrawableRes
    @Override
    protected int getMarkerIconRes() {
        return R.drawable.ic_drive_eta_white_24dp;
    }
}
