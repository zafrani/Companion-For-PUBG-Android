package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.BindView;
import tech.zafrani.companionforpubg.PUBGApplication;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.activities.ItemDetailActivity;
import tech.zafrani.companionforpubg.adapters.ItemRecyclerViewAdapter;
import tech.zafrani.companionforpubg.models.items.Category;
import tech.zafrani.companionforpubg.models.items.Item;

public class ItemTabFragment extends BaseFragment
        implements ItemRecyclerViewAdapter.Listener<Item> {
    private static final String ARG_CATEGORY_NAME = ItemTabFragment.class + ".ARG_CATEGORY_NAME";

    @Nullable
    @BindView(R.id.fragment_itemtab_recyclerview)
    RecyclerView recyclerView;


    public static ItemTabFragment newInstance(@NonNull final Category.Name categoryName) {
        final ItemTabFragment fragment = new ItemTabFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_CATEGORY_NAME, categoryName);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_itemtab;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle args = getArguments();
        if (args == null || !args.containsKey(ARG_CATEGORY_NAME)) {
            return;
        }
        final Category.Name categoryName = (Category.Name) args.getSerializable(ARG_CATEGORY_NAME);
        if (this.recyclerView == null || categoryName == null) {
            return;
        }
        final Category<Item> category = PUBGApplication.getInstance().getItems().getCategories().get(categoryName);
        if (category == null) {
            return;
        }
        final DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        this.recyclerView.addItemDecoration(itemDecoration);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        final ItemRecyclerViewAdapter<Item> adapter = new ItemRecyclerViewAdapter<>(category.getItems());
        adapter.setListener(this);
        this.recyclerView.setAdapter(adapter);
    }


    //region ItemRecyclerViewAdapter
    @Override
    public void onClick(@NonNull final Item item) {
        ItemDetailActivity.startActivity(getActivity(), item);
    }
    //endregion
}

