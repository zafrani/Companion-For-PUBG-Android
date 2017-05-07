package tech.zafrani.pubgapp.maps;

import android.util.Log;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;

public class PUBGTileProvider implements TileProvider {
    @Override
    public Tile getTile(final int x,
                        final int y,
                        final int zoom) {
        Log.e(getClass().getSimpleName(), "[x,y,zoom]: " + x + "," + y + ", " + zoom);
        return null;
    }
}
