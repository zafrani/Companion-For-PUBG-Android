package tech.zafrani.pubgapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.items.Items;
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
        try {
            final Items categories = FileUtil.getItems(getActivity());
            Log.e("Items", categories.toString());
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(getClass().getSimpleName(), "Error: " + e.getLocalizedMessage());
        }
        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.fragment_item_viewpager);
        //viewPager.setAdapter(new ItemTabAdapter(getChildFragmentManager(), categories));
       // final TabLayout tabLayout = (TabLayout) view.findViewById(R.id.fragment_item_tablayout);
       // tabLayout.setupWithViewPager(viewPager);




    }


}
