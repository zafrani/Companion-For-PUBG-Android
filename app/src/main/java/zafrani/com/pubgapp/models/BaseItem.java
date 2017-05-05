package zafrani.com.pubgapp.models;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;


public class BaseItem {
    @NonNull
    @SerializedName("cat_name")
    private final String cat_name;
    @NonNull
    @SerializedName("type_name")
    private final String type_name;
    @NonNull
    @SerializedName("name")
    private final String name;

    public BaseItem(@NonNull String category, @NonNull String type, @NonNull String name) {
        this.cat_name = category;
        this.type_name = type;
        this.name = name;
    }

    @NonNull
    public String getCategory() {
        return cat_name;
    }

    @NonNull
    public String getType() {
        return type_name;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
