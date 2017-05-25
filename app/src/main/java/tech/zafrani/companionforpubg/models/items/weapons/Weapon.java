package tech.zafrani.companionforpubg.models.items.weapons;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.items.Item;
import tech.zafrani.companionforpubg.utils.Enums;

import static tech.zafrani.companionforpubg.models.items.weapons.Weapon.Type.Grenade;
import static tech.zafrani.companionforpubg.models.items.weapons.Weapon.Type.Melee;

public abstract class Weapon extends Item {
    @NonNull
    @SerializedName("type")
    private final Type type;


    public Weapon(@NonNull final String name,
                  final int id,
                  @NonNull final String imageUrl,
                  final int capacity,
                  @NonNull final Type type) {
        super(name, id, imageUrl, capacity);
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString()+
               "Weapon{" +
               "type=" + type +
               '}';
    }

    @NonNull
    public Type getType() {
        return this.type;
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

    public static class JsonAdapter
            implements JsonDeserializer<Weapon> {
        private static final String TYPE = "type";

        @Override
        public Weapon deserialize(final JsonElement json,
                                  final java.lang.reflect.Type typeOfT,
                                  final JsonDeserializationContext context) throws JsonParseException {
            if (json == null) {
                return null;
            }
            final JsonObject jsonObject = json.getAsJsonObject();
            if (jsonObject == null) {
                return null;
            }
            String type = jsonObject.get(TYPE).getAsString();
            if (Melee.name().equalsIgnoreCase(type)) {
                return context.deserialize(jsonObject, MeleeWeapon.class);
            } else if (Grenade.name().equalsIgnoreCase(type)) {
                return context.deserialize(jsonObject, GrenadeWeapon.class);
            } else {
                return context.deserialize(jsonObject, ProjectileWeapon.class);
            }
        }
    }

}
