package tech.zafrani.pubgapp.maps;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;

import java.io.IOException;

import tech.zafrani.pubgapp.utils.FileUtil;

public class PUBGTileProvider implements TileProvider {
    @NonNull
    private final Context context;

    public PUBGTileProvider(@NonNull final Context context) {
        this.context = context;
    }

    @Override
    public Tile getTile(final int x,
                        final int y,
                        final int zoom) {
        try {
            return new Tile(256, 256, FileUtil.getBytesForFile(context, "map/" + zoom + "_" + x + "_" + y + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
