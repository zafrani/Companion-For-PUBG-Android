package tech.zafrani.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.adapters.ItemTabAdapter;
import tech.zafrani.pubgapp.models.Category;
import tech.zafrani.pubgapp.models.Items;
import tech.zafrani.pubgapp.utils.FileUtil;

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
        List<Category> categories = new ArrayList<>();
        try {
            final Items itemList = FileUtil.getItems(getActivity());
            categories = itemList.getCategories();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(getClass().getSimpleName(), "Error: " + e.getLocalizedMessage());
        }
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(new ItemTabAdapter(getFragmentManager(), categories));
        final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

    }


}
