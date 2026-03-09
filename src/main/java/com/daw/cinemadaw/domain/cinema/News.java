package com.daw.cinemadaw.domain.cinema;

public class News {

    private String headline;
    private String body;

    public News(String body, String headline) {
        this.body = body;
        this.headline = headline;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    
}
