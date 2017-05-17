package tech.zafrani.pubgapp.activities;

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

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.fragments.ItemFragment;
import tech.zafrani.pubgapp.fragments.PUBGMapFragment;
import tech.zafrani.pubgapp.utils.Constants;

public abstract class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Nullable
    private DrawerLayout drawerLayout = null;
    @Nullable
    private NavigationView navigationView = null;
    @Nullable
    private FrameLayout contentLayout = null;

    //region Activity
    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.activity_drawer_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        this.contentLayout = (FrameLayout) findViewById(R.id.activity_drawer_content);
        this.navigationView = (NavigationView) findViewById(R.id.activity_drawer_navigationview);
        this.navigationView.setNavigationItemSelectedListener(this);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.activity_drawer_drawerlayout);
        this.navigationView.setCheckedItem(R.id.drawer_map);
        mapSelected();
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (this.drawerLayout == null) {
            return super.onOptionsItemSelected(item);
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                this.drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.navigationView = null;
        this.drawerLayout = null;
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
        if (this.contentLayout == null) {
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
        if (this.contentLayout == null) {
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

    private void showFragment(@NonNull final Fragment fragment) {
        final FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.activity_drawer_content, fragment);
        fragTransaction.commit();
        getFragmentManager().executePendingTransactions();
    }
    //endregion

}
