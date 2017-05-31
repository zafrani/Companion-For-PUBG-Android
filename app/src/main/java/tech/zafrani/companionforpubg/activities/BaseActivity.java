package tech.zafrani.companionforpubg.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    @NonNull
    private Unbinder unbinder = Unbinder.EMPTY;

    //region AppCompatActivity
    @CallSuper
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        unbinder = ButterKnife.bind(this);
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @CallSuper
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getTopFragment() == null) {
            finish();
        }
    }
//endregion

    //region Methods
    @LayoutRes
    protected abstract int getLayoutRes();

    @IdRes
    protected abstract int getContentView();


    protected void showFragment(@NonNull final Fragment fragment,
                                @NonNull final String tag) {
        showFragment(fragment, getContentView(), tag);

    }

    public void showFragment(@NonNull final Fragment fragment,
                             @IdRes final int contentView,
                             @NonNull final String tag) {
        final FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        final Fragment topFragment = getTopFragment();
        if (topFragment == null) {
            fragTransaction.add(contentView, fragment, tag);
        } else {
            fragTransaction.replace(contentView, fragment, tag);
        }
        fragTransaction.commit();
        getFragmentManager().executePendingTransactions();
    }

    @Nullable
    private Fragment getTopFragment() {
        return getFragmentManager().findFragmentById(getContentView());
    }
    //endregion
}
