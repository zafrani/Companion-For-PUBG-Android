package tech.zafrani.companionforpubg.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.zafrani.companionforpubg.R;

public class ItemFragment extends BaseFragment {

    public static String TAG = ItemFragment.class.getSimpleName();
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);




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
