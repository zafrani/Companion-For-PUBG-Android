package tech.zafrani.pubgapp.maps.actions;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.maps.GoogleMapController;
import tech.zafrani.pubgapp.models.spawns.Spawns;

public class BoatAction extends Action {
    @NonNull
    private final List<LatLng> boatSpawns;
    @NonNull
    private final List<Marker> boatMarkers = new ArrayList<>();
    @NonNull
    private final GoogleMapController mapController;

    public BoatAction(@NonNull final GoogleMapController mapController) {
        this.mapController = mapController;
        this.boatSpawns = Spawns.getBoatLatLngs(mapController.getContext());
    }

    @Override
    protected void onToggleAction() {
        if (shouldShow()) {
            for (final LatLng latLng : this.boatSpawns) {
                final MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                this.boatMarkers.add(this.mapController.addMarker(markerOptions));
            }
        } else {
            for (final Marker marker : this.boatMarkers) {
                marker.remove();
            }
            this.boatMarkers.clear();
        }
    }


}
