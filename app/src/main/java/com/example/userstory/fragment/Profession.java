package com.example.userstory.fragment;


public class Profession {
    private String name;
    private int imageResId; // 使用资源ID

    public Profession(String name, int imageResId) {
        this.name = name;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }
}
