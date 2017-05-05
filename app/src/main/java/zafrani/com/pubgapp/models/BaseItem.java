package zafrani.com.pubgapp.models;

import android.support.annotation.NonNull;


public class BaseItem {
    @NonNull
    private final String category;
    @NonNull
    private final String type;
    @NonNull
    private final String name;

    public BaseItem(@NonNull String category, @NonNull String type, @NonNull String name) {
        this.category = category;
        this.type = type;
        this.name = name;
    }

    @NonNull
    public String getCategory() {
        return category;
    }

    @NonNull
    public String getType() {
        return type;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
