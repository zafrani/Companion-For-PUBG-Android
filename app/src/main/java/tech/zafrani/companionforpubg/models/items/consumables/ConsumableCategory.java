package tech.zafrani.companionforpubg.models.items.consumables;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tech.zafrani.companionforpubg.models.items.Category;

public class ConsumableCategory implements Category<Consumable> {
    @NonNull
    @SerializedName("consumable")
    private final ConsumableList consumableList;

    public ConsumableCategory(@NonNull final ConsumableList consumableList) {
        this.consumableList = consumableList;
    }

    @Override
    public String toString() {
        return "ConsumableCategory{" +
                "consumableList=" + this.consumableList.toString() +
                '}';
    }

    @Override
    public List<Consumable> getItems() {
        return this.consumableList;
    }
}
