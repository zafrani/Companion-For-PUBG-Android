package tech.zafrani.companionforpubg.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tech.zafrani.companionforpubg.models.items.Items;
import tech.zafrani.companionforpubg.models.spawns.Spawns;

public class FileUtil {
    @Nullable
    public static <T> T getFile(@NonNull final Context context,
                                @NonNull final String filename,
                                @NonNull Class<T> tClass) throws IOException {
        final InputStream inputStream = context.getAssets().open(filename);

        if (inputStream != null) {
            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return gson.fromJson(reader, tClass);

        }
        return null;
    }

    @Nullable
    public static Items getItems(@NonNull final Context context) throws IOException {
        return getFile(context, "items.json", Items.class);
    }

    @Nullable
    public static Spawns getSpawns(@NonNull final Context context) throws IOException {
        return getFile(context, "spawns.json", Spawns.class);
    }


    @Nullable
    public static byte[] getBytesForFile(@NonNull final Context context,
                                         @NonNull final String filename) throws IOException {
        return IOUtils.toByteArray(context.getAssets().open(filename));
    }

}
