package tech.zafrani.companionforpubg.models.items.weapons;


import java.util.ArrayList;
import java.util.Arrays;

public class WeaponList extends ArrayList<Weapon> {

    @Override
    public String toString() {
        return "WeaponList{" +
               Arrays.toString(toArray()) +
               "}";
    }
}
