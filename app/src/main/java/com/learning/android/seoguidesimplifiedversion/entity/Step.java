package com.learning.android.seoguidesimplifiedversion.entity;

public class Step {

    private int id;
    private String tip; //name
    private String description;
    private String why;
    private String how;
    private String image;
    private String videoId;

    public Step(){
    }

    public Step(int id) {
        this.id = id;
    }

    public Step(int id, String tip) {
        this.id = id;
        this.tip = tip;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWhy() {
        return why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public String getHow() {
        return how;
    }

    public void setHow(String how) {
        this.how = how;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String video) {
        this.videoId = video;
    }
}
