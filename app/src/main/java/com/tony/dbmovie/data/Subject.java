package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bushi on 2018/3/25.
 */

public class Subject implements Serializable {
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("casts")
    @Expose
    private List<Cast> casts = null;
    @SerializedName("durations")
    @Expose
    private List<String> durations = null;
    @SerializedName("collect_count")
    @Expose
    private Integer collectCount;
    @SerializedName("mainland_pubdate")
    @Expose
    private String mainlandPubdate;
    @SerializedName("has_video")
    @Expose
    private Boolean hasVideo;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("directors")
    @Expose
    private List<Director> directors = null;
    @SerializedName("pubdates")
    @Expose
    private List<String> pubdates = null;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("images")
    @Expose
    private ImagesPoster images;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("id")
    @Expose
    private String id;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public String getMainlandPubdate() {
        return mainlandPubdate;
    }

    public void setMainlandPubdate(String mainlandPubdate) {
        this.mainlandPubdate = mainlandPubdate;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<Director> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Director> directors) {
        this.directors = directors;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesPoster getImages() {
        return images;
    }

    public void setImages(ImagesPoster images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "rating=" + rating +
                ", genres=" + genres +
                ", title='" + title + '\'' +
                ", casts=" + casts +
                ", durations=" + durations +
                ", collectCount=" + collectCount +
                ", mainlandPubdate='" + mainlandPubdate + '\'' +
                ", hasVideo=" + hasVideo +
                ", originalTitle='" + originalTitle + '\'' +
                ", subtype='" + subtype + '\'' +
                ", directors=" + directors +
                ", pubdates=" + pubdates +
                ", year='" + year + '\'' +
                ", images=" + images +
                ", alt='" + alt + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
