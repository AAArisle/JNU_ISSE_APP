// 【专业】类
package com.example.userstory.object;


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

