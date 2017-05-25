package tech.zafrani.companionforpubg.models.items.attachments;


import android.support.annotation.NonNull;

import tech.zafrani.companionforpubg.models.items.Item;

public class Attachment extends Item {

    public Attachment(@NonNull final String name,
                      final int id,
                      @NonNull final String imageUrl) {
        super(name, id, imageUrl);
    }
}
