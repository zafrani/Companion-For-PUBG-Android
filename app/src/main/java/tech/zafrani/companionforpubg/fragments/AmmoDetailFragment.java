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
import tech.zafrani.companionforpubg.models.items.ammo.Ammo;
import tech.zafrani.companionforpubg.utils.Constants;

public class AmmoDetailFragment extends BaseFragment {

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
    }
    //endregion

    //region Methods
    private void setNameText(@Nullable final String text) {
        if (this.nameTextView == null)

        {
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
