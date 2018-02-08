package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dev on 2/7/18.
 */

public class PopularReview {
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subject_id")
    @Expose
    private String subjectId;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("summary")
    @Expose
    private String summary;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
}
