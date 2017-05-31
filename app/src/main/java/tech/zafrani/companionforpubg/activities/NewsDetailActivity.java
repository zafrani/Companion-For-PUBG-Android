package tech.zafrani.companionforpubg.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.fragments.NewsDetailFragment;
import tech.zafrani.companionforpubg.models.NewsItem;

public class NewsDetailActivity extends BaseActivity {
    private static final String EXTRA_NEWSITEM_SRC = NewsDetailActivity.class.getSimpleName() + ".EXTRA_NEWSITEM";

    public static void startActivity(@NonNull final Context context,
                                     @NonNull final NewsItem newsItem){

        final Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra(EXTRA_NEWSITEM_SRC, newsItem.getLinkSrc());
        context.startActivity(intent);
    }

    @Nullable
    @BindView(R.id.activity_newsdetails_toolbar)
    Toolbar toolbar;

    @Nullable
    @BindView(R.id.activity_newsdetails_content)
    FrameLayout contentLayout;

    //region Activity

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        final Intent intent = getIntent();
        if (intent == null) {
            throw new IllegalStateException("Missing intent");
        }
        final String newsItemSrc = intent.getStringExtra(EXTRA_NEWSITEM_SRC);
        showFragment(NewsDetailFragment.newInstance(newsItemSrc), NewsDetailFragment.TAG);

    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected int getLayoutRes() {
        return R.layout.activity_newsdetails;
    }

    @Override
    protected int getContentView() {
        return R.id.activity_newsdetails_content;
    }

    //endregion





}
