package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

public class BaseItem {
    @NonNull
    private String name;
    @NonNull
    private String category;
    @NonNull
    private String type;

    public BaseItem(@NonNull String name, @NonNull String category, @NonNull String type) {
        this.name = name;
        this.category = category;
        this.type = type;
    }
}
