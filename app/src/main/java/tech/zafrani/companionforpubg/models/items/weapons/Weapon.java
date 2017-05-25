package tech.zafrani.companionforpubg.models.items.weapons;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.gson.annotations.SerializedName;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.items.Item;
import tech.zafrani.companionforpubg.utils.Enums;

public class Weapon extends Item {
    @NonNull
    @SerializedName("type")
    private final Type type;


    public Weapon(@NonNull final String name,
                  final int id,
                  @NonNull final String imageUrl,
                  @NonNull final Type type) {
        super(name, id, imageUrl);
        this.type = type;
    }

    @NonNull
    public Type getType() {
        return type;
    }

    public enum Type implements Enums.FromString {
        AssaultRifle(R.string.weapon_type_assault_rifle),
        SniperRifle(R.string.weapon_type_sniper_rifle),
        CrossBow(R.string.weapon_type_cross_bow),
        Melee(R.string.weapon_type_melee),
        Grenade(R.string.weapon_type_grenade),
        LMG(R.string.weapon_type_lmg),
        SMG(R.string.weapon_type_smg),
        Pistol(R.string.weapon_type_pistol),
        Shotgun(R.string.weapon_type_shotgun),
        DMR(R.string.weapon_type_dmr);


        @NonNull
        public static Type fromString(final @NonNull String string) {
            return Enums.fromString(string, values());
        }

        @StringRes
        final int string;

        Type(@StringRes final int string) {
            this.string = string;
        }

        @StringRes
        public int getString() {
            return string;
        }
    }
}
