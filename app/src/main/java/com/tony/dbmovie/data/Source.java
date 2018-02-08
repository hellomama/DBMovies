package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by dev on 2/7/18.
 */

public class Source {
    @SerializedName("literal")
    @Expose
    private String literal;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("name")
    @Expose
    private String name;

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
