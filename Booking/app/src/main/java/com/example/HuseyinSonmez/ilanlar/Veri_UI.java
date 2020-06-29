package com.example.HuseyinSonmez.ilanlar;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;

public class Veri_UI {
    SQLiteDatabase sqLiteDatabase;
    MyDataAccess myDataAccess;
ArrayList<Integer> arrayList=new ArrayList<>();
    public Veri_UI(Context context, String name) {
        myDataAccess = new MyDataAccess(context, name, null, 2);
    }

    public void IlanEkle(Ilanlar i̇lanlar, byte[] resim) {
        sqLiteDatabase = myDataAccess.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("baslik", i̇lanlar.getBaslik());
        contentValues.put("il", i̇lanlar.getIl());
        contentValues.put("ilce", i̇lanlar.getIlce());
        contentValues.put("kat", i̇lanlar.getKat());
        contentValues.put("kira", i̇lanlar.getKira());
        contentValues.put("adres", i̇lanlar.getBaslik());
        contentValues.put("tip", i̇lanlar.getTip());
        contentValues.put("oda", i̇lanlar.getOda());
        contentValues.put("isitma", i̇lanlar.getIsitma());
        contentValues.put("resim", resim);
        sqLiteDatabase.insert("Ilanlar", null, contentValues);

    }

    public ArrayList<Ilanlar> getData(ArrayList<Ilanlar> tumIlanlar) {

        sqLiteDatabase = myDataAccess.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Ilanlar",null);
        int id=cursor.getColumnIndex("id");
        while (cursor.moveToNext()) {
            arrayList.add(cursor.getInt(id));
            String tip = (cursor.getString(7));
            String baslik = cursor.getString(1);
            String kat = cursor.getString(4);
            String kira = cursor.getString(5);
            String il = cursor.getString(2);
            String ilce = cursor.getString(3);
            byte[] resim = cursor.getBlob(10);

            tumIlanlar.add(new Ilanlar(baslik,il,ilce,kat,kira,tip,resim));

        }
        return tumIlanlar;
    }
    public void Delete(int position)
    {


        sqLiteDatabase=myDataAccess.getWritableDatabase();
        SQLiteStatement sqLiteStatement=sqLiteDatabase.compileStatement("DELETE FROM Ilanlar WHERE id="+arrayList.get(position));
     //   sqLiteStatement.bindLong(1);
        sqLiteStatement.execute();




    }

    public void Update(Ilanlar ilanlar,byte[] resim)
    {
       String id= arrayList.get(ilanlar.getPosition()).toString();
        sqLiteDatabase = myDataAccess.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("baslik", ilanlar.getBaslik());
        contentValues.put("il", ilanlar.getIl());
        contentValues.put("ilce", ilanlar.getIlce());
        contentValues.put("kat", ilanlar.getKat());
        contentValues.put("kira", ilanlar.getKira());
        contentValues.put("adres", ilanlar.getBaslik());
        contentValues.put("tip", ilanlar.getTip());
        contentValues.put("oda", ilanlar.getOda());
        contentValues.put("isitma", ilanlar.getIsitma());
        contentValues.put("resim",resim );
        sqLiteDatabase.update("Ilanlar",contentValues,"id="+id,null);

    }


}
