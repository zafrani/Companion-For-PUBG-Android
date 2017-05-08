package tech.zafrani.pubgapp.models;


import com.google.gson.annotations.SerializedName;

public class Damage {
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
    private final float body0;
    @SerializedName("body1")
    private final float body1;
    @SerializedName("body2")
    private final float body2;
    @SerializedName("body3")
    private final float body3;

    public Damage(final float base,
                  final float chest0,
                  final float chest1,
                  final float chest2,
                  final float chest3,
                  final float body0,
                  final float body1,
                  final float body2,
                  final float body3) {
        this.base = base;
        this.chest0 = chest0;
        this.chest1 = chest1;
        this.chest2 = chest2;
        this.chest3 = chest3;
        this.body0 = body0;
        this.body1 = body1;
        this.body2 = body2;
        this.body3 = body3;
    }

    public float getBase() {
        return base;
    }

    public float getChest0() {
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

    public float getBody0() {
        return body0;
    }

    public float getBody1() {
        return body1;
    }

    public float getBody2() {
        return body2;
    }

    public float getBody3() {
        return body3;
    }
}
