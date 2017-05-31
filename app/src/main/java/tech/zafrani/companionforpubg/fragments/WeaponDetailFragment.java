package tech.zafrani.companionforpubg.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import tech.zafrani.companionforpubg.PUBGApplication;
import tech.zafrani.companionforpubg.R;
import tech.zafrani.companionforpubg.activities.ItemDetailActivity;
import tech.zafrani.companionforpubg.models.items.ammo.Ammo;
import tech.zafrani.companionforpubg.models.items.weapons.ProjectileWeapon;
import tech.zafrani.companionforpubg.models.items.weapons.Weapon;
import tech.zafrani.companionforpubg.utils.Constants;
import tech.zafrani.companionforpubg.widgets.BarValueView;
import tech.zafrani.companionforpubg.widgets.ItemPickerView;

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

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_ammo_content)
    LinearLayout ammoContent;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_damage_bar_value)
    BarValueView damageBarValueView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_range_bar_value)
    BarValueView rangeBarValueView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_stability_bar_value)
    BarValueView stabilityBarValueView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_rate_bar_value)
    BarValueView rateBarValueView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_magazine_bar_value)
    BarValueView magazineBarValueView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_magazine_item_picker)
    ItemPickerView magazinePickerView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_muzzle_item_picker)
    ItemPickerView muzzlePickerView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_grip_item_picker)
    ItemPickerView gripPickerView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_sight_item_picker)
    ItemPickerView sightPickerView;

    @Nullable
    @BindView(R.id.fragment_weapon_detail_weapon_stock_item_picker)
    ItemPickerView stockPickerView;

    //region BaseFragment

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
            final ProjectileWeapon projectileWeapon = ((ProjectileWeapon) weapon);
            final Ammo ammo = PUBGApplication.getInstance().getItems().getCategories().getAmmoCategory().getAmmoWithId((projectileWeapon.getAmmoId()));
            if (ammo == null) {
                return;
            }
            setAmmoImageView(ammo.getImageUrl());
            setAmmoTextView(ammo.getName());
            setBarValue(this.damageBarValueView, R.string.row_item_damage, projectileWeapon.getDamage().getChest0());
            setBarValue(this.rangeBarValueView, R.string.row_item_range, projectileWeapon.getRange());
            setBarValue(this.stabilityBarValueView, R.string.row_item_stability, projectileWeapon.getStability());
            setBarValue(this.rateBarValueView, R.string.row_item_rate, projectileWeapon.getRate());
            setBarValue(this.magazineBarValueView, R.string.row_item_magazine, projectileWeapon.getMagazineSize());
            setAmmoClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ItemDetailActivity.startActivity(getActivity(), ammo);
                }
            });

        }
    }
    //endregion

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

    private void setAmmoClickListener(@Nullable final View.OnClickListener onClickListener) {
        if (this.ammoContent == null) {
            return;
        }
        this.ammoContent.setOnClickListener(onClickListener);
    }

    private void setBarValue(@Nullable final BarValueView barValue,
                             @StringRes final int text,
                             final int value) {
        if (barValue == null) {
            return;
        }
        barValue.setVisibility(View.VISIBLE);
        barValue.setValue(text, value);
    }

    private void setMagazinePickerView(@Nullable final int[] magazineIds) {
        if (this.magazinePickerView == null || magazineIds == null) {
            return;
        }
        this.magazinePickerView.setVisibility(View.VISIBLE);
    }

    //endregion
}
