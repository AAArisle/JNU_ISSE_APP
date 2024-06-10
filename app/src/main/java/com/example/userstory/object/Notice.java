package com.example.userstory.object;

import androidx.annotation.NonNull;

public class Notice {
    private String title;
    private String body;
    private String time;

    public Notice(String title, String body, String time) {
        this.title = title;
        this.body = body;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getTime() {
        return time;
    }
    public void setTitle(String Title) {
        this.title=Title;
    }
    public void setBody(String Body) {
        this.body=Body;
    }
    public void setTime(String Time) {
        this.time=Time;
    }

}
