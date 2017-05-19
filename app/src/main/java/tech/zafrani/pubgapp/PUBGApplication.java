package tech.zafrani.pubgapp;


import android.app.Application;
import android.support.annotation.NonNull;

public class PUBGApplication extends Application {

    private static PUBGApplication INSTANCE = null;

    @NonNull
    public static PUBGApplication getInstance() {
        if (INSTANCE == null) {
            throw new IllegalStateException("Instance is null?");
        }
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        PUBGApplication.INSTANCE = this;
    }
}
