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
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.activities.BaseActivity;
import tech.zafrani.companionforpubg.maps.GoogleMapControllerImpl;


public class PUBGMapFragment extends BaseFragment
        implements OnMapReadyCallback {

    public static final String TAG = PUBGMapFragment.class.getSimpleName();

    private static final String PREF_TIMES_SHOWN = "PREF_TIMES_SHOWN";

    @Nullable
    private GoogleMapControllerImpl mapController = null;

    @Nullable
    @BindView(R.id.fragment_map_vehicle_icon)
    ImageView vehicleIcon;

    @Nullable
    @BindView(R.id.fragment_map_boat_icon)
    ImageView boatIcon;

    @Nullable
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

        final MapFragment mapFragment = (MapFragment) getActivity().getFragmentManager().findFragmentById(R.id.map_fragment_map);
        if (mapFragment == null) {
            final MapFragment newMapFragment = new MapFragment();
            ((BaseActivity) getActivity()).showFragment(newMapFragment, R.id.map_fragment_map, MapFragment.class.getSimpleName());
            newMapFragment.getMapAsync(this);
        } else {
            mapFragment.getMapAsync(this);
        }

        if (this.vehicleIcon != null) {
            this.vehicleIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleVehicles();
                }
            });
        }
        if (this.boatIcon != null) {
            this.boatIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleBoats();
                }
            });
        }
        if (this.runDistanceIcon != null) {
            this.runDistanceIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    toggleRunDistance();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        if (this.vehicleIcon != null) {
            this.vehicleIcon.setOnClickListener(null);
        }
        if (this.runDistanceIcon != null) {
            this.runDistanceIcon.setOnClickListener(null);
        }

        if (this.boatIcon != null) {
            this.boatIcon.setOnClickListener(null);
        }

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
        if (this.vehicleIcon != null) {
            if (this.mapController.isShowingVehicles()) {
                this.vehicleIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.accent));
            } else {
                this.vehicleIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
            }
        }

        if (this.boatIcon != null) {
            if (this.mapController.isShowingBoats()) {
                this.boatIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.accent));
            } else {
                this.boatIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
            }
        }

        if (this.runDistanceIcon != null) {
            if (this.mapController.isShowingDistance()) {
                this.runDistanceIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.accent));
            } else {
                this.runDistanceIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
            }
        }
    }

    //endregion
}
