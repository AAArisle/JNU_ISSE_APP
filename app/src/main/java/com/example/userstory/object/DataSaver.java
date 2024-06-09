package com.example.userstory.object;

import static com.example.userstory.fragment.SupervisorFragment.allSupervisors;
import static com.example.userstory.fragment.collegeInnerFragment.AcademicCommitteeFragment.notice;
import static com.example.userstory.fragment.collegeInnerFragment.CollegeIntroFragment.intro;
import static com.example.userstory.fragment.collegeInnerFragment.ContactUsFragment.contactFunc;
import static com.example.userstory.fragment.collegeInnerFragment.ContactUsFragment.point1;
import static com.example.userstory.fragment.collegeInnerFragment.DeanMessageFragment.message;
import static com.example.userstory.fragment.collegeInnerFragment.LeaderShipFragment.leaderShips;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DataSaver {
    public void save(Object data, String filename) {
        try {
            File file = new File(filename);
            FileWriter writer = new FileWriter(file);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(data, writer);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object load(Type classType, String filename) {
        try {
            File file = new File(filename);
            FileReader reader = new FileReader(file);
            Gson gson = new Gson();
            return gson.fromJson(reader, classType);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveAll(String pathname) {
        File directory = new File(pathname);
        if (!directory.exists()) {
            directory.mkdirs(); // ����Ŀ¼
        }

        // רҵ������
        // dataSaver.save(professionRepository, pathname+"professions.json");
        // ��ʦ������
        this.save(allSupervisors, pathname+"allSupervisors.json");
        // ѧԺ������
        this.save(leaderShips, pathname+"leaderShips.json");    // ѧԺ�쵼
        this.save(notice, pathname+"notice.json");  // ѧ��ίԱ���֪ͨ
        this.save(intro, pathname+"intro.json");    // ѧԺ����
        this.save(contactFunc, pathname+"contactFunc.json");    // ��ϵ��ʽ
        this.save(point1, pathname+"point1.json");  //��ͼ��ê��
        this.save(message, pathname+"message.json");    // Ժ������

        // ArrayList<Object> dataBase = new ArrayList<>();
        // dataBase.addAll(Arrays.asList(professions,allSupervisors,leaderShips,notice,intro,contactFunc,point1,message));
        // dataSaver.save(dataBase, pathname+"dataBase.json");     // ������
    }

    public void loadAll(String pathname) {
        // רҵ������
        // dbHelper = (DatabaseHelper) dataSaver.load(new TypeToken<DatabaseHelper>() {}.getType(), pathname+"professions.json");
        // ��ʦ������
        allSupervisors = (ArrayList<Supervisor>) this.load(new TypeToken<List<Supervisor>>() {}.getType(), pathname+"allSupervisors.json");
        // ѧԺ������
        leaderShips = (List<LeaderShip>) this.load(new TypeToken<List<LeaderShip>>() {}.getType(), pathname+"leaderShips.json");    // ѧԺ�쵼
        notice = (Notice) this.load(new TypeToken<Notice>() {}.getType(), pathname+"notice.json");  // ѧ��ίԱ���֪ͨ
        intro = (String) this.load(new TypeToken<String>() {}.getType(), pathname+"intro.json");    // ѧԺ����
        contactFunc = (ContactFunc) this.load(new TypeToken<ContactFunc>() {}.getType(), pathname+"contactFunc.json");    // ��ϵ��ʽ
        point1 = (LatLng) this.load(new TypeToken<LatLng>() {}.getType(), pathname+"point1.json");  //��ͼ��ê��
        message = (String) this.load(new TypeToken<String>() {}.getType(), pathname+"message.json");    // Ժ������
    }
}
