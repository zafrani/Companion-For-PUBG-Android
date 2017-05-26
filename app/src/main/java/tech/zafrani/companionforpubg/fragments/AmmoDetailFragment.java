package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


import butterknife.BindView;
import tech.zafrani.companionforpubg.PUBGApplication;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.activities.ItemDetailActivity;
import tech.zafrani.companionforpubg.adapters.ItemRecyclerViewAdapter;
import tech.zafrani.companionforpubg.adapters.RecyclerViewAdapter;
import tech.zafrani.companionforpubg.models.items.ammo.Ammo;
import tech.zafrani.companionforpubg.models.items.weapons.Weapon;
import tech.zafrani.companionforpubg.models.items.weapons.WeaponList;
import tech.zafrani.companionforpubg.utils.Constants;

public class AmmoDetailFragment extends BaseFragment
        implements RecyclerViewAdapter.Listener<Weapon>

{

    private static final String ARG_AMMO = AmmoDetailFragment.class.getSimpleName() + ".ARG_AMMO";

    public static AmmoDetailFragment newInstance(@NonNull final Ammo ammo) {
        final AmmoDetailFragment fragment = new AmmoDetailFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_AMMO, ammo);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Nullable
    @BindView(R.id.fragment_ammo_detail_ammo_name)
    TextView nameTextView;

    @Nullable
    @BindView(R.id.fragment_ammo_detail_ammo_image)
    ImageView ammoImageView;

    @Nullable
    @BindView(R.id.fragment_ammo_detail_weapons)
    RecyclerView weaponsRecycler;

    //region BaseFragment
    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_ammo_detail;
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle args = getArguments();
        if (args == null) {
            throw new IllegalStateException("Missing arguments");
        }
        final Ammo ammo = (Ammo) args.getSerializable(ARG_AMMO);
        if (ammo == null) {
            throw new IllegalStateException("Missing Ammo");
        }
        setNameText(ammo.getName());
        setAmmoImageView(ammo.getImageUrl());
        if (this.weaponsRecycler != null) {
            final WeaponList weapons = PUBGApplication.getInstance().getItems().getCategories().getWeaponCategory().getWeaponsUsingAmmo(ammo.getId());
            ItemRecyclerViewAdapter<Weapon> adapter = new ItemRecyclerViewAdapter<>((weapons));
            adapter.setListener(this);
            final DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
            this.weaponsRecycler.addItemDecoration(itemDecoration);
            this.weaponsRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));

            this.weaponsRecycler.setAdapter(adapter);
        }

    }
    //endregion

    //region RecyclerViewAdapter.Listener<Weapon>
    @Override
    public void onClick(@NonNull final Weapon weapon) {
        ItemDetailActivity.startActivity(getActivity(), weapon);
    }
    //endregion

    //region Methods
    private void setNameText(@Nullable final String text) {
        if (this.nameTextView == null) {
            return;
        }
        this.nameTextView.setText(text);
    }

    private void setAmmoImageView(@Nullable final String url) {
        if (this.ammoImageView == null) {
            return;
        }
        Picasso.with(getActivity())
               .load(Constants.ITEM_IMAGE_URL + url)
               .into(this.ammoImageView);
    }


    //endregion
}
