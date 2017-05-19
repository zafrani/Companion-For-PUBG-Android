package tech.zafrani.pubgapp.models.items.types;


import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

import tech.zafrani.pubgapp.PUBGApplication;
import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.items.WeaponItem;

public class WeaponType extends Type {

    @SerializedName("id")
    private final int id;

    @SerializedName("items")
    private final List<WeaponItem> weaponItems;

    public WeaponType(final int id,
                      @NonNull final List<WeaponItem> weaponItems) {
        this.id = id;
        this.weaponItems = weaponItems;
    }

    @Override
    public String toString() {
        return "WeaponType{" +
               "\nid=" + id +
               ", \ntypeName=" + getTypeName()+
               ", \nweaponItems=" + Arrays.toString(this.weaponItems.toArray()) +
               '}';
    }

    @NonNull
    @Override
    protected String createTypeName() {
        switch (this.id) {
            case 0:
                return Name.AssaultRifle.getValue();
            case 1:
                return Name.SMG.getValue();
            case 2:
                return Name.LMG.getValue();
            case 3:
                return Name.Shotgun.getValue();
            case 4:
                return Name.SniperRifle.getValue();
            case 5:
                return Name.DMR.getValue();
            case 6:
                return Name.Pistol.getValue();
            case 7:
                return Name.Melee.getValue();
            case 8:
                return Name.Grenade.getValue();
            case 9:
                return Name.Crossbow.getValue();
        }
        throw new IllegalStateException("unknown type id");
    }


    enum Name {
        AssaultRifle(R.string.weapon_type_assault),
        SMG(R.string.weapon_type_smg),
        LMG(R.string.weapon_type_lmg),
        Shotgun(R.string.weapon_type_shotgun),
        SniperRifle(R.string.weapon_type_sniper),
        DMR(R.string.weapon_type_dmr),
        Pistol(R.string.weapon_type_pistol),
        Melee(R.string.weapon_type_melee),
        Grenade(R.string.weapon_type_grenade),
        Crossbow(R.string.weapon_type_crossbow);

        @StringRes
        private final int stringRes;

        Name(@StringRes final int stringRes) {
            this.stringRes = stringRes;
        }

        @NonNull
        public String getValue() {
            return PUBGApplication.getInstance().getString(this.stringRes);
        }
    }
}
