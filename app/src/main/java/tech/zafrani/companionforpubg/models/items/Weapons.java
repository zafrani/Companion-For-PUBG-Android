package tech.zafrani.companionforpubg.models.items;


import java.util.ArrayList;
import java.util.Arrays;

public class Weapons extends ArrayList<Weapon> {

    @Override
    public String toString() {
        return "Weapons{" +
               Arrays.toString(toArray()) +
               "}";
    }
}
