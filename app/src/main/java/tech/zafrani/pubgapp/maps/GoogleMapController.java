package tech.zafrani.pubgapp.maps;

import android.support.annotation.Nullable;
import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

import java.util.ArrayList;
import java.util.List;

public class GoogleMapController {
    private GoogleMap googleMap = null;
    private boolean showVehicles = false;
    private final List<Marker> vehicleMarkers = new ArrayList<>();

    public void setGoogleMap(@Nullable final GoogleMap googleMap) {
        this.googleMap = googleMap;
        setUpMap();
    }

    private void setUpMap() {
        if (this.googleMap == null) {
            return;
        }
        final TileOverlayOptions overlayOptions = new TileOverlayOptions();
        overlayOptions.tileProvider(new PUBGTileProvider());
        this.googleMap.setMaxZoomPreference(5);
        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        this.googleMap.addTileOverlay(overlayOptions);
        this.googleMap.getUiSettings().setZoomControlsEnabled(true);
        this.googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(final LatLng latLng) {
                Log.e(getClass().getSimpleName(), "LatLng: " + latLng.latitude + ", " + latLng.longitude);
            }
        });
    }

    public void toggleVehicles() {
        this.showVehicles = !this.showVehicles;
        final List<LatLng> vehicleSpawns = VehicleMarkers.getVehicleSpawns();
        if (this.showVehicles) {
            for (final LatLng latLng : vehicleSpawns) {
                final MarkerOptions markerOptions = new MarkerOptions();
                markerOptions.position(latLng);
                this.vehicleMarkers.add(this.googleMap.addMarker(markerOptions));
            }
        } else {
            for (final Marker marker : this.vehicleMarkers) {
                marker.remove();
            }
            this.vehicleMarkers.clear();

        }
    }
}