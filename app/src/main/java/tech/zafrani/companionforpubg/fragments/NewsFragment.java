package tech.zafrani.companionforpubg.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.activities.NewsDetailActivity;
import tech.zafrani.companionforpubg.adapters.ItemRecyclerViewAdapter;
import tech.zafrani.companionforpubg.adapters.NewsAdapter;
import tech.zafrani.companionforpubg.models.NewsItem;
import tech.zafrani.companionforpubg.utils.PUBGNewsFetch;


public class NewsFragment extends BaseFragment implements PUBGNewsFetch.Listener,
        ItemRecyclerViewAdapter.Listener<NewsItem> {
    public static final String TAG = NewsFragment.class.getSimpleName();

    @BindView(R.id.fragment_news_recyclerview)
    public RecyclerView recyclerView;

    @Nullable
    private NewsAdapter adapter;

    // region BaseFragment


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_news;
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        this.recyclerView.addItemDecoration(itemDecoration);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.adapter =  new NewsAdapter();
        adapter.setListener(this);
        this.recyclerView.setAdapter(adapter);

        final PUBGNewsFetch newsFetch = new PUBGNewsFetch(this);
        newsFetch.execute();
    }

    @Override
    public void onDestroy() {
        if (recyclerView != null) {
            recyclerView.setAdapter(null);
            adapter=null;
        }
        super.onDestroy();
    }

    // endregion


    @Override
    public void updateNews(NewsItem newsItem) {
        if (adapter!= null){
            adapter.add(newsItem);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onClick(@NonNull NewsItem newsItem) {
        NewsDetailActivity.startActivity(getActivity(), newsItem);

    }
}
