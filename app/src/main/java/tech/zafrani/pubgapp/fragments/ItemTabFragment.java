package tech.zafrani.pubgapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.zafrani.pubgapp.R;

public class ItemTabFragment extends BaseFragment{
    public static final String ARG_PAGE = "ARG_PAGE";
    private int page;

    public static ItemTabFragment newInstance(@NonNull final int page) {
        final Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        final ItemTabFragment fragment = new ItemTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public void onCreate(@NonNull final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_PAGE);
    }

    @NonNull
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater,
                             @NonNull final ViewGroup container,
                             @NonNull final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_itemtab, container, false);
        return view;
    }
}

