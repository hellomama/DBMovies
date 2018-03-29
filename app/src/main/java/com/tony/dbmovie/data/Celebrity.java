package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by bushi on 2018/3/24.
 */

public class Celebrity implements Serializable {
    @SerializedName("website")
    @Expose
    private String website;
    @SerializedName("mobile_url")
    @Expose
    private String mobileUrl;
    @SerializedName("aka_en")
    @Expose
    private List<Object> akaEn = null;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("works")
    @Expose
    private List<Work> works = null;
    @SerializedName("name_en")
    @Expose
    private String nameEn;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("professions")
    @Expose
    private List<String> professions = null;
    @SerializedName("avatars")
    @Expose
    private Avatars avatars;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("aka")
    @Expose
    private List<String> aka = null;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("born_place")
    @Expose
    private String bornPlace;
    @SerializedName("constellation")
    @Expose
    private String constellation;
    @SerializedName("id")
    @Expose
    private String id;

    private int backgroundColor = 0xFFFFFF;

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getMobileUrl() {
        return mobileUrl;
    }

    public void setMobileUrl(String mobileUrl) {
        this.mobileUrl = mobileUrl;
    }

    public List<Object> getAkaEn() {
        return akaEn;
    }

    public void setAkaEn(List<Object> akaEn) {
        this.akaEn = akaEn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Work> getWorks() {
        return works;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getProfessions() {
        return professions;
    }

    public String getDisplayProfessions()
    {
        if (professions != null && professions.size()>0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : professions) {
                stringBuilder.append(s);
                stringBuilder.append("/");
            }
            return stringBuilder.toString();
        }else {
            return "";
        }
    }

    public void setProfessions(List<String> professions) {
        this.professions = professions;
    }

    public Avatars getAvatars() {
        return avatars;
    }

    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List<String> getAka() {
        return aka;
    }

    public void setAka(List<String> aka) {
        this.aka = aka;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getBornPlace() {
        return bornPlace;
    }

    public void setBornPlace(String bornPlace) {
        this.bornPlace = bornPlace;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Celebrity{" +
                "website='" + website + '\'' +
                ", mobileUrl='" + mobileUrl + '\'' +
                ", akaEn=" + akaEn +
                ", name='" + name + '\'' +
                ", works=" + works +
                ", nameEn='" + nameEn + '\'' +
                ", gender='" + gender + '\'' +
                ", professions=" + professions +
                ", avatars=" + avatars +
                ", summary='" + summary + '\'' +
                ", photos=" + photos +
                ", birthday='" + birthday + '\'' +
                ", aka=" + aka +
                ", alt='" + alt + '\'' +
                ", bornPlace='" + bornPlace + '\'' +
                ", constellation='" + constellation + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
