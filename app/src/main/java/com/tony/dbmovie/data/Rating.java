package com.tony.dbmovie.data;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dev on 2/1/18.
 */

public class Rating implements Serializable {
    @SerializedName("max")
    @Expose
    private Integer max;
    @SerializedName("average")
    @Expose
    private Double average;
    @SerializedName("details")
    @Expose
    private RatingDetail details;
    @SerializedName("stars")
    @Expose
    private String stars;
    @SerializedName("min")
    @Expose
    private Integer min;

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public RatingDetail getDetails() {
        return details;
    }

    public void setDetails(RatingDetail details) {
        this.details = details;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

}
