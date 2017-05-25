package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import tech.zafrani.companionforpubg.PUBGApplication;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.models.items.Category;
import tech.zafrani.companionforpubg.models.items.ammo.Ammo;
import tech.zafrani.companionforpubg.models.items.weapons.ProjectileWeapon;
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
    ImageView weaponImageView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_ammo_text)
    TextView ammoTextView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_ammo_image)
    ImageView ammoImageView;


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
        setWeaponImageView(weapon.getImageUrl());
        setTypeText(getString(weapon.getType().getString()));
        if (weapon instanceof ProjectileWeapon) {
            final Ammo ammo = PUBGApplication.getInstance().getItems().getCategories().getAmmoCategory().getAmmoWithId(((ProjectileWeapon) weapon).getAmmoId());
            if (ammo == null) {
                return;
            }
            setAmmoImageView(ammo.getImageUrl());
            setAmmoTextView(ammo.getName());
        }
    }

    //region Methods
    private void setNameText(@Nullable final String text) {
        if (this.nameTextView == null) {
            return;
        }
        this.nameTextView.setText(text);
    }

    private void setWeaponImageView(@Nullable final String url) {
        if (this.weaponImageView == null) {
            return;
        }
        Picasso.with(getActivity())
               .load(Constants.ITEM_IMAGE_URL + url)
               .into(this.weaponImageView);
    }

    private void setTypeText(@Nullable final String text) {
        if (this.typeTextView == null) {
            return;
        }
        this.typeTextView.setText(text);
    }

    private void setAmmoImageView(@Nullable final String url) {
        if (this.ammoImageView == null) {
            return;
        }
        Picasso.with(getActivity())
               .load(Constants.ITEM_IMAGE_URL + url)
               .into(this.ammoImageView);
    }

    private void setAmmoTextView(@Nullable final String text) {
        if (this.ammoTextView == null) {
            return;
        }
        this.ammoTextView.setText(text);
    }
    //endregion
}
