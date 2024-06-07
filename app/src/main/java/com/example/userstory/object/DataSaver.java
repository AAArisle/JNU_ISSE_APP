package com.example.userstory.object;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;

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
}
