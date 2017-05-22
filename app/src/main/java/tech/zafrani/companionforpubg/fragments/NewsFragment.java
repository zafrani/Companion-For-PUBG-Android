package tech.zafrani.companionforpubg.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.NewsAdapter;
import tech.zafrani.companionforpubg.models.News;
import tech.zafrani.companionforpubg.models.NewsItem;


public class NewsFragment extends BaseFragment {
    public static final String TAG = NewsFragment.class.getSimpleName();
    private RecyclerView recyclerView;
    private NewsAdapter adapter;

    // region BaseFragment
    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_news, container,false);
    }

    @Override
    public void onViewCreated(View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ScrapeTask scrapeTask = new ScrapeTask();
        scrapeTask.execute();

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_news_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter =  new NewsAdapter();
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    // endregion


    private class ScrapeTask extends AsyncTask<String, String, News> {

        @Override
        protected News doInBackground(String... strings) {

            final Document document;
            final News news = new News();
            try {
                document = Jsoup.connect("https://www.playbattlegrounds.com/news.pu").get();
                for (Element row : document.select("ul#allList li")) {

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

                    news.add(new NewsItem(title, type, date, description, linkSrc, imgSrc));

                }
                return news;
            } catch(IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(News news) {
            super.onPostExecute(news);
            adapter.setNews(news);
            adapter.notifyDataSetChanged();

        }
    }

}
