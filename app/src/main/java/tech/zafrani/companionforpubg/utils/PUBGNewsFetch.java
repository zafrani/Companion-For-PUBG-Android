package tech.zafrani.companionforpubg.utils;

import android.os.AsyncTask;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import tech.zafrani.companionforpubg.adapters.NewsAdapter;
import tech.zafrani.companionforpubg.models.NewsItem;

public class PUBGNewsFetch extends AsyncTask<Void, NewsItem, Void>  {
    private final NewsAdapter adapter;

    public PUBGNewsFetch(NewsAdapter adapter) {
        this.adapter= adapter;
    }

    @Override
    protected Void doInBackground(final Void... voids) {

        final Document document;
        try {
            document = Jsoup.connect("https://www.playbattlegrounds.com/news.pu").get();
            for (final Element row : document.select("ul#allList li")) {

                final String title = row.select(".title").text();
                final String type = row.select(".sp_sub").text();
                final String date = row.select(".date").text();
                final String description = row.select(".descrption").text();

                final Element link = row.select("a").first();
                final String linkSrc = link.absUrl("href");
                final Element img = row.select(".img_wrap img").first();
                final String imgSrc = img.absUrl("src");

                System.out.println(title + " -- " + date + ", " + type + " (" + description + ")");
                System.out.println("article link: " + linkSrc + ", img link: " + imgSrc);
                publishProgress(new NewsItem(title, type, date, description, linkSrc, imgSrc));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    protected void onProgressUpdate(final NewsItem... values) {
        super.onProgressUpdate(values);
        for (final NewsItem item :
                values) {
            adapter.addNewsItem(item);
        }
    }

    @Override
    protected void onPostExecute(final Void aVoid) {
        super.onPostExecute(aVoid);
        adapter.notifyDataSetChanged();
    }
}

