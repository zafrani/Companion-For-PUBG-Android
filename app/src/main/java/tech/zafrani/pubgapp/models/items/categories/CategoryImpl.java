package tech.zafrani.pubgapp.models.items.categories;


import android.support.annotation.NonNull;

import tech.zafrani.pubgapp.models.items.types.Type;

public abstract class CategoryImpl<CategoryItem extends Type> implements Category<CategoryItem> {

    private final Name name;

    public CategoryImpl(@NonNull final Name name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryImpl{" +
               "\nname=" + this.name +
               '}';
    }

    @NonNull
    @Override
    public String getName() {
        return name.getValue();
    }


}
