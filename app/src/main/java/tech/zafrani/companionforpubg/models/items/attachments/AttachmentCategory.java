package tech.zafrani.companionforpubg.models.items.attachments;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import tech.zafrani.companionforpubg.models.items.Category;
import tech.zafrani.companionforpubg.models.items.ammo.Ammo;

public class AttachmentCategory implements Category<Attachment> {

    @NonNull
    @SerializedName("attachments")
    private final AttachmentList attachmentList;

    public AttachmentCategory(@NonNull final AttachmentList attachmentList) {
        this.attachmentList = attachmentList;
    }

    @Override
    public String toString() {
        return "AttachmentCategory{" +
               "attachmentList=" + this.attachmentList.toString() +
               '}';
    }

    @Override
    public List<Attachment> getItems() {
        return this.attachmentList;
    }

    @Nullable
    public Attachment getAttachmentWithId(final int id) {
        for (final Attachment attachment : attachmentList) {
            if (attachment.getId() == id) {
                return attachment;
            }
        }
        return null;
    }
}
