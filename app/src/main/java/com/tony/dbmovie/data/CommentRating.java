package com.tony.dbmovie.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dev on 2/8/18.
 */

public class CommentRating {
    @SerializedName("max")
    @Expose
    private Integer max;
    @SerializedName("value")
    @Expose
    private Double value;
    @SerializedName("min")
    @Expose
    private Integer min;

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }
}
