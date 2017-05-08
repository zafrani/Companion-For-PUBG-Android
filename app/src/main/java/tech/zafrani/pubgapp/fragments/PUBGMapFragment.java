package tech.zafrani.pubgapp.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.maps.GoogleMapController;


public class PUBGMapFragment extends BaseFragment
        implements OnMapReadyCallback {

    public static final String TAG = PUBGMapFragment.class.getSimpleName();
    private final GoogleMapController mapController = new GoogleMapController();
    private ImageView vehicleIcon;

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
        this.vehicleIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleVehicles();
            }
        });
        final MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment_map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (this.vehicleIcon != null) {
            this.vehicleIcon.setOnClickListener(null);
        }
        this.mapController.setGoogleMap(null);
    }
    //endregion

    //region OnMapReadyCallback
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        this.mapController.setGoogleMap(googleMap);

    }
    //endregion

    //region methods
    private void toggleVehicles() {
        this.mapController.toggleVehicles();
        updateUi();
    }

    private void updateUi() {
        if (this.mapController.isShowingVehicles()) {
            vehicleIcon.setColorFilter(Color.argb(255, 246, 191, 34)); // White Tint
        } else {
            vehicleIcon.setColorFilter(Color.argb(255, 255, 255, 255)); // White Tint
        }

    }

    //endregion
}
