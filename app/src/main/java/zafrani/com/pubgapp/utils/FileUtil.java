package zafrani.com.pubgapp.utils;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import zafrani.com.pubgapp.models.Category;
import zafrani.com.pubgapp.models.Item;
import zafrani.com.pubgapp.models.Items;
import zafrani.com.pubgapp.models.Type;

public class FileUtil {

    @Nullable
    public static Items getItems(@NonNull final Activity activity) throws IOException {
        final InputStream inputStream = activity.getAssets().open("items.json");

        if (inputStream != null) {
            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return bindInfo(gson.fromJson(reader, Items.class));

        }
        return null;
    }



    public static Items bindInfo(@NonNull final Items items) {
        for (Category category: items.getCategories()){

            for (Type type: category.getTypes()){
                for (Item item: type.getItems()) {
                    item.setCategory(category.getName());
                    item.setType(type.getType_name());
                }
            }
        }
        return items;
    }
}
