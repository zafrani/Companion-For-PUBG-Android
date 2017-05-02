package zafrani.com.pubgapp.fragments;


import android.app.Fragment;
import android.support.annotation.StringRes;

public abstract class BaseFragment extends Fragment {
    @StringRes
    public abstract int getTabTitle();

}
