package tech.zafrani.pubgapp.utils;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import tech.zafrani.pubgapp.models.Category;
import tech.zafrani.pubgapp.models.Items;

public class FileUtil {

    @Nullable
    public static Items getItems(@NonNull final Activity activity) throws IOException {
        final InputStream inputStream = activity.getAssets().open("items.json");

        if (inputStream != null) {
            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return bindItems(gson.fromJson(reader, Items.class));

        }
        return null;
    }

    public static Items bindItems(@NonNull Items items) {
        List<Category> categories = items.getCategories();
        for (Category category: categories){
            category.updateChildren();
        }
        return items;
    }

    @Nullable
    public static byte[] getBytesForFile(@NonNull final Context context,
                                         @NonNull final String filename) throws IOException {
        return IOUtils.toByteArray(context.getAssets().open(filename));
    }

}
