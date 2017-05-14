package tech.zafrani.pubgapp.maps;

import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import tech.zafrani.pubgapp.utils.Constants;

public class PUBGTileProvider extends UrlTileProvider {

    public PUBGTileProvider() {
        super(256, 256);
    }

    @Override
    public URL getTileUrl(final int x,
                          final int y,
                          final int zoom) {
        try {
            return new URL(String.format(Locale.getDefault(), Constants.MAP_TILE_URL, zoom, x, y));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

