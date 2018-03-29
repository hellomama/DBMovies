package com.tony.dbmovie.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by dev on 3/29/18.
 */

public class Work {
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("subject")
    @Expose
    private Subject subject;

    public String getDisplayRole()
    {
        StringBuilder builder = new StringBuilder();
        for (String r : roles)
        {
            builder.append(r);
            builder.append("/");
        }
        builder.delete(builder.length()-1,builder.length());
        return builder.toString();
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Work{" +
                "roles=" + roles +
                ", subject=" + subject +
                '}';
    }
}
