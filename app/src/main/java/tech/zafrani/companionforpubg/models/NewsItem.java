package tech.zafrani.companionforpubg.models;


import android.support.annotation.NonNull;

public class NewsItem {
    private final String title;
    private final String type;
    private final String date;
    private final String description;
    private final String linkSrc;
    private final String imgSrc;

    public NewsItem(@NonNull final String title,
                    @NonNull final String type,
                    @NonNull final String date,
                    @NonNull final String description,
                    @NonNull final String linkSrc,
                    @NonNull final String imgSrc) {
        this.title = title;
        this.type = type;
        this.date = date;
        this.description = description;
        this.linkSrc = linkSrc;
        this.imgSrc = imgSrc;
    }



}
