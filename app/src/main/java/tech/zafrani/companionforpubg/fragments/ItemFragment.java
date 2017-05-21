package tech.zafrani.companionforpubg.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;

import butterknife.BindView;
import tech.zafrani.companionforpubg.PUBGApplication;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.ItemTabAdapter;

public class ItemFragment extends BaseFragment {

    public static String TAG = ItemFragment.class.getSimpleName();

    @BindView(R.id.fragment_item_viewpager)
    ViewPager viewPager;

    @BindView(R.id.fragment_item_tablayout)
    TabLayout tabLayout;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_item;
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(getClass().getSimpleName(), PUBGApplication.getInstance().getItems().toString());
        viewPager.setAdapter(new ItemTabAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
        showDisclaimerForFirstTime();
    }

    //todo remove this after data is updated
    private void showDisclaimerForFirstTime() {
        final SharedPreferences preferences = getActivity().getSharedPreferences("temp", Context.MODE_PRIVATE);
        final String hasShown = "hasShown";
        if (preferences.getBoolean(hasShown, false)) {
            return;
        }

        AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                .setTitle("This is still in beta!")
                .setMessage("Data is not yet finished nor complete. Please help us via Github. Links available in the drawer.")
                .setPositiveButton("Ok no problem!", null)
                .show();
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                preferences.edit().putBoolean(hasShown, true).apply();
            }
        });
    }
}
