package tech.zafrani.companionforpubg.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import tech.zafrani.companionforpubg.models.Category;
import tech.zafrani.companionforpubg.models.Items;
import tech.zafrani.companionforpubg.models.News;
import tech.zafrani.companionforpubg.models.NewsItem;
import tech.zafrani.companionforpubg.models.spawns.Spawns;

public class FileUtil {

    @Nullable
    public static Items getItems(@NonNull final Context context) throws IOException {
        final InputStream inputStream = context.getAssets().open("items.json");

        if (inputStream != null) {
            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return bindItems(gson.fromJson(reader, Items.class));

        }
        return null;
    }
    @Nullable
    public static Spawns getSpawns(@NonNull final Context context) throws IOException {
        final InputStream inputStream = context.getAssets().open("spawns.json");

        if (inputStream != null) {
            final Gson gson = new Gson();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            return gson.fromJson(reader, Spawns.class);

        }
        return null;
    }

    @NonNull
    public static Items bindItems(@NonNull final Items items) {
        final List<Category> categories = items.getCategories();
        for (final Category category: categories){
            category.updateChildren();
        }
        return items;
    }

    @Nullable
    public static byte[] getBytesForFile(@NonNull final Context context,
                                         @NonNull final String filename) throws IOException {
        return IOUtils.toByteArray(context.getAssets().open(filename));
    }


    public static News getPUBGNews(@NonNull final Context context) throws IOException {
        final News news = new News();
        final Document document = Jsoup.connect("https://www.playbattlegrounds.com/news.pu").get();
        for (Element row: document.select("ul#allList li")) {

            final String title = row.select(".title").text();
            final String type = row.select(".sp_sub").text();
            final String date = row.select(".date").text();
            final String description = row.select(".descrption").text();

            final Element link = row.select("a").first();
            final String linkSrc = link.absUrl("href");
            final Element img = row.select(".img_wrap img").first();
            final String imgSrc = img.absUrl("src");

            System.out.println(title + " -- " + date + ", " + type + " (" + description+")");
            System.out.println("article link: " + linkSrc + ", img link: " + imgSrc);

            news.add(new NewsItem(title, type, date, description, linkSrc, imgSrc));
        }
        return news;
    }

}
