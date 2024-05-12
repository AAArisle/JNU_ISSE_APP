// 【专业】类
package com.example.userstory.object;


public class Profession {
    private String name;
    private int imageResId;
    private String introDetail;
    private String coursesDetail;
    private String requirementsDetail;

    public Profession(String name, int imageResId, String introDetail, String coursesDetail, String requirementsDetail) {
        this.name = name;
        this.imageResId = imageResId;
        this.introDetail = introDetail;
        this.coursesDetail = coursesDetail;
        this.requirementsDetail = requirementsDetail;
    }

    public String getName() {
        return name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getIntroDetail() {
        return introDetail;
    }

    public String getCoursesDetail() {
        return coursesDetail;
    }

    public String getRequirementsDetail() {
        return requirementsDetail;
    }
}
