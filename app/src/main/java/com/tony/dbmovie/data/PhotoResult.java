package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dev on 3/29/18.
 */

public class PhotoResult implements Serializable{
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("celebrity")
    @Expose
    private Celebrity celebrity;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("start")
    @Expose
    private Integer start;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public Celebrity getCelebrity() {
        return celebrity;
    }

    public void setCelebrity(Celebrity celebrity) {
        this.celebrity = celebrity;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "PhotoResult{" +
                "count=" + count +
                ", photos=" + photos +
                ", celebrity=" + celebrity +
                ", total=" + total +
                ", start=" + start +
                '}';
    }
}
