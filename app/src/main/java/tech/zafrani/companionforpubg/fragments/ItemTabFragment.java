package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import tech.zafrani.companionforpubg.PUBGApplication;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.adapters.CategoryRecyclerViewAdapter;
import tech.zafrani.companionforpubg.models.Categories;
import tech.zafrani.companionforpubg.models.Category;
import tech.zafrani.companionforpubg.models.WeaponCategory;
import tech.zafrani.companionforpubg.models.WeaponItem;

public class ItemTabFragment extends BaseFragment {
    private static final String ARG_CATEGORY = ItemTabFragment.class.getSimpleName() + ".ARG_CATEGORY";
    private RecyclerView recyclerView;
    private Category category = null;

    public static ItemTabFragment newInstance(@NonNull final Category category) {
        final Bundle args = new Bundle();
        final ItemTabFragment fragment = new ItemTabFragment();

        args.putSerializable(ARG_CATEGORY, category);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null && args.containsKey(ARG_CATEGORY)) {
            this.category = (Category) args.get(ARG_CATEGORY);
        }

    }


    @Override
    public View onCreateView(final LayoutInflater inflater,
                             final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_itemtab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (category == null) {
            return;
        }
        final Categories categories = PUBGApplication.getInstance().getItems().getCategories();


        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_itemtab_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new CategoryRecyclerViewAdapter<WeaponItem, WeaponCategory>(categories.getWeaponCategory()) {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }
        });
    }
}

