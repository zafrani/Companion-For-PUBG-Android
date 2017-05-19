package tech.zafrani.pubgapp.adapters.viewholders;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import tech.zafrani.pubgapp.R;
import tech.zafrani.pubgapp.models.Item;

public class WeaponViewHolder2 extends ItemViewHolder2 {

    public static WeaponViewHolder2 createViewHolder(@NonNull final ViewGroup parent,
                                                     @NonNull final Listener<Item> listener) {
        return new WeaponViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_weapon, parent, false), listener);
    }

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

    public WeaponViewHolder2(@NonNull final View itemView, @NonNull final Listener<Item> listener) {
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
    public void bind(int position) {
        final Item item = get(position);

        if (item == null) {
            throw new IllegalStateException("invalid item position");
        }
        this.name.setText(item.getName());
        this.type.setText(item.getType());
        this.ammo.setText(item.getAmmo());
//        this.damage.setText(itemView.getContext().getString(R.string.label_weapon_damage, item.getDamage().getChest0()));


    }
}
