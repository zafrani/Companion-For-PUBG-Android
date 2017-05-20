package tech.zafrani.pubgapp.models.items;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Damage implements Serializable {

    @SerializedName("base")
    private final int base;

    @SerializedName("chest0")
    private final int chest0;

    @SerializedName("chest1")
    private final int chest1;

    @SerializedName("chest2")
    private final int chest2;

    @SerializedName("chest3")
    private final int chest3;

    @SerializedName("head0")
    private final int head0;

    @SerializedName("head1")
    private final int head1;

    @SerializedName("head2")
    private final int head2;

    @SerializedName("head3")
    private final int head3;

    public Damage(final int base,
                  final int chest0,
                  final int chest1,
                  final int chest2,
                  final int chest3,
                  final int head0,
                  final int head1,
                  final int head2,
                  final int head3) {
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

    public int getBase() {
        return base;
    }

    public int getChest0() {
        return chest0;
    }

    public int getChest1() {
        return chest1;
    }

    public int getChest2() {
        return chest2;
    }

    public int getChest3() {
        return chest3;
    }

    public int getHead0() {
        return head0;
    }

    public int getHead1() {
        return head1;
    }

    public int getHead2() {
        return head2;
    }

    public int getHead3() {
        return head3;
    }
}
