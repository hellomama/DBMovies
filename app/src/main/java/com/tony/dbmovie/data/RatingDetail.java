package com.tony.dbmovie.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dev on 2/1/18.
 */

public class RatingDetail implements Serializable {
    @SerializedName("1")
    @Expose
    private Double _1;
    @SerializedName("3")
    @Expose
    private Double _3;
    @SerializedName("2")
    @Expose
    private Double _2;
    @SerializedName("5")
    @Expose
    private Double _5;
    @SerializedName("4")
    @Expose
    private Double _4;

    public Double get1() {
        return _1;
    }

    public void set1(Double _1) {
        this._1 = _1;
    }

    public Double get3() {
        return _3;
    }

    public void set3(Double _3) {
        this._3 = _3;
    }

    public Double get2() {
        return _2;
    }

    public void set2(Double _2) {
        this._2 = _2;
    }

    public Double get5() {
        return _5;
    }

    public void set5(Double _5) {
        this._5 = _5;
    }

    public Double get4() {
        return _4;
    }

    public void set4(Double _4) {
        this._4 = _4;
    }

    public Double getTotal()
    {
        return get1()+get2()+get3()+get4()+get5();
    }
}
