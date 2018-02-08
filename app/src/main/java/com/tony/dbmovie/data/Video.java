package com.tony.dbmovie.data;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Created by dev on 2/7/18.
 */

public class Video {
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("sample_link")
    @Expose
    private String sampleLink;
    @SerializedName("video_id")
    @Expose
    private String videoId;
    @SerializedName("need_pay")
    @Expose
    private Boolean needPay;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public String getSampleLink() {
        return sampleLink;
    }

    public void setSampleLink(String sampleLink) {
        this.sampleLink = sampleLink;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public Boolean getNeedPay() {
        return needPay;
    }

    public void setNeedPay(Boolean needPay) {
        this.needPay = needPay;
    }
}
