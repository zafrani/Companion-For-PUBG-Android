package tech.zafrani.companionforpubg.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.fragments.AmmoDetailFragment;
import tech.zafrani.companionforpubg.fragments.WeaponDetailFragment;
import tech.zafrani.companionforpubg.models.items.Item;
import tech.zafrani.companionforpubg.models.items.ammo.Ammo;
import tech.zafrani.companionforpubg.models.items.weapons.Weapon;

public class ItemDetailActivity extends BaseActivity {
    private static final String EXTRA_ITEM = ItemDetailActivity.class.getSimpleName() + ".EXTRA_ITEM";

    public static void startActivity(@NonNull final Context context,
                                     @NonNull final Item item) {
        final Intent intent = new Intent(context, ItemDetailActivity.class);
        intent.putExtra(EXTRA_ITEM, item);
        context.startActivity(intent);
    }

    @Nullable
    @BindView(R.id.activity_itemdetails_toolbar)
    Toolbar toolbar;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
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
        final Item item = (Item) intent.getSerializableExtra(EXTRA_ITEM);
        if (item instanceof Weapon) {
            showFragment(WeaponDetailFragment.newInstance((Weapon) item));
        } else if (item instanceof Ammo) {
            showFragment(AmmoDetailFragment.newInstance((Ammo) item));
        } else {
            Toast.makeText(this, "We're still working on this feature!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @LayoutRes
    @Override
    protected int getLayoutRes() {
        return R.layout.activity_itemdetails;
    }

    @IdRes
    @Override
    protected int getContentView() {
        return R.id.activity_itemdetails_content;
    }
}
