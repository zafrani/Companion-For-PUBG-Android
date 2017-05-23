package tech.zafrani.companionforpubg.activities;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import tech.zafrani.companionforpubg.R;

public class ItemDetailActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
    }

    public void showItemDetailFragment(@NonNull final Fragment fragment){

    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_itemdetails;
    }
}
