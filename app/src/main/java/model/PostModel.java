package model;

/**
 * Created by A on 23-03-2018.
 */

public class PostModel {
    private Integer profile,post;
    private String name,like,caption,captionname;

    public Integer getProfile() {
        return profile;
    }

    public String getCaptionname() {
        return captionname;
    }

    public void setCaptionname(String captionname) {
        this.captionname = captionname;
    }

    public void setProfile(Integer profile) {
        this.profile = profile;
    }

    public Integer getPost() {
        return post;
    }

    public void setPost(Integer post) {
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
