package tech.zafrani.pubgapp.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tech.zafrani.pubgapp.PUBGApplication;
import tech.zafrani.pubgapp.models.items.Items;
import tech.zafrani.pubgapp.models.spawns.Spawns;

public class FileUtil {

    @Nullable
    public static Items getItems(@NonNull final Context context) throws IOException {
        final InputStream inputStream = context.getAssets().open("items.json");

        if (inputStream != null) {
            final Gson gson = PUBGApplication.getInstance().getGson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return gson.fromJson(reader, Items.class);

        }
        return null;
    }

    @Nullable
    public static Spawns getSpawns(@NonNull final Context context) throws IOException {
        final InputStream inputStream = context.getAssets().open("spawns.json");

        if (inputStream != null) {
            final Gson gson = PUBGApplication.getInstance().getGson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return gson.fromJson(reader, Spawns.class);

        }
        return null;
    }


    @Nullable
    public static byte[] getBytesForFile(@NonNull final Context context,
                                         @NonNull final String filename) throws IOException {
        return IOUtils.toByteArray(context.getAssets().open(filename));
    }

}
