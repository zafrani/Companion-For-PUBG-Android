package tech.zafrani.companionforpubg.activities;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import tech.zafrani.companionforpubg.R;
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


    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = getIntent();
        if (intent == null) {
            throw new IllegalStateException("Missing intent");
        }
        final Item item = (Item) intent.getSerializableExtra(EXTRA_ITEM);
        if (item instanceof Weapon) {
            showFragment(WeaponDetailFragment.newInstance((Weapon) item));
        } else if (item instanceof Ammo) {

        } else {
            throw new IllegalStateException("Unknown item");
        }
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_itemdetails;
    }

    @Override
    protected int getContentView() {
        return R.id.activity_itemdetails_content;
    }
}
