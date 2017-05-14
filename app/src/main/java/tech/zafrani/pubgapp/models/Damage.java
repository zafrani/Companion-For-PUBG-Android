package tech.zafrani.pubgapp.models;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Damage implements Serializable{
    @SerializedName("base")
    private final float base;
    @SerializedName("chest0")
    private final float chest0;
    @SerializedName("chest1")
    private final float chest1;
    @SerializedName("chest2")
    private final float chest2;
    @SerializedName("chest3")
    private final float chest3;
    @SerializedName("body0")
    private final float head0;
    @SerializedName("body1")
    private final float head1;
    @SerializedName("body2")
    private final float head2;
    @SerializedName("body3")
    private final float head3;

    public Damage(final float base,
                  final float chest0,
                  final float chest1,
                  final float chest2,
                  final float chest3,
                  final float head0,
                  final float head1,
                  final float head2,
                  final float head3) {
        this.base = base;
        this.chest0 = chest0;
        this.chest1 = chest1;
        this.chest2 = chest2;
        this.chest3 = chest3;
        this.head0 = head0;
        this.head1 = head1;
        this.head2 = head2;
        this.head3 = head3;
    }

    public float getBase() {
        return base;
    }

    public float  getChest0() {
        return chest0;
    }

    public float getChest1() {
        return chest1;
    }

    public float getChest2() {
        return chest2;
    }

    public float getChest3() {
        return chest3;
    }

    public float getHead0() {
        return head0;
    }

    public float getHead1() {
        return head1;
    }

    public float getHead2() {
        return head2;
    }

    public float getHead3() {
        return head3;
    }
}
