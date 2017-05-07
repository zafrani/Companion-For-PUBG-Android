package tech.zafrani.pubgapp.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import tech.zafrani.pubgapp.models.Items;

public class FileUtil {

    @Nullable
    public static Items getItems(@NonNull final Activity activity) throws IOException {
        final InputStream inputStream = activity.getAssets().open("items.json");

        if (inputStream != null) {
            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            return gson.fromJson(reader, Items.class);
        }
        return null;
    }
}
