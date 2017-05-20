package tech.zafrani.pubgapp.adapters.viewholders;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.items.WeaponItem;
import tech.zafrani.pubgapp.models.items.types.WeaponType;
import tech.zafrani.pubgapp.utils.Constants;

public class WeaponViewHolder extends BaseViewHolder<WeaponItem> {

    public static WeaponViewHolder createViewHolder(@NonNull final ViewGroup parent,
                                                    @NonNull final Listener<WeaponItem> listener) {
        return new WeaponViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_weapon, parent, false), listener);
    }

    private final Target itemImageTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            itemImage.setImageBitmap(bitmap);
            itemSpinner.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            itemSpinner.setVisibility(View.INVISIBLE);

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            itemSpinner.setVisibility(View.VISIBLE);
            itemImage.setImageBitmap(null);
        }
    };

    private final Target ammoTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            ammoImage.setImageBitmap(bitmap);
            ammoSpinner.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {
            ammoSpinner.setVisibility(View.INVISIBLE);

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {
            ammoSpinner.setVisibility(View.VISIBLE);
            ammoImage.setImageBitmap(null);
        }
    };

    private final ImageView itemImage;
    private final ImageView ammoImage;
    private final ProgressBar itemSpinner;
    private final ProgressBar ammoSpinner;
    private final TextView name;
    private final TextView type;
    private final TextView ammo;
    private final TextView damage;
    private final TextView range;
    private final TextView stability;
    private final TextView rate;

    public WeaponViewHolder(@NonNull final View itemView, @NonNull final Listener<WeaponItem> listener) {
        super(itemView, listener);
        this.itemImage = (ImageView) itemView.findViewById(R.id.viewholder_weapon_item_image);
        this.ammoImage = (ImageView) itemView.findViewById(R.id.viewholder_weapon_ammo_image);
        this.itemSpinner = (ProgressBar) itemView.findViewById(R.id.viewholder_weapon_item_image_progress);
        this.ammoSpinner = (ProgressBar) itemView.findViewById(R.id.viewholder_weapon_ammo_image_progress);
        this.name = (TextView) itemView.findViewById(R.id.viewholder_weapon_name);
        this.type = (TextView) itemView.findViewById(R.id.viewholder_weapon_type);
        this.ammo = (TextView) itemView.findViewById(R.id.viewholder_weapon_ammo);
        this.damage = (TextView) itemView.findViewById(R.id.viewholder_weapon_damage);
        this.range = (TextView) itemView.findViewById(R.id.viewholder_weapon_range);
        this.stability = (TextView) itemView.findViewById(R.id.viewholder_weapon_stability);
        this.rate = (TextView) itemView.findViewById(R.id.viewholder_weapon_rate);
    }

    @Override
    public void bind(final int position) {
        final WeaponItem weapon = get(position);

        if (weapon == null) {
            throw new IllegalStateException("invalid weapon position");
        }

        this.name.setText(weapon.getName());
        this.type.setText(weapon.getWeaponType().getStringRes());
        this.ammo.setText(this.itemView.getContext().getString(R.string.label_weapon_ammo, weapon.getAmmo()));
        this.damage.setText(this.itemView.getContext().getString(R.string.label_weapon_damage, weapon.getDamage().getChest0()));
        this.range.setText(this.itemView.getContext().getString(R.string.label_weapon_range, weapon.getRange()));
        this.stability.setText(this.itemView.getContext().getString(R.string.label_weapon_stability, weapon.getStability()));
        this.rate.setText(this.itemView.getContext().getString(R.string.label_weapon_rate, weapon.getRate()));
        this.ammoSpinner.setVisibility(View.INVISIBLE);

        if (weapon.getWeaponType() == WeaponType.Grenade) {
            this.ammo.setVisibility(View.INVISIBLE);
            this.stability.setVisibility(View.INVISIBLE);
            this.rate.setVisibility(View.INVISIBLE);
        } else {
            this.ammo.setVisibility(View.VISIBLE);
            this.stability.setVisibility(View.VISIBLE);
            this.rate.setVisibility(View.VISIBLE);
        }

        Picasso.with(itemView.getContext())
               .load(Constants.ITEM_IMAGE_URL + "/Weapons/"+ weapon.getImageUrl() + "?raw=true")
               .into(itemImageTarget);


    }
}
