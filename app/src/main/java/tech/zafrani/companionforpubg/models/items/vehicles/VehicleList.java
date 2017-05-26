package tech.zafrani.companionforpubg.models.items.vehicles;


import java.util.ArrayList;
import java.util.Arrays;

public class VehicleList extends ArrayList<Vehicle> {

    @Override
    public String toString() {
        return "VehicleList{" +
                Arrays.toString(toArray()) +
                "}";
    }
}
