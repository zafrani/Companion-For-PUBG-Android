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
import tech.zafrani.companionforpubg.R;

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

    //endregion

    //region Methods
    @LayoutRes
    protected abstract int getLayoutRes();

    @IdRes
    protected abstract int getContentView();

    protected void showFragment(@NonNull final Fragment fragment) {
        final FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
        fragTransaction.replace(getContentView(), fragment);
        fragTransaction.commit();
        getFragmentManager().executePendingTransactions();
    }
    //endregion
}
