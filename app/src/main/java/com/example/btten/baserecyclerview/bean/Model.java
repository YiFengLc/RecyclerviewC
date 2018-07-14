package com.example.btten.baserecyclerview.bean;

public class Model {
    private String title;
    private String content;
    private Integer imgUrl;

    public Model(String title, String content, Integer imgUrl) {
        this.title = title;
        this.content = content;
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(Integer imgUrl) {
        this.imgUrl = imgUrl;
    }
}