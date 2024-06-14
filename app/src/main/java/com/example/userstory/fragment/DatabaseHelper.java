package com.example.userstory.fragment;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.userstory.R;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "professions.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_PROFESSIONS = "professions";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_IMAGE = "image";
    public static final String COLUMN_INTRO = "intro";
    public static final String COLUMN_COURSES = "courses";
    public static final String COLUMN_REQUIREMENTS = "requirements";

    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_PROFESSIONS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT, " +
                    COLUMN_IMAGE + " INTEGER, " +
                    COLUMN_INTRO + " TEXT, " +
                    COLUMN_COURSES + " TEXT, " +
                    COLUMN_REQUIREMENTS + " TEXT" +
                    ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    @Override
//    public void onCreate(SQLiteDatabase db) {
//        db.execSQL(TABLE_CREATE);
//    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        insertDefaultProfessions(db);
    }

    private void insertDefaultProfessions(SQLiteDatabase db) {
        insertProfession(db, "Biology", R.drawable.biology, " ", "", "");
        insertProfession(db, "Computer Science", R.drawable.computer_science, "", "", "");

    }
    private void insertProfession(SQLiteDatabase db, String name, int imageResId, String intro, String courses, String requirements) {
        String insertSQL = "INSERT INTO " + TABLE_PROFESSIONS + " (" +
                COLUMN_NAME + ", " +
                COLUMN_IMAGE + ", " +
                COLUMN_INTRO + ", " +
                COLUMN_COURSES + ", " +
                COLUMN_REQUIREMENTS + ") VALUES (?, ?, ?, ?, ?)";
        db.execSQL(insertSQL, new Object[]{name, imageResId, intro, courses, requirements});
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFESSIONS);
        onCreate(db);
    }
}

