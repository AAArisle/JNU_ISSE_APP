package com.example.userstory.fragment;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProfessionRepository {
    private DatabaseHelper dbHelper;

    public ProfessionRepository(Context context) {
        dbHelper = new DatabaseHelper(context);
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
}
