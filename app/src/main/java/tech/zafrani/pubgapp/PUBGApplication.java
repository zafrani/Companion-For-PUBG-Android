package tech.zafrani.pubgapp;


import android.app.Application;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import tech.zafrani.pubgapp.models.Enums;
import tech.zafrani.pubgapp.models.items.Items;
import tech.zafrani.pubgapp.utils.FileUtil;

public class PUBGApplication extends Application {

    private static PUBGApplication INSTANCE = null;

    @NonNull
    public static PUBGApplication getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Instance is null?");
        }
        return INSTANCE;
    }

    @Nullable
    private Gson gson = null;

    @Nullable
    private Items items = null;

    @Override
    public void onCreate() {
        super.onCreate();
        PUBGApplication.INSTANCE = this;
    }

    @NonNull
    public Gson getGson() {
        if (this.gson == null) {
            final GsonBuilder builder = new GsonBuilder();
            builder.registerTypeHierarchyAdapter(Enums.FromString.class, new Enums.Serialization());
            this.gson = builder.create();
        }
        return gson;
    }

    @NonNull
    public Items getItems() {
        if (this.items == null) {
            try {
                this.items = FileUtil.getItems(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (this.items == null) {
                throw new IllegalStateException("failed to load items");
            }
        }
        return this.items;
    }
}
