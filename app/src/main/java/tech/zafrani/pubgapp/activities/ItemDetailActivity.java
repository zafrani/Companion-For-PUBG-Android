package tech.zafrani.pubgapp.activities;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;


public class ItemDetailActivity extends AppCompatActivity {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemdetails);
    }

    public void showItemDetailFragment(@NonNull final Fragment fragment,
                                       @NonNull final Item item){

    }


}
