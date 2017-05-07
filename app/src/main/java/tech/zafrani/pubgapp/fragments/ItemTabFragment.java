package tech.zafrani.pubgapp.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tech.zafrani.pubgapp.R;

public class ItemTabFragment  extends BaseFragment{

    public static final String ARG_PAGE = "ARG_PAGE";

    private int page;

    public static ItemTabFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ItemTabFragment fragment = new ItemTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_itemtab, container, false);
        TextView textView = (TextView) view;
        textView.setText("Fragment #" + page);
        return view;
    }
}

