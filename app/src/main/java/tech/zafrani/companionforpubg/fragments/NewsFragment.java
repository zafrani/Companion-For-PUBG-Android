package tech.zafrani.companionforpubg.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.News;
import tech.zafrani.companionforpubg.utils.FileUtil;


public class NewsFragment extends BaseFragment {
    public static final String TAG = NewsFragment.class.getSimpleName();
    private RecyclerView recyclerView;

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
        News news = new News();
        try {
            news = FileUtil.getPUBGNews(getActivity());
        } catch (IOException e) {
            e.printStackTrace();
        }

        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_news_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // final ItemListAdapter adapter =  new ItemListAdapter(items);
        // recyclerView.setAdapter(adapter);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    // endregion

}
