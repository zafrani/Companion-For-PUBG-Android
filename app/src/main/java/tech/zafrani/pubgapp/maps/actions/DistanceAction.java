package tech.zafrani.pubgapp.maps.actions;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.maps.GoogleMapController;

public class DistanceAction extends Action
        implements
        GoogleMap.OnMapClickListener {

    private final static int SECONDS_PER_METER = 12;
    private final static double DISTANCE_PER_METER = 4.5;

    private static double getDistance(final double x1,
                                      final double x2,
                                      final double y1,
                                      final double y2) {
        final double x = (x2 - x1) * (x2 - x1);
        final double y = (y2 - y1) * (y2 - y1);
        return Math.sqrt((x + y));
    }

    @NonNull
    private final GoogleMapController mapController;

    @NonNull
    private final String snippet;

    private final int colorAccent;

    @Nullable
    private LatLngMarker origin = null;

    @Nullable
    private LatLngMarker destination = null;

    @Nullable
    private Polyline polyline = null;


    public DistanceAction(@NonNull final GoogleMapController mapController) {
        this.mapController = mapController;
        this.snippet = mapController.getContext().getString(R.string.distance_action_label_snippet);
        this.colorAccent = ContextCompat.getColor(mapController.getContext(), R.color.colorAccent);
    }

    //region Actions
    @Override
    protected void onToggleAction() {
        release();
        if (shouldShow()) {
            this.mapController.setOnMapClickListener(this);
        } else {
            this.mapController.setOnMapClickListener(null);
        }
    }

    @DrawableRes
    @Override
    protected int getMarkerIconRes() {
        return R.drawable.ic_directions_run_white_24dp;
    }

    @Override
    public void release() {
        releaseDestination();
        releaseOrigin();
        releasePolyline();
    }
    //endregion

    //region OnMapClickListener
    @Override
    public void onMapClick(final LatLng latLng) {
        if (this.origin == null || this.destination != null) {
            release();
            setOrigin(latLng);
        } else {
            setDestination(latLng);
        }
    }
    //endregion

    //region methods

    /**
     * Set the first selected point.
     *
     * @param origin Position on {@link GoogleMap} user clicked.
     */
    private void setOrigin(@Nullable final LatLng origin) {
        releasePolyline();
        releaseOrigin();
        if (origin != null) {
            this.origin = new LatLngMarker(origin, addMarker(origin));
        }
    }

    /**
     * Set the second selected point.
     *
     * @param destination Position on {@link GoogleMap} user clicked.
     */
    private void setDestination(@Nullable final LatLng destination) {
        releasePolyline();
        releaseDestination();
        if (destination != null) {
            this.destination = new LatLngMarker(destination, addMarker(destination));
            addPolyline();
        }
    }

    /**
     * Helper function.
     *
     * @param latLng position on {@link GoogleMap} to create a marker.
     * @return marker on map.
     */
    @NonNull
    private Marker addMarker(@NonNull final LatLng latLng) {
        final MarkerOptions options = createMarkerOptions();
        options.position(latLng);
        return this.mapController.addMarker(options);
    }

    /**
     * If an origin and destination exist this will draw a line between them and
     * render the time it takes to reach the {@link DistanceAction#destination}
     */
    private void addPolyline() {
        if (this.origin == null || this.destination == null) {
            return;
        }
        releasePolyline();
        this.destination.marker.setTitle(getTitleForDistance(getDistance()));
        this.destination.marker.setSnippet(this.snippet);
        this.destination.marker.showInfoWindow();
        final PolylineOptions polylineOptions = new PolylineOptions();
        polylineOptions.add(this.origin.latLng);
        polylineOptions.add(this.destination.latLng);
        polylineOptions.width(5);
        polylineOptions.color(this.colorAccent);
        polylineOptions.zIndex(1000);
        this.polyline = this.mapController.addPolyline(polylineOptions);
    }

    /**
     * Remove any references that may cause a leak.
     */
    private void releaseDestination() {
        if (this.destination != null) {
            this.destination.release();
            this.destination = null;
        }
    }

    /**
     * Remove any references that may cause a leak.
     */
    private void releasePolyline() {
        if (this.polyline != null) {
            this.polyline.remove();
            this.polyline = null;
        }
    }

    /**
     * Remove any references that may cause a leak.
     */
    private void releaseOrigin() {
        if (this.origin != null) {
            this.origin.release();
            this.origin = null;
        }
    }

    /**
     * @return if {@link DistanceAction#origin} and {@link DistanceAction#destination} exist will
     * return the distance between them. If one or both are missing will return -1.
     */
    private double getDistance() {
        if (this.origin == null || this.destination == null) {
            return -1;
        }
        return DistanceAction.getDistance(this.origin.latLng.latitude,
                                          this.destination.latLng.latitude,
                                          this.origin.latLng.longitude,
                                          this.destination.latLng.longitude);
    }

    /**
     * @param distance distance between {@link DistanceAction#origin} and {@link DistanceAction#destination}.
     * @return String to display in the {@link DistanceAction#destination}'s {@link LatLngMarker#marker}.
     */
    private String getTitleForDistance(final double distance) {
        if (distance == -1) {
            // Shouldn't happen. Just in case.
            return this.mapController.getContext().getString(R.string.distance_action_label_title_failed);
        }
        final double meters = distance / DISTANCE_PER_METER;
        final int seconds = (int) (meters * SECONDS_PER_METER);
        if (seconds > 60) {
            final int minutes = (seconds / 60);
            final int remainder = (seconds % 60);
            //todo use strings.xml
            if (remainder == 0) {
                return "~" + minutes + " minutes";
            } else {
                return "~" + minutes + " minutes and " + remainder + " seconds";
            }
        }
        return "~" + seconds + " seconds";
    }
    //endregion

    /**
     * Helper class to hold final references of a positions {@link LatLng} and {@link Marker}.
     */
    private class LatLngMarker {
        @NonNull
        private LatLng latLng;
        @NonNull
        private Marker marker;

        private LatLngMarker(@NonNull LatLng latLng,
                             @NonNull Marker marker) {
            this.latLng = latLng;
            this.marker = marker;
        }

        /**
         * Remove the marker from the map.
         */
        private void release() {
            marker.remove();
        }
    }
}
