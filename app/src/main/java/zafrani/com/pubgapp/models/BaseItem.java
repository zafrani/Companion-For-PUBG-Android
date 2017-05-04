package zafrani.com.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class BaseItem {
    @SerializedName("name")
    @NonNull
    private String name;
    @SerializedName("capacity")
    @NonNull
    private String capacity;



    public BaseItem(@NonNull String name, @NonNull String capacity) {
        this.name = name;
        this.capacity =capacity;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getCapacity() {
        return capacity;
    }
}
