package com.example.HuseyinSonmez.Kullanici;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataAccess extends SQLiteOpenHelper {
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS Kullanicilar (id INTEGER PRIMARY KEY AUTOINCREMENT,ad VARCHAR, soyad VARCHAR, email VARCHAR,sifre,VARCHAR,ceptel VARCHAR)");
    }

    public DataAccess(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS Kullanicilar");
            onCreate(db);
    }
}
