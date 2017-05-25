package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.webkit.WebView;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;

public class NewsDetailFragment extends BaseFragment {
    public static final String ARG_NEWS_SRC = NewsDetailFragment.class.getSimpleName() + ".ARG_NEWS_SRC";

    public static NewsDetailFragment newInstance(@NonNull final String newsSrc) {
        final NewsDetailFragment fragment = new NewsDetailFragment();
        final Bundle bundle = new Bundle();
        bundle.putString(ARG_NEWS_SRC, newsSrc);
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_newsdetails;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle args = getArguments();
        if (args==null) {
            throw new IllegalStateException("Missing arguments");
        }
        final String newsSrc = args.getString(ARG_NEWS_SRC);
        setWebView(newsSrc);
    }

    @Nullable
    @BindView(R.id.fragment_newsdetails_webview)
    WebView newsWebView;


    private void setWebView(@NonNull final String newsSrc) {
        this.newsWebView.loadUrl(newsSrc);
    }

}
