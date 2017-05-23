package tech.zafrani.companionforpubg.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import tech.zafrani.companionforpubg.models.NewsItem;

import static tech.zafrani.companionforpubg.utils.Constants.PUBG_NEWS_LINK;

public class PUBGNewsFetch extends AsyncTask<Void, NewsItem, Void>  {
    @NonNull
    private final static String NEWS_DOCUMENT_SELECTOR = "ul#allList li";
    @NonNull
    private final static String NEWS_TITLE_SELECTOR = ".title";
    @NonNull
    private final static String NEWS_TYPE_SELECTOR = ".sp_sub";
    @NonNull
    private final static String NEWS_DATE_SELECTOR = ".date";
    @NonNull
    private final static String NEWS_DESCRIPTION_SELECTOR = ".descrption";
    @NonNull
    private final static String NEWS_LINK_SELECTOR = "a";
    @NonNull
    private final static String NEWS_LINKSRC_SELECTOR = "href";
    @NonNull
    private final static String NEWS_IMG_SELECTOR = ".img_wrap img";
    @NonNull
    private final static String NEWS_IMGSRC_SELECTOR = "src";


    public PUBGNewsListener delegate = null;

    @Override
    protected Void doInBackground(final Void... voids) {

        final Document document;
        try {
            document = Jsoup.connect(PUBG_NEWS_LINK).get();
            for (final Element row : document.select(NEWS_DOCUMENT_SELECTOR)) {
                final String title = row.select(NEWS_TITLE_SELECTOR).text();
                final String type = row.select(NEWS_TYPE_SELECTOR).text();
                final String date = row.select(NEWS_DATE_SELECTOR).text();
                final String description = row.select(NEWS_DESCRIPTION_SELECTOR).text();
                final Element link = row.select(NEWS_LINK_SELECTOR).first();
                final String linkSrc = link.absUrl(NEWS_LINKSRC_SELECTOR);
                final Element img = row.select(NEWS_IMG_SELECTOR).first();
                final String imgSrc = img.absUrl(NEWS_IMGSRC_SELECTOR);

                publishProgress(new NewsItem(title, type, date, description, linkSrc, imgSrc));
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(@NonNull final NewsItem... values) {
        super.onProgressUpdate(values);
        for (final NewsItem item :
                values) {
            delegate.updateNews(item);
        }
    }

    @Override
    protected void onPostExecute(final Void aVoid) {
        super.onPostExecute(aVoid);
    }

    public interface PUBGNewsListener {
        public void updateNews(NewsItem newsItem);
    }
}

