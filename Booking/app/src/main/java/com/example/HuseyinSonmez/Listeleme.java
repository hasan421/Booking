package com.example.HuseyinSonmez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.HuseyinSonmez.Kullanici.Kullanici;
import com.example.HuseyinSonmez.ilanlar.Ilanlar;
import com.example.HuseyinSonmez.ilanlar.AdapterIslemleri.MyAdapter;
import com.example.HuseyinSonmez.ilanlar.Veri_UI;

import java.util.ArrayList;

public class Listeleme extends AppCompatActivity {
    ListView listView;
    Veri_UI veri_ui;
    ArrayList<Ilanlar> tumIlan;
    Ilanlar ilanlar;
    MyAdapter adapter;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listeleme);
        listView = findViewById(R.id.list);
        ilanlar = new Ilanlar();
        veri_ui = new Veri_UI(this, "Booking");
        tumIlan = new ArrayList<Ilanlar>();
        adapter=new MyAdapter( this, R.layout.tek_satir,veri_ui.getData(tumIlan));
        listView.setAdapter(adapter);

 }

    @Override
    protected void onResume() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            final Ilanlar ilanlar=new Ilanlar();
            ilanlar.setPosition(position);
                System.out.println(ilanlar.getPosition());
                AlertDialog.Builder builder1 = new AlertDialog.Builder(Listeleme.this);
                builder1.setMessage("Write your message here.");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Güncelleme",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Intent intent=new Intent(Listeleme.this,Ilan_Guncelle.class);
                                startActivity(intent);
                               ;
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "Silme",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                    veri_ui.Delete(position);
                                    adapter.notifyDataSetChanged();

                                        recreate();



                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();
                return false;
            }
        });
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.adresekle, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            Intent intent = new Intent(Listeleme.this, IlanVer.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.profil) {



            Intent intent = new Intent(Listeleme.this, Profil_D.class);
            startActivity(intent);
        }


        return super.onOptionsItemSelected(item);
    }

}
