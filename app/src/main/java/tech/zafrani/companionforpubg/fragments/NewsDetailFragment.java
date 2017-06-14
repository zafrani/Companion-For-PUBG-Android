package tech.zafrani.companionforpubg.fragments;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.utils.Constants;

public class NewsDetailFragment extends BaseFragment {
    public static final String TAG = NewsDetailFragment.class.getSimpleName();
    public static final String ARG_NEWS_SRC = NewsDetailFragment.class.getSimpleName() + ".ARG_NEWS_SRC";

    @Nullable
    @BindView(R.id.fragment_newsdetails_webview)
    WebView newsWebView;

    private String newsSource;


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
        if (args == null) {
            throw new IllegalStateException("Missing arguments");
        }
        if (!args.containsKey(ARG_NEWS_SRC)) {
            throw new IllegalStateException("Missing key");
        }

        newsSource = args.getString(ARG_NEWS_SRC);
        if (newsSource == null) {
            Toast.makeText(getActivity(), "Failed to load.", Toast.LENGTH_SHORT).show();
            getActivity().finish();
            return;
        }

        setHasOptionsMenu(true);
        setWebView();

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_news_detail, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_news_share) {
            shareNewsArticle();
        }
        return super.onOptionsItemSelected(item);
    }

    private void setWebView() {
        if (newsWebView != null) {
            WebSettings settings = this.newsWebView.getSettings();
            settings.setUseWideViewPort(true);
            settings.setBuiltInZoomControls(true);
            settings.setLoadWithOverviewMode(true);
            this.newsWebView.loadUrl(newsSource);
        }
    }

    private void shareNewsArticle() {
        try {
            final Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, newsSource);
            startActivity(Intent.createChooser(shareIntent, "Share PUB Article"));
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getActivity(), "Unable to share article", Toast.LENGTH_LONG).show();
        }
    }

}
