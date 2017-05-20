package tech.zafrani.companionforpubg.maps;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;

import tech.zafrani.companionforpubg.maps.actions.BoatAction;
import tech.zafrani.companionforpubg.maps.actions.DistanceAction;
import tech.zafrani.companionforpubg.maps.actions.VehicleAction;

public class GoogleMapControllerImpl
        implements GoogleMapController {
    @NonNull
    private final GoogleMap googleMap;

    @NonNull
    private final VehicleAction vehicleAction;

    @NonNull
    private final BoatAction boatAction;

    @NonNull
    private final DistanceAction distanceAction;

    @NonNull
    private final Context context;


    public GoogleMapControllerImpl(@NonNull final Context context,
                                   @NonNull final GoogleMap googleMap) {

        this.context = context;
        this.googleMap = googleMap;
        this.vehicleAction = new VehicleAction(this);
        this.boatAction = new BoatAction(this);
        this.distanceAction = new DistanceAction(this);
        setUpMap();
    }

    //region GoogleMapController
    @NonNull
    @Override
    public Marker addMarker(@NonNull final MarkerOptions markerOptions) {
        return this.googleMap.addMarker(markerOptions);
    }

    @Override
    public void setOnMapClickListener(@Nullable final GoogleMap.OnMapClickListener clickListener) {
        this.googleMap.setOnMapClickListener(clickListener);
    }

    @NonNull
    @Override
    public Polyline addPolyline(@NonNull final PolylineOptions polylineOptions) {
        return this.googleMap.addPolyline(polylineOptions);
    }

    @NonNull
    @Override
    public Context getContext() {
        return this.context;
    }
    //endregion

    //region methods

    /**
     * Will overlay the current {@link GoogleMap} with tiles for PUBG.
     */
    private void setUpMap() {
        final TileOverlayOptions overlayOptions = new TileOverlayOptions();
        overlayOptions.tileProvider(new PUBGTileProvider());
        this.googleMap.setMaxZoomPreference(5);
        this.googleMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        this.googleMap.addTileOverlay(overlayOptions);
        this.googleMap.getUiSettings().setMapToolbarEnabled(false);
    }

    /**
     * Call to remove click listeners and references that may cause leaks.
     */
    public void release() {
        this.vehicleAction.release();
        this.distanceAction.release();
        this.boatAction.release();
    }

    /**
     * Will trigger {@link VehicleAction}.
     */
    public void toggleVehicles() {
        this.vehicleAction.toggle();
    }

    /**
     * Will trigger {@link BoatAction}.
     */
    public void toggleBoats() {
        this.boatAction.toggle();
    }


    /**
     * Will trigger {@link DistanceAction}.
     */
    public void toggleRunDistance() {
        this.distanceAction.toggle();
    }

    /**
     * @return true if currently using {@link VehicleAction}.
     */
    public boolean isShowingVehicles() {
        return this.vehicleAction.shouldShow();
    }

    /**
     * @return true if currently using {@link BoatAction}.
     */
    public boolean isShowingBoats() {
        return this.boatAction.shouldShow();
    }


    /**
     * @return true if currently using {@link DistanceAction}.
     */
    public boolean isShowingDistance() {
        return this.distanceAction.shouldShow();
    }
    //endregion

}