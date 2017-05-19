package tech.zafrani.pubgapp.models.items.categories;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;


import java.io.Serializable;
import java.util.List;

import tech.zafrani.pubgapp.PUBGApplication;
import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.items.types.Type;

public interface Category<CategoryItem extends Type> extends Serializable {
    @NonNull
    String getName();

    @NonNull
    List<CategoryItem> getItems();

    enum Name {
        Weapons(R.string.category_weapons),
        Ammo(R.string.category_ammunition),
        Attachments(R.string.category_attachments),
        Equipment(R.string.category_equipment),
        Consumables(R.string.category_consumables),
        Vehicles(R.string.category_vehicles);

        @StringRes
        private final int stringRes;

        Name(@StringRes final int stringRes) {
            this.stringRes = stringRes;
        }

        @NonNull
        public String getValue() {
            return PUBGApplication.getInstance().getString(stringRes);
        }
    }


}
