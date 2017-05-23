package tech.zafrani.companionforpubg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.NewsAdapter;
import tech.zafrani.companionforpubg.utils.PUBGNewsFetch;


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
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_news_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter =  new NewsAdapter();
        recyclerView.setAdapter(adapter);

        final PUBGNewsFetch newsFetch = new PUBGNewsFetch(adapter);
        newsFetch.execute();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    // endregion




}
