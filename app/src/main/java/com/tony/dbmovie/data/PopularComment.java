package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dev on 2/7/18.
 */

public class PopularComment {
    @SerializedName("rating")
    @Expose
    private CommentRating rating;
    @SerializedName("useful_count")
    @Expose
    private Integer usefulCount;
    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("subject_id")
    @Expose
    private String subjectId;
    @SerializedName("content")
    @Expose
    private String content;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private String id;

    public CommentRating getRating() {
        return rating;
    }

    public void setRating(CommentRating rating) {
        this.rating = rating;
    }

    public Integer getUsefulCount() {
        return usefulCount;
    }

    public void setUsefulCount(Integer usefulCount) {
        this.usefulCount = usefulCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PopularComment{" +
                "rating=" + rating +
                ", usefulCount=" + usefulCount +
                ", author=" + author +
                ", subjectId='" + subjectId + '\'' +
                ", content='" + content + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
