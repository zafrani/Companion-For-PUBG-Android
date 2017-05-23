package tech.zafrani.companionforpubg.models.items.ammo;


import java.util.ArrayList;
import java.util.Arrays;

import tech.zafrani.companionforpubg.models.items.weapons.Weapon;

public class AmmoList extends ArrayList<Ammo> {

    @Override
    public String toString() {
        return "WeaponList{" +
               Arrays.toString(toArray()) +
               "}";
    }
}
