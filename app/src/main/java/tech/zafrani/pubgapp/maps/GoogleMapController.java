package tech.zafrani.pubgapp.maps;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

/**
 * Helper for managing all of the interactions with a {@link GoogleMap}.
 */
public interface GoogleMapController {

    /**
     * Will forward to {@link GoogleMap#addMarker(MarkerOptions)}
     *
     * @param markerOptions should contain information for marking.
     * @return the marker created.
     */
    @NonNull
    Marker addMarker(@NonNull MarkerOptions markerOptions);

    /**
     * Will forward to {@link GoogleMap#addPolyline(PolylineOptions)}
     *
     * @param polylineOptions should contain information for drawing.
     * @return the polyline created.
     */
    @NonNull
    Polyline addPolyline(@NonNull PolylineOptions polylineOptions);

    /**
     * Set a listener for the {@link GoogleMap}
     *
     * @param clickListener null to remove.
     */
    void setOnMapClickListener(@Nullable GoogleMap.OnMapClickListener clickListener);

    /**
     * @return Android context.
     */
    @NonNull
    Context getContext();
}
