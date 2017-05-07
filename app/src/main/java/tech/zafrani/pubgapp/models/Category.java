package tech.zafrani.pubgapp.models;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

public class Category {
    @NonNull
    @SerializedName("cat_name")
    private final String name;

    @NonNull
    @SerializedName("types")
    private final List<Type> types;


    public Category(@NonNull final String cat_name,
                    @NonNull final List<Type> types
                    ) {
        this.name = cat_name;
        this.types = types;
    }

    @NonNull
    public List<Type> getTypes() {
        return types;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", types=" + Arrays.toString(types.toArray()) +
                '}';
    }
}
