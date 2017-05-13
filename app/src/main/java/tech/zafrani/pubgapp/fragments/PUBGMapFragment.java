package tech.zafrani.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.maps.GoogleMapControllerImpl;


public class PUBGMapFragment extends BaseFragment
        implements OnMapReadyCallback {

    public static final String TAG = PUBGMapFragment.class.getSimpleName();
    @Nullable
    private GoogleMapControllerImpl mapController = null;
    private ImageView vehicleIcon;
    private ImageView runDistanceIcon;

    //region BaseFragment
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.vehicleIcon = (ImageView) view.findViewById(R.id.fragment_map_vehicle_icon);
        this.runDistanceIcon = (ImageView) view.findViewById(R.id.fragment_map_distance_icon);

        final MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment_map);
        mapFragment.getMapAsync(this);

        this.vehicleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVehicles();
            }
        });
        this.runDistanceIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleRunDistance();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.vehicleIcon != null) {
            this.vehicleIcon.setOnClickListener(null);
        }
        if (this.runDistanceIcon != null) {
            this.runDistanceIcon.setOnClickListener(null);
        }
        if (this.mapController != null) {
            this.mapController.release();
            this.mapController = null;
        }
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
    private void toggleVehicles() {
        if (this.mapController == null) {
            return;
        }
        this.mapController.toggleVehicles();
        updateUi();
    }

    private void toggleRunDistance() {
        if (this.mapController == null) {
            return;
        }
        this.mapController.toggleRunDistance();
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
        if (this.mapController.isShowingDistance()) {
            runDistanceIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.colorAccent));
        } else {
            runDistanceIcon.setColorFilter(ContextCompat.getColor(getActivity(), R.color.white));
        }

    }

    //endregion
}
