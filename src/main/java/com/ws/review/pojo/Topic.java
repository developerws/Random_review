package com.ws.review.pojo;

public class Topic {
    private int p_id;
    private int id;
    private String title;
    private String content;
    public Topic(){

    }
    public Topic(int p_id, int id, String title, String content) {
        this.p_id = p_id;
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
