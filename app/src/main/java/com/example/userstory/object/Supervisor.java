package com.example.userstory.object;

import com.example.userstory.R;

public class Supervisor {
    String name;
    String direction;
    int imageId;

//    String introduction;

//    String contact_information;

    public Supervisor(String name, String direction, int imageId) {
        this.name = name;
        this.direction = direction;
        this.imageId = imageId;
    }

    public String getSupervisorName() {
        return name;
    }

    public void setSupervisorName(String name) {
        this.name = name;
    }

    public String getSupervisorDirection() {
        return direction;
    }

    public void setSupervisorDirection(String direction) {
        this.direction = direction;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

//    public String getIntroduction() {
//        return introduction;
//    }
//
//    public void setIntroduction(String introduction) {
//        this.introduction = introduction;
//    }
//
//    public String getContact_information() {
//        return contact_information;
//    }
//
//    public void setContact_information(String contact_information) {
//        this.contact_information = contact_information;
//    }
}
