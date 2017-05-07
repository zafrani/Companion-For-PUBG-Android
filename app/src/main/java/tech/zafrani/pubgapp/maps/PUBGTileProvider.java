package tech.zafrani.pubgapp.maps;

import com.google.android.gms.maps.model.UrlTileProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class PUBGTileProvider extends UrlTileProvider {
    private final String format = "https://raw.githubusercontent.com/Zsteven44/PUBG-Companion/master/app/src/main/assets/map/%d_%d_%d.png";

    public PUBGTileProvider() {
        super(256, 256);
    }

    @Override
    public URL getTileUrl(final int x,
                          final int y,
                          final int zoom) {
        try {
            return new URL(String.format(Locale.getDefault(), format, zoom, x, y));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

  /*  @Override
    public Tile getTile(final int x,
                        final int y,
                        final int zoom) {
        try {
            return new Tile(256, 256, FileUtil.getBytesForFile(context, "map/" + zoom + "_" + x + "_" + y + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}

