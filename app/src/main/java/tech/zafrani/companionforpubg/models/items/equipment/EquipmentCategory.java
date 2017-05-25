package tech.zafrani.companionforpubg.models.items.equipment;


import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tech.zafrani.companionforpubg.models.items.Category;

public class EquipmentCategory implements Category<Equipment> {

    @NonNull
    @SerializedName("equipment")
    private final EquipmentList equipmentList;

    public EquipmentCategory(@NonNull final EquipmentList equipmentList) {
        this.equipmentList = equipmentList;
    }

    @Override
    public String toString() {
        return "EquipmentCategory{" +
                "equipmentList=" + this.equipmentList.toString() +
                '}';
    }

    @Override
    public List<Equipment> getItems() {
        return null;
    }
}
