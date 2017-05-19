package tech.zafrani.pubgapp.models.items.types;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class Type {

    @Nullable
    private String typeName = null;

    @NonNull
    protected String getTypeName() {
        if (this.typeName == null) {
            this.typeName = createTypeName();
        }
        return this.typeName;
    }

    @NonNull
    protected abstract String createTypeName();
}
