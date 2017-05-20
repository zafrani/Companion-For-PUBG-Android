package tech.zafrani.pubgapp.models.items.types;


import android.support.annotation.NonNull;
import android.support.annotation.StringRes;


import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Enums;

public enum WeaponType implements Enums.FromString {


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

    @NonNull
    public static WeaponType fromString(final @NonNull String string) {
        return Enums.fromString(string, values());
    }

    @StringRes
    private final int stringRes;

    WeaponType(@StringRes final int stringRes) {
        this.stringRes = stringRes;
    }

    @StringRes
    public int getStringRes() {
        return stringRes;
    }
}
