package tech.zafrani.companionforpubg.activities;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import tech.zafrani.companionforpubg.fragments.PUBGMapFragment;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.fragments.ItemFragment;
import tech.zafrani.companionforpubg.fragments.NewsFragment;
import tech.zafrani.companionforpubg.utils.Constants;

public abstract class DrawerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";

    @Nullable
    @BindView(R.id.activity_drawer_toolbar)
    Toolbar toolbar;
    @Nullable
    @BindView(R.id.activity_drawer_drawerlayout)
    DrawerLayout drawerLayout;
    @Nullable
    @BindView(R.id.activity_drawer_navigationview)
    NavigationView navigationView;
    @Nullable
    @BindView(R.id.activity_drawer_content)
    FrameLayout contentLayout;

    private int selectedMenuItem = R.id.drawer_map;

    //region Activity
    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (this.navigationView != null) {
            this.navigationView.setNavigationItemSelectedListener(this);
            this.navigationView.setCheckedItem(R.id.drawer_map);
        }

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(EXTRA_ITEM_ID)) {
                selectedMenuItem = savedInstanceState.getInt(EXTRA_ITEM_ID);
            }
        }

        loadFragmentWithItemId(selectedMenuItem);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(EXTRA_ITEM_ID, selectedMenuItem);
    }

    @Override
    protected void onDestroy() {
        if (this.navigationView != null) {
            this.navigationView.setNavigationItemSelectedListener(null);
        }

        super.onDestroy();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_drawer;
    }

    @Override
    protected int getContentView() {
        return R.id.activity_drawer_content;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if (drawerLayout != null) {
                    this.drawerLayout.openDrawer(GravityCompat.START);
                }
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    //endregion

    //region NavigationView.OnNavigationItemSelectedListener
    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        if (this.drawerLayout == null) {
            return false;
        }

        selectedMenuItem = item.getItemId();
        this.drawerLayout.closeDrawers();
        loadFragmentWithItemId(selectedMenuItem);

        return true;
    }
    //endregion

    private void loadFragmentWithItemId(int itemId) {
        switch (itemId) {
            case R.id.drawer_map:
                mapSelected();
                break;
            case R.id.drawer_items:
                itemsSelected();
                break;
            case R.id.drawer_news:
                newsSelected();
                break;
            case R.id.drawer_github:
                githubSelected();
                break;
            case R.id.drawer_image_data:
                imageDataSelected();
                break;
            case R.id.drawer_contact_us:
                contactUsSelected();
                break;
            case R.id.drawer_rate_app:
                rateAppSelected();
                break;
        }
    }

    //region methods
    private void mapSelected() {
        if (this.contentLayout == null) {
            return;
        }
        final Fragment fragment = getFragmentManager().findFragmentByTag(PUBGMapFragment.TAG);
        if (fragment == null) {
            showFragment(new PUBGMapFragment(), PUBGMapFragment.TAG);
        } else {
            showFragment(fragment, PUBGMapFragment.TAG);
        }
    }

    private void itemsSelected() {
        if (this.contentLayout == null) {
            return;
        }

        final Fragment fragment = getFragmentManager().findFragmentByTag(ItemFragment.TAG);
        if (fragment == null) {
            showFragment(new ItemFragment(), ItemFragment.TAG);
        } else {
            showFragment(fragment, ItemFragment.TAG);
        }
    }

    private void newsSelected() {
        if (this.contentLayout == null) {
            return;
        }
        final Fragment fragment = getFragmentManager().findFragmentByTag(NewsFragment.TAG);
        if (fragment == null) {
            showFragment(new NewsFragment(), NewsFragment.TAG);
        } else {
            showFragment(fragment, NewsFragment.TAG);
        }
    }

    private void githubSelected() {
        final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.GITHUB_APP_URL));
        startActivity(browserIntent);
    }

    private void imageDataSelected() {
        final Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Constants.GITHUB_IMAGE_URL));
        startActivity(browserIntent);
    }

    private void contactUsSelected() {
        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO,
                                              Uri.fromParts("mailto", Constants.CONTACT_US_EMAIL, null));
        startActivity(Intent.createChooser(emailIntent, getString(R.string.label_send_email)));
    }

    private void rateAppSelected() {
        String packageName = getApplication().getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(getString(R.string.google_app_uri), packageName))));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(String.format(getString(R.string.google_app_url), packageName))));
        }
    }
    //endregion
}
