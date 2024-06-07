package com.example.userstory.object;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public Object load(Class<?> classType, String filename) {

        return null;
    }
}
