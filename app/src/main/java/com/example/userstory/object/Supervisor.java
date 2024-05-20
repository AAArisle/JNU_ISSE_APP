package com.example.userstory.object;

import android.os.Parcel;
import android.os.Parcelable;

// 实现Parcelable接口以便数据传输
public class Supervisor implements Parcelable {
    String name;
    String job_title;
    String direction;
    int imageId;

    String introduction;

    String contact_information;

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

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContact_information() {
        return contact_information;
    }

    public void setContact_information(String contact_information) {
        this.contact_information = contact_information;
    }


    // 实现Parcelable接口以便数据传输，下面4部分内容都是必要的
    protected Supervisor(Parcel in) {
        name = in.readString();
        job_title = in.readString();
        direction = in.readString();
        imageId = in.readInt();
        introduction = in.readString();
        contact_information = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(job_title);
        dest.writeString(direction);
        dest.writeInt(imageId);
        dest.writeString(introduction);
        dest.writeString(contact_information);
    }
    public static final Creator<Supervisor> CREATOR = new Creator<Supervisor>() {
        @Override
        public Supervisor createFromParcel(Parcel in) {
            return new Supervisor(in);
        }

        @Override
        public Supervisor[] newArray(int size) {
            return new Supervisor[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

}
