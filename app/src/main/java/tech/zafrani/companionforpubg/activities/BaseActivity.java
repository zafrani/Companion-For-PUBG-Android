package tech.zafrani.companionforpubg.activities;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {

    @NonNull
    private Unbinder unbinder = Unbinder.EMPTY;

    @CallSuper
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        unbinder = ButterKnife.bind(this);
    }

    @LayoutRes
    protected abstract int getLayoutRes();

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
