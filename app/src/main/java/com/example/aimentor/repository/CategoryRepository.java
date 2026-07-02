package com.example.aimentor.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.example.aimentor.databases.SqliteDbHelper;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class CategoryRepository extends SqliteDbHelper {
    public CategoryRepository(@Nullable Context context) {
        super(context);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    private String getCurrentDate(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ZonedDateTime zoneDt = ZonedDateTime.now();
        return dtf.format(zoneDt); // lay ra duoc ngay thang hien tai va gio phut giay
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public long saveNewCategory(String name, String description){
        String currentDate = getCurrentDate();
        ContentValues values = new ContentValues();
        values.put(NAME_CATEGORY, name);
        values.put(DESCRIPTION_CATEGORY, description);
        values.put(STATUS_CATEGORY, 1);
        values.put(CREATED_AT, currentDate);
        SQLiteDatabase db = this.getWritableDatabase();
        long insert = db.insert(CATEGORY_TABLE, null, values);
        db.close();
        return  insert;
    }
}
