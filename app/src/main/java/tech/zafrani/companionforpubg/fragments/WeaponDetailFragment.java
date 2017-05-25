package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.items.weapons.Weapon;
import tech.zafrani.companionforpubg.utils.Constants;

public class WeaponDetailFragment extends BaseFragment {
    private static final String ARG_WEAPON = WeaponDetailFragment.class.getSimpleName() + ".ARG_WEAPON";

    public static WeaponDetailFragment newInstance(@NonNull final Weapon weapon) {
        final WeaponDetailFragment fragment = new WeaponDetailFragment();
        final Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_WEAPON, weapon);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_name)
    TextView nameTextView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_type)
    TextView typeTextView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_image)
    ImageView weaponImage;


    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_weapon_detail;
    }

    @Override
    public void onViewCreated(final View view,
                              @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final Bundle args = getArguments();
        if (args == null) {
            throw new IllegalStateException("Missing arguments");
        }
        final Weapon weapon = (Weapon) args.getSerializable(ARG_WEAPON);
        if (weapon == null) {
            throw new IllegalStateException("Missing Weapon");
        }
        setNameText(weapon.getName());
        setWeaponImage(weapon.getImageUrl());
        setTypeText(getString(weapon.getType().getString()));
    }

    //region Methods
    private void setNameText(@Nullable final String text) {
        if (this.nameTextView == null) {
            return;
        }
        this.nameTextView.setText(text);
    }

    private void setWeaponImage(@Nullable final String url) {
        if (this.weaponImage == null) {
            return;
        }
        Picasso.with(getActivity())
               .load(Constants.ITEM_IMAGE_URL + url)
               .into(this.weaponImage);
    }

    private void setTypeText(@Nullable final String type) {
        if (this.typeTextView == null) {
            return;
        }
        this.typeTextView.setText(type);
    }
    //endregion
}
