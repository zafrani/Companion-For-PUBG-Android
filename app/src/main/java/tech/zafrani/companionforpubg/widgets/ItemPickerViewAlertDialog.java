package tech.zafrani.companionforpubg.widgets;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import tech.zafrani.companionforpubg.R;

public class ItemPickerViewAlertDialog extends AlertDialog {
    protected ItemPickerViewAlertDialog(@NonNull final Context context,
                                        @NonNull final ViewGroup parent) {
        this(context, 0, parent);
    }

    protected ItemPickerViewAlertDialog(@NonNull final Context context,
                                        @StyleRes final int themeResId,
                                        @NonNull final ViewGroup parent) {
        super(context, themeResId);
        setView(LayoutInflater.from(context).inflate(R.layout.alert_dialog_item_picker_view, parent, false));
    }

    protected ItemPickerViewAlertDialog(@NonNull final Context context,
                                        final boolean cancelable,
                                        @Nullable final OnCancelListener cancelListener,
                                        @NonNull final ViewGroup parent) {
        super(context, cancelable, cancelListener);
        setView(LayoutInflater.from(context).inflate(R.layout.alert_dialog_item_picker_view, parent, false));
    }
}
