package com.example.HuseyinSonmez.ilanlar;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataAccess extends SQLiteOpenHelper {

    private  final static  String tablo_name="Ilanlar";

    public MyDataAccess(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       String sql="CREATE TABLE IF NOT EXISTS Ilanlar (id INTEGER PRIMARY KEY AUTOINCREMENT,baslik VARCHAR,il VARCHAR,ilce VARCHAR,kat VARCHAR,kira VARCHAR,adres VARCHAR,tip VARCHAR,oda VARCHAR,isitma VARCHAR,resim BLOB);";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

     db.execSQL("DROP TABLE IF EXISTS Ilanlar");
       onCreate(db);
   }
}
