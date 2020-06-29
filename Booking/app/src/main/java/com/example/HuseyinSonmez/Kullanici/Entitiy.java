package com.example.HuseyinSonmez.Kullanici;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class Entitiy {
    SQLiteDatabase sqLiteDatabase;
    DataAccess dataAccess;

    public Entitiy(Context context, String name) {
        dataAccess = new DataAccess(context, name, null, 1);
    }


    public void KullaniciOluştur(Kullanici kullancı) {
        sqLiteDatabase = dataAccess.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("ad", kullancı.getAd().toString());
        val.put("soyad", kullancı.getSoyad().toString());
        System.out.println(kullancı.getSoyad());
        val.put("email", kullancı.getEmail().toString());
        val.put("sifre", kullancı.getSifre().toString());
        val.put("ceptel", kullancı.getCep_tel().toString());
        sqLiteDatabase.insert("Kullanicilar", null, val);
        System.out.println(kullancı.getEmail()+kullancı.getSifre()+kullancı.getAd()+kullancı.getCep_tel());
        System.out.println("Kullanıcı oluşturuldu.");


    }


    public void Giriş(Kullanici kullancı) {
        sqLiteDatabase = dataAccess.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Kullanicilar", null);

        while (cursor.moveToNext()) {
            kullancı.emailstring = cursor.getString(3);
            kullancı.sifrestring = cursor.getString(4);
//

//            byte [] imgbyte=cursor.getBlob(9);
//            İlanlar i̇lanlar=new İlanlar();

        }

    }
}