package tech.zafrani.companionforpubg.maps.actions;


import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.MarkerOptions;

public abstract class Action {

    private boolean shouldShow = false;

    public void toggle() {
        this.shouldShow = !shouldShow;
        onToggleAction();
    }

    public boolean shouldShow() {
        return this.shouldShow;
    }

    @NonNull
    protected MarkerOptions createMarkerOptions() {
        final MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromResource(getMarkerIconRes()));
        return markerOptions;
    }

    /**
     * Remove any references that may cause leaks.
     */
    public void release() {

    }

    protected abstract void onToggleAction();

    @DrawableRes
    protected abstract int getMarkerIconRes();

}