package tech.zafrani.companionforpubg.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import butterknife.BindView;
import tech.zafrani.companionforpubg.fragments.PUBGMapFragment;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.fragments.ItemFragment;
import tech.zafrani.companionforpubg.utils.Constants;

public abstract class DrawerActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {

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

        if(this.navigationView != null) {
            this.navigationView.setNavigationItemSelectedListener(this);
            this.navigationView.setCheckedItem(R.id.drawer_map);
        }
        mapSelected();
    }

    @Override
    protected void onDestroy() {
        if(this.navigationView != null) {
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
                if(drawerLayout != null) {
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

        this.drawerLayout.closeDrawers();
        switch (item.getItemId()) {
            case R.id.drawer_map:
                mapSelected();
                break;
            case R.id.drawer_items:
                itemsSelected();
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
        }
        return true;
    }
    //endregion


    //region methods
    private void mapSelected() {
        if(contentLayout == null) {
            return;
        }

        final Fragment fragment = getFragmentManager().findFragmentByTag(PUBGMapFragment.TAG);
        if (fragment == null) {
            showFragment(new PUBGMapFragment());
        } else {
            showFragment(fragment);
        }
    }

    private void itemsSelected() {
        if(contentLayout == null) {
            return;
        }

        final Fragment fragment = getFragmentManager().findFragmentByTag(ItemFragment.TAG);
        if (fragment == null) {
            showFragment(new ItemFragment());
        } else {
            showFragment(fragment);
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

    //endregion
}
