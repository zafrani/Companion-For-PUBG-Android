package tech.zafrani.companionforpubg.models.items.attachments;


import java.util.ArrayList;
import java.util.Arrays;

public class AttachmentList extends ArrayList<Attachment> {

    @Override
    public String toString() {
        return "AttachmentList{" +
                Arrays.toString(toArray()) +
                "}";
    }
}
