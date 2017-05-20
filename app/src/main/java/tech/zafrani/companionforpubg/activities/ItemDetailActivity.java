package tech.zafrani.companionforpubg.activities;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.fragments.ItemDetailsFragment;
import tech.zafrani.companionforpubg.models.Item;

import static tech.zafrani.companionforpubg.adapters.viewholders.ItemViewHolder.ARG_ITEM;

public class ItemDetailActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetails);

        Intent intent = getIntent();
        final Item item = (Item) intent.getSerializableExtra(ARG_ITEM);
        showItemDetailFragment(new ItemDetailsFragment(), item);
    }

    public void showItemDetailFragment(@NonNull final Fragment fragment,
                                       @NonNull final Item item){

    }


}
