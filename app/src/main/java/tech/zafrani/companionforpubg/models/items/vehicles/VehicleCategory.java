package tech.zafrani.companionforpubg.models.items.vehicles;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tech.zafrani.companionforpubg.models.items.Category;

public class VehicleCategory implements Category<Vehicle> {
    @NonNull
    @SerializedName("vehicle")
    private final VehicleList vehicleList;

    public VehicleCategory(@NonNull final VehicleList vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public String toString() {
        return "VehicleCategory{" +
                "vehicleList=" + this.vehicleList.toString() +
                '}';
    }

    @Override
    public List<Vehicle> getItems() {
        return this.vehicleList;
    }
}
