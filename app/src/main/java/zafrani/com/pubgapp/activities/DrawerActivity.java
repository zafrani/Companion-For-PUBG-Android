package zafrani.com.pubgapp.activities;

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

import zafrani.com.pubgapp.R;

public abstract class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Nullable
    private DrawerLayout   drawerLayout;
    @Nullable
    private NavigationView navigationView;


    //region DrawerActivity
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

        this.drawerLayout = (DrawerLayout) findViewById(R.id.activity_drawer_drawerlayout);
        this.navigationView = (NavigationView) findViewById(R.id.activity_drawer_navigationview);
        this.navigationView.setNavigationItemSelectedListener(this);
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
        return true;
    }

    //endregion

}
