package tech.zafrani.pubgapp.maps;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class PUBGTileProvider extends UrlTileProvider {

    @NonNull
    private static final String TILE_URL_FORMAT = "https://raw.githubusercontent.com/Zsteven44/PUBG-Tiles/master/map/%d_%d_%d.png";

    public PUBGTileProvider() {
        super(256, 256);
    }

    @Override
    public URL getTileUrl(final int x,
                          final int y,
                          final int zoom) {
        try {
            return new URL(String.format(Locale.getDefault(), TILE_URL_FORMAT, zoom, x, y));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

