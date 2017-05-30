package tech.zafrani.companionforpubg.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.View;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.ViewPagerAdapter;
import tech.zafrani.companionforpubg.models.items.Category;

public class ItemFragment extends BaseFragment
        implements ViewPagerAdapter.Listener {

    public static final String TAG = ItemFragment.class.getSimpleName();

    @Nullable
    @BindView(R.id.fragment_item_viewpager)
    ViewPager viewPager;

    @Nullable
    @BindView(R.id.fragment_item_tablayout)
    TabLayout tabLayout;

    private final int tabCount = Category.Name.values().length;

    //region BaseFragment
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_item;
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpTabs();
        showDisclaimerForFirstTime();
    }

    @Override
    public void onDestroy() {

        if (this.viewPager != null) {
            this.viewPager.setAdapter(null);
        }

        if (this.tabLayout != null) {
            this.tabLayout.removeAllTabs();
        }

        super.onDestroy();
    }
    //endregion

    //region ViewPagerAdapter.Listener

    @Override
    public int getCount() {
        return this.tabCount;
    }

    @Override
    public Fragment getItem(final int position) {
        return ItemTabFragment.newInstance(Category.Name.values()[position]);
    }

    @Override
    public String getPageTitle(final int position) {
        return Category.Name.values()[position].getValue();
    }

    //endregion

    //region Methods
    private void setUpTabs() {
        if (this.tabLayout == null || this.viewPager == null) {
            return;
        }
        for (int i = 0; i < tabCount; i++) {
            final TabLayout.Tab tab = this.tabLayout.newTab();
            tab.setText(Category.Name.values()[i].getValue());
            this.tabLayout.addTab(tab);
        }
        this.tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager(), this));
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
    //endregion
}
