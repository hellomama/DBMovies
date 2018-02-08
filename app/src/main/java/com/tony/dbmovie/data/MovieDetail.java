package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by dev on 2/7/18.
 */

public class MovieDetail {
    @SerializedName("rating")
    @Expose
    private Rating rating;
    @SerializedName("reviews_count")
    @Expose
    private Integer reviewsCount;
    @SerializedName("videos")
    @Expose
    private List<Video> videos = null;
    @SerializedName("wish_count")
    @Expose
    private Integer wishCount;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("blooper_urls")
    @Expose
    private List<Object> blooperUrls = null;
    @SerializedName("collect_count")
    @Expose
    private Integer collectCount;
    @SerializedName("images")
    @Expose
    private ImagesPoster images;
    @SerializedName("douban_site")
    @Expose
    private String doubanSite;
    @SerializedName("year")
    @Expose
    private String year;
    @SerializedName("popular_comments")
    @Expose
    private List<PopularComment> popularComments = null;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("mobile_url")
    @Expose
    private String mobileUrl;
    @SerializedName("photos_count")
    @Expose
    private Integer photosCount;
    @SerializedName("pubdate")
    @Expose
    private String pubdate;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("do_count")
    @Expose
    private Object doCount;
    @SerializedName("has_video")
    @Expose
    private Boolean hasVideo;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("seasons_count")
    @Expose
    private Object seasonsCount;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("schedule_url")
    @Expose
    private String scheduleUrl;
    @SerializedName("writers")
    @Expose
    private List<Writer> writers = null;
    @SerializedName("pubdates")
    @Expose
    private List<String> pubdates = null;
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("has_schedule")
    @Expose
    private Boolean hasSchedule;
    @SerializedName("durations")
    @Expose
    private List<String> durations = null;
    @SerializedName("genres")
    @Expose
    private List<String> genres = null;
    @SerializedName("collection")
    @Expose
    private Object collection;
    @SerializedName("trailers")
    @Expose
    private List<Trailer> trailers = null;
    @SerializedName("episodes_count")
    @Expose
    private Object episodesCount;
    @SerializedName("trailer_urls")
    @Expose
    private List<String> trailerUrls = null;
    @SerializedName("has_ticket")
    @Expose
    private Boolean hasTicket;
    @SerializedName("bloopers")
    @Expose
    private List<Object> bloopers = null;
    @SerializedName("clip_urls")
    @Expose
    private List<Object> clipUrls = null;
    @SerializedName("current_season")
    @Expose
    private Object currentSeason;
    @SerializedName("casts")
    @Expose
    private List<Cast> casts = null;
    @SerializedName("countries")
    @Expose
    private List<String> countries = null;
    @SerializedName("mainland_pubdate")
    @Expose
    private String mainlandPubdate;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("clips")
    @Expose
    private List<Object> clips = null;
    @SerializedName("subtype")
    @Expose
    private String subtype;
    @SerializedName("directors")
    @Expose
    private List<Director> directors = null;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("popular_reviews")
    @Expose
    private List<PopularReview> popularReviews = null;
    @SerializedName("ratings_count")
    @Expose
    private Integer ratingsCount;
    @SerializedName("aka")
    @Expose
    private List<String> aka = null;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Integer getReviewsCount() {
        return reviewsCount;
    }

    public void setReviewsCount(Integer reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public Integer getWishCount() {
        return wishCount;
    }

    public void setWishCount(Integer wishCount) {
        this.wishCount = wishCount;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public List<Object> getBlooperUrls() {
        return blooperUrls;
    }

    public void setBlooperUrls(List<Object> blooperUrls) {
        this.blooperUrls = blooperUrls;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public ImagesPoster getImages() {
        return images;
    }

    public void setImages(ImagesPoster images) {
        this.images = images;
    }

    public String getDoubanSite() {
        return doubanSite;
    }

    public void setDoubanSite(String doubanSite) {
        this.doubanSite = doubanSite;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<PopularComment> getPopularComments() {
        return popularComments;
    }

    public void setPopularComments(List<PopularComment> popularComments) {
        this.popularComments = popularComments;
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

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public Integer getPhotosCount() {
        return photosCount;
    }

    public void setPhotosCount(Integer photosCount) {
        this.photosCount = photosCount;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getDoCount() {
        return doCount;
    }

    public void setDoCount(Object doCount) {
        this.doCount = doCount;
    }

    public Boolean getHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(Boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public Object getSeasonsCount() {
        return seasonsCount;
    }

    public void setSeasonsCount(Object seasonsCount) {
        this.seasonsCount = seasonsCount;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getScheduleUrl() {
        return scheduleUrl;
    }

    public void setScheduleUrl(String scheduleUrl) {
        this.scheduleUrl = scheduleUrl;
    }

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

    public List<String> getPubdates() {
        return pubdates;
    }

    public void setPubdates(List<String> pubdates) {
        this.pubdates = pubdates;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Boolean getHasSchedule() {
        return hasSchedule;
    }

    public void setHasSchedule(Boolean hasSchedule) {
        this.hasSchedule = hasSchedule;
    }

    public List<String> getDurations() {
        return durations;
    }

    public void setDurations(List<String> durations) {
        this.durations = durations;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public Object getCollection() {
        return collection;
    }

    public void setCollection(Object collection) {
        this.collection = collection;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public Object getEpisodesCount() {
        return episodesCount;
    }

    public void setEpisodesCount(Object episodesCount) {
        this.episodesCount = episodesCount;
    }

    public List<String> getTrailerUrls() {
        return trailerUrls;
    }

    public void setTrailerUrls(List<String> trailerUrls) {
        this.trailerUrls = trailerUrls;
    }

    public Boolean getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(Boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public List<Object> getBloopers() {
        return bloopers;
    }

    public void setBloopers(List<Object> bloopers) {
        this.bloopers = bloopers;
    }

    public List<Object> getClipUrls() {
        return clipUrls;
    }

    public void setClipUrls(List<Object> clipUrls) {
        this.clipUrls = clipUrls;
    }

    public Object getCurrentSeason() {
        return currentSeason;
    }

    public void setCurrentSeason(Object currentSeason) {
        this.currentSeason = currentSeason;
    }

    public List<Cast> getCasts() {
        return casts;
    }

    public void setCasts(List<Cast> casts) {
        this.casts = casts;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public String getMainlandPubdate() {
        return mainlandPubdate;
    }

    public void setMainlandPubdate(String mainlandPubdate) {
        this.mainlandPubdate = mainlandPubdate;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Object> getClips() {
        return clips;
    }

    public void setClips(List<Object> clips) {
        this.clips = clips;
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

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public List<PopularReview> getPopularReviews() {
        return popularReviews;
    }

    public void setPopularReviews(List<PopularReview> popularReviews) {
        this.popularReviews = popularReviews;
    }

    public Integer getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }
}
