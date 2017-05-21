package tech.zafrani.companionforpubg.models;


import android.support.annotation.StringRes;

public abstract class CategoryImpl<CategoryItem extends Item> implements Category<CategoryItem> {

    @StringRes
    public abstract int getCategoryNameRes();

}
