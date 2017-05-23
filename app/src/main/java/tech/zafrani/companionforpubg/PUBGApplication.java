package tech.zafrani.companionforpubg;

import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import tech.zafrani.companionforpubg.models.items.Category;
import tech.zafrani.companionforpubg.models.items.Items;
import tech.zafrani.companionforpubg.utils.CategoryJsonAdapter;
import tech.zafrani.companionforpubg.utils.Enums;
import tech.zafrani.companionforpubg.utils.FileUtil;

public class PUBGApplication extends Application {

    @Nullable // not really.
    private static PUBGApplication instance = null;

    @NonNull
    public static PUBGApplication getInstance() {
        if (instance == null) {
            throw new IllegalStateException("application is null?");
        }
        return instance;
    }

    @Nullable
    private Items items;

    @Nullable
    private Gson gson;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    @NonNull
    public Items getItems() {
        if (this.items == null) {
            try {
                this.items = FileUtil.getItems(this);
            } catch (IOException e) {
                throw new IllegalStateException("Failed to read items.json");
            }
            if (this.items == null) {
                throw new IllegalStateException("Failed to read items.json");
            }
        }
        return this.items;
    }

    @NonNull
    public Gson getGson() {
        if (this.gson == null) {
            this.gson = new GsonBuilder()
                    .registerTypeAdapter(Category.class, new CategoryJsonAdapter())
                    .registerTypeHierarchyAdapter(Enums.FromString.class, new Enums.Serialization())
                    .create();
        }
        return this.gson;
    }
}
