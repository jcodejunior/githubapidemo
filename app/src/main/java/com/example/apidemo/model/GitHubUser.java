package com.example.apidemo.model;

import com.google.gson.annotations.SerializedName;

public class GitHubUser {
    @SerializedName("avatar_url")
    private String avatar;

    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("login")
    private String login;

    @SerializedName("location")
    private String location;

    @SerializedName("followers")
    private String followers;

    @SerializedName("following")
    private String following;


    public GitHubUser(String avatar, String name, String email, String login, String location, String followers, String following) {
        this.avatar = avatar;
        this.name = name;
        this.email = email;
        this.login = login;
        this.location = location;
        this.followers = followers;
        this.following = following;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }


    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
