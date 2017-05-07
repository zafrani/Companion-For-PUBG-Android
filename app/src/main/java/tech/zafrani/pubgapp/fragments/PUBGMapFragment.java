package tech.zafrani.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.TileOverlayOptions;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.maps.PUBGTileProvider;


public class PUBGMapFragment extends BaseFragment
        implements OnMapReadyCallback {

    public static String TAG = PUBGMapFragment.class.getSimpleName();
    private GoogleMap mMap;

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

        final MapFragment mapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.map_fragment_map);
        mapFragment.getMapAsync(this);
    }
    //endregion

    //region OnMapReadyCallback
    @Override
    public void onMapReady(final GoogleMap googleMap) {
        final TileOverlayOptions overlayOptions = new TileOverlayOptions();
        overlayOptions.tileProvider(new PUBGTileProvider(getActivity()));
        mMap = googleMap;
        mMap.setMaxZoomPreference(5);
        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);
        mMap.addTileOverlay(overlayOptions);
        mMap.getUiSettings().setZoomControlsEnabled(true);
    }
    //endregion
}
