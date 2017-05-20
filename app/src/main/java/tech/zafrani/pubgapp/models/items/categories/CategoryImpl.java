package tech.zafrani.pubgapp.models.items.categories;


import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import tech.zafrani.pubgapp.models.items.Item;

public abstract class CategoryImpl<CategoryItem extends Item>
        implements Category<CategoryItem> {

    @StringRes
    public abstract int getCategoryNameRes();


}
