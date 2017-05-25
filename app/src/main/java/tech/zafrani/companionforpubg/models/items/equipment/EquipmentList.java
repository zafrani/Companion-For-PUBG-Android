package tech.zafrani.companionforpubg.models.items.equipment;


import java.util.ArrayList;
import java.util.Arrays;

public class EquipmentList extends ArrayList<Equipment> {
    @Override
    public String toString() {
        return "EquipmentList{" +
                Arrays.toString(toArray()) +
                "}";
    }
}
