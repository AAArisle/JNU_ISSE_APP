package com.example.userstory.fragment;



public class Profession {
    private int id;
    private String name;
    private int imageResId;
    private String introDetail;
    private String coursesDetail;
    private String requirementsDetail;

    public Profession(int id, String name, int imageResId, String introDetail, String coursesDetail, String requirementsDetail) {
        this.id = id;
        this.name = name;
        this.imageResId = imageResId;
        this.introDetail = introDetail;
        this.coursesDetail = coursesDetail;
        this.requirementsDetail = requirementsDetail;
    }

    public Profession(String name, int imageResId, String introDetail, String coursesDetail, String requirementsDetail) {
        this.name = name;
        this.imageResId = imageResId;
        this.introDetail = introDetail;
        this.coursesDetail = coursesDetail;
        this.requirementsDetail = requirementsDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getIntroDetail() {
        return introDetail;
    }

    public void setIntroDetail(String introDetail) {
        this.introDetail = introDetail;
    }

    public String getCoursesDetail() {
        return coursesDetail;
    }

    public void setCoursesDetail(String coursesDetail) {
        this.coursesDetail = coursesDetail;
    }

    public String getRequirementsDetail() {
        return requirementsDetail;
    }

    public void setRequirementsDetail(String requirementsDetail) {
        this.requirementsDetail = requirementsDetail;
    }
}
