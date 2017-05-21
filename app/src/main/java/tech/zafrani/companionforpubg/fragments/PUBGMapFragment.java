package tech.zafrani.companionforpubg.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import butterknife.BindView;
import butterknife.OnClick;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.maps.GoogleMapControllerImpl;


public class PUBGMapFragment extends BaseFragment
        implements OnMapReadyCallback {

    public static final String TAG = PUBGMapFragment.class.getSimpleName();

    private static final String PREF_TIMES_SHOWN = "PREF_TIMES_SHOWN";

    @Nullable
    private GoogleMapControllerImpl mapController = null;

    @BindView(R.id.fragment_map_vehicle_icon)
    ImageView vehicleIcon;

    @BindView(R.id.fragment_map_boat_icon)
    ImageView boatIcon;

    @BindView(R.id.fragment_map_distance_icon)
    ImageView runDistanceIcon;

    @Nullable
    private SharedPreferences sharedPreferences = null;

    //region BaseFragment
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_map;
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.sharedPreferences = getActivity().getSharedPreferences("temp", Context.MODE_PRIVATE); //todo not this.

        final MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.mapController != null) {
            this.mapController.release();
            this.mapController = null;
        }
        this.sharedPreferences = null;
    }
    //endregion

    //region OnMapReadyCallback
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        if (googleMap != null) {
            this.mapController = new GoogleMapControllerImpl(getActivity(), googleMap);
        }

    }
    //endregion

    //region methods

    private void showToastIfNeeded() {
        if (this.sharedPreferences == null) {
            return;
        }
        final int timesShown = this.sharedPreferences.getInt(PREF_TIMES_SHOWN, 0);
        if (timesShown <= 5) {
            Toast.makeText(getActivity(), R.string.toast_how_to_use_distance, Toast.LENGTH_LONG).show();
            this.sharedPreferences.edit().putInt(PREF_TIMES_SHOWN, timesShown + 1).apply();
        }
    }

    @OnClick(R.id.fragment_map_vehicle_icon)
    void onVehicleClicked(){
        toggleVehicles();
    }

    @OnClick(R.id.fragment_map_boat_icon)
    void onBoatClicked() {
        toggleBoats();
    }

    @OnClick(R.id.fragment_map_distance_icon)
    void onRunClicked() {
        toggleRunDistance();
    }

    private void toggleVehicles() {
        if (this.mapController == null) {
            return;
        }
        this.mapController.toggleVehicles();
        updateUi();
    }

    private void toggleBoats() {
        if (this.mapController == null) {
            return;
        }
        this.mapController.toggleBoats();
        updateUi();
    }

    private void toggleRunDistance() {
        if (this.mapController == null) {
            return;
        }
        this.mapController.toggleRunDistance();
        if (this.mapController.isShowingDistance()) {
            showToastIfNeeded(); //todo make a tutorial and remove
        }
        updateUi();
    }

    private void updateUi() {
        if (this.mapController == null) {
            return;
        }
        if (this.mapController.isShowingVehicles()) {
            vehicleIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        } else {
            vehicleIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
        }
        if (this.mapController.isShowingBoats()) {
            boatIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        } else {
            boatIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
        }
        if (this.mapController.isShowingDistance()) {
            runDistanceIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        } else {
            runDistanceIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
        }

    }

    //endregion
}
