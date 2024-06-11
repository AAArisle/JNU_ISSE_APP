package com.example.userstory.fragment;



import static com.tencent.mapsdk.internal.aaa.getContext;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class ProfessionRepository {
    private DatabaseHelper dbHelper;
    private Context context;

    public ProfessionRepository(Context context) {

        dbHelper = new DatabaseHelper(context);
        this.context = context;
    }

    public List<Profession> getAllProfessions() {
        List<Profession> professions = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(DatabaseHelper.TABLE_PROFESSIONS, null, null, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                int image = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_IMAGE));
                String intro = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_INTRO));
                String courses = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_COURSES));
                String requirements = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_REQUIREMENTS));

                Profession profession = new Profession(id, name, image, intro, courses, requirements);
                professions.add(profession);
            }
            cursor.close();
        }

        return professions;
    }

    public void addProfession(Profession profession) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, profession.getName());
        values.put(DatabaseHelper.COLUMN_IMAGE, profession.getImageResId());
        values.put(DatabaseHelper.COLUMN_INTRO, profession.getIntroDetail());
        values.put(DatabaseHelper.COLUMN_COURSES, profession.getCoursesDetail());
        values.put(DatabaseHelper.COLUMN_REQUIREMENTS, profession.getRequirementsDetail());

        db.insert(DatabaseHelper.TABLE_PROFESSIONS, null, values);
    }

    public void updateProfession(Profession profession) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, profession.getName());
        values.put(DatabaseHelper.COLUMN_IMAGE, profession.getImageResId());
        values.put(DatabaseHelper.COLUMN_INTRO, profession.getIntroDetail());
        values.put(DatabaseHelper.COLUMN_COURSES, profession.getCoursesDetail());
        values.put(DatabaseHelper.COLUMN_REQUIREMENTS, profession.getRequirementsDetail());

        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = { String.valueOf(profession.getId()) };

        db.update(DatabaseHelper.TABLE_PROFESSIONS, values, selection, selectionArgs);
    }

    public void deleteProfession(int professionId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selection = DatabaseHelper.COLUMN_ID + " = ?";
        String[] selectionArgs = { String.valueOf(professionId) };

        db.delete(DatabaseHelper.TABLE_PROFESSIONS, selection, selectionArgs);
    }
    public void importProfessionsData() {
        Context context = getContext();
        if (context == null) return;

        String pathname = Environment.getExternalStorageDirectory().getPath() + "/Documents/data_save/professions.json";
        File file = new File(pathname);
        if (!file.exists()) {
            Toast.makeText(context, "数据导入失败！\n专业数据文件不存在！", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String json = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(json);

            ProfessionRepository professionRepository = new ProfessionRepository(context);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Profession profession = new Profession(
                        jsonObject.getString("name"),
                        jsonObject.getInt("image"),
                        jsonObject.getString("intro"),
                        jsonObject.getString("courses"),
                        jsonObject.getString("requirements")
                );
                professionRepository.addProfession(profession);
            }
            Toast.makeText(context, "专业数据导入成功！", Toast.LENGTH_SHORT).show();
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            Toast.makeText(context, "数据导入失败！", Toast.LENGTH_SHORT).show();
        }
    }
    public void exportProfessionsData() {
        List<Profession> professionList = getAllProfessions();

        JSONArray jsonArray = new JSONArray();
        for (Profession profession : professionList) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("id", profession.getId());
                jsonObject.put("name", profession.getName());
                jsonObject.put("image", profession.getImageResId());
                jsonObject.put("intro", profession.getIntroDetail());
                jsonObject.put("courses", profession.getCoursesDetail());
                jsonObject.put("requirements", profession.getRequirementsDetail());
                jsonArray.put(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        String pathname = Environment.getExternalStorageDirectory().getPath() + "/Documents/data_save/professions.json";
        File file = new File(pathname);

        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write(jsonArray.toString());
            Toast.makeText(context, "专业数据导出成功！" + pathname, Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(context, "数据导出失败！", Toast.LENGTH_SHORT).show();
        }
    }

}
