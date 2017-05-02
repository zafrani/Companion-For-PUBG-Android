package zafrani.com.pubgapp.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import zafrani.com.pubgapp.R;
import zafrani.com.pubgapp.adapters.FragmentAdapter;
import zafrani.com.pubgapp.fragments.BaseFragment;
import zafrani.com.pubgapp.fragments.ItemListFragment;
import zafrani.com.pubgapp.fragments.ItemViewFragment;
import zafrani.com.pubgapp.fragments.MapFragment;

public abstract class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
                   TabLayout.OnTabSelectedListener {

    @Nullable
    private DrawerLayout drawerLayout = null;
    @Nullable
    private NavigationView navigationView = null;
    @Nullable
    private ViewPager viewPager = null;
    @Nullable
    private TabLayout tabLayout = null;

    //region Activity
    @Override
    protected final void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        //Set up action bar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.activity_drawer_toolbar);
        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        // Set up Navigation
        this.navigationView = (NavigationView) findViewById(R.id.activity_drawer_navigationview);
        this.navigationView.setNavigationItemSelectedListener(this);

        this.drawerLayout = (DrawerLayout) findViewById(R.id.activity_drawer_drawerlayout);
        this.viewPager = (ViewPager) findViewById(R.id.activity_drawer_viewpager);
        this.tabLayout = (TabLayout) findViewById(R.id.activity_drawer_tablayout);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.tabLayout.addOnTabSelectedListener(this);
        itemsSelected();
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
        if (this.navigationView != null) {
            this.navigationView.setNavigationItemSelectedListener(null);
            this.navigationView = null;
        }
        if (this.viewPager != null) {
            this.viewPager.setAdapter(null);
            this.viewPager = null;
        }
        if (this.tabLayout != null) {
            this.tabLayout.removeOnTabSelectedListener(this);
            this.tabLayout.removeAllTabs();
            this.tabLayout = null;
        }
        this.drawerLayout = null;
        super.onDestroy();
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
                this.mapSelected();
                break;
            case R.id.drawer_items:
                this.itemsSelected();
                break;
        }
        return true;
    }
    //endregion

    //region TabLayout.OnTabSelectedListener
    @Override
    public void onTabSelected(final TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(final TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(final TabLayout.Tab tab) {

    }
    //endregion

    //region methods
    public void mapSelected() {
        if (this.viewPager == null || this.tabLayout == null) {
            return;
        }
        this.tabLayout.setVisibility(View.GONE);
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new MapFragment());
        //todo don't recreate this each tab press
        this.viewPager.removeAllViews();
        this.viewPager.removeAllViewsInLayout();
        this.viewPager.setAdapter(new FragmentAdapter(getFragmentManager(), this, fragments));

    }

    public void itemsSelected() {
        if (this.viewPager == null || this.tabLayout == null) {
            return;
        }
        this.tabLayout.removeAllTabs();
        List<BaseFragment> fragments = new ArrayList<>();
        fragments.add(new ItemListFragment());
        fragments.add(new ItemViewFragment());
        //todo don't recreate this each tab press
        this.viewPager.removeAllViews();
        this.viewPager.removeAllViewsInLayout();
        this.viewPager.setAdapter(new FragmentAdapter(getFragmentManager(), this, fragments));
        this.tabLayout.setVisibility(View.VISIBLE);

    }
    //endregion

}
