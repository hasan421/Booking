
package com.example.HuseyinSonmez;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.HuseyinSonmez.Kullanici.Entitiy;
import com.example.HuseyinSonmez.ilanlar.Ilanlar;
import com.example.HuseyinSonmez.ilanlar.Veri_UI;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class IlanVer extends AppCompatActivity {
    EditText baslik , kira, adres,ilce;
    String value_baslik, value_il, value_ilce, value_kat, value_kira, value_adres, value_tip, value_oda, value_isitma;
    Spinner tip, oda, isitma,il,kat;
    Bitmap secili_resim;
    ImageView imageView;
    Entitiy entitiy;
    byte[] bytes;
Button kaydett;
    Veri_UI veri_ui;
Ilanlar ilanlar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan_ver);
        baslik = findViewById(R.id.baslik);
        il = findViewById(R.id.il);
        ilce = findViewById(R.id.ilce);
        tip = findViewById(R.id.mülktipi);
        oda = findViewById(R.id.odasayisi);
        isitma = findViewById(R.id.isitma);
        kat = findViewById(R.id.kat);
        kira = findViewById(R.id.kira);
        adres = findViewById(R.id.adres);
        imageView = findViewById(R.id.resim);
      kaydett=findViewById(R.id.ekle);
      //nesne uretir
        veri_ui=new Veri_UI(this,"Booking");



        valuesOfSpinner();
    }

    protected void onResume() {
        kaydett.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                value_tip = tip.getSelectedItem().toString();
                value_isitma = isitma.getSelectedItem().toString();
                value_oda = oda.getSelectedItem().toString();
                value_baslik = baslik.getText().toString();
                value_il = il.getSelectedItem().toString();
                value_ilce = ilce.getText().toString();
                value_kat = kat.getSelectedItem().toString();
                value_kira = kira.getText().toString();
                value_adres = adres.getText().toString();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
               secili_resim.compress(Bitmap.CompressFormat.PNG, 50, byteArrayOutputStream);
                ilanlar=new Ilanlar(value_baslik,value_il,value_ilce,value_kat,value_kira,value_adres,value_tip,value_oda,value_isitma,bytes);
                bytes = byteArrayOutputStream.toByteArray();

                //veri gönderir.
                 veri_ui.IlanEkle(ilanlar,bytes);
                Intent intent = new Intent(IlanVer.this, Listeleme.class);
                startActivity(intent);
                Toast.makeText(IlanVer.this,"Bu Method Çalıştı.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        super.onResume();

    }

    public void valuesOfSpinner() {
        ArrayList<String> tipListe = new ArrayList<>();
        tipListe.add("oda");
        tipListe.add("ev");
        ArrayAdapter arrayAdapter = new ArrayAdapter(IlanVer.this, android.R.layout.simple_spinner_item, tipListe);
        tip.setAdapter(arrayAdapter);

        ArrayList<String> odaListe = new ArrayList<>();
        odaListe.add("2+1");
        odaListe.add("3+1");
        odaListe.add("4+1");
        ArrayAdapter arrayAdapter1 = new ArrayAdapter(IlanVer.this, android.R.layout.simple_spinner_item, odaListe);
        oda.setAdapter(arrayAdapter1);

        ArrayList<String> isitmaListe = new ArrayList<>();
        isitmaListe.add("Kombi");
        isitmaListe.add("Merkezi");
        ArrayAdapter arrayAdapter2 = new ArrayAdapter(IlanVer.this, android.R.layout.simple_spinner_item, isitmaListe);
        isitma.setAdapter(arrayAdapter2);
        ArrayList<String> tipIl = new ArrayList<>();
        tipIl.add("Konya");
        tipIl.add("Ankara");
        tipIl.add("Bursa");
        ArrayAdapter arrayAdapter3 = new ArrayAdapter(IlanVer.this, android.R.layout.simple_spinner_item, tipIl);
        il.setAdapter(arrayAdapter3);
        ArrayList<String> tipKat = new ArrayList<>();
        tipKat.add("1.");
        tipKat.add("2.");
        tipKat.add("3.");
        tipKat.add("4.");
        tipKat.add("5.");
        tipKat.add("6.");
        tipKat.add("7.");
        tipKat.add("8.");
        tipKat.add("9.");
        tipKat.add("10.");
        ArrayAdapter arrayAdapter4 = new ArrayAdapter(IlanVer.this, android.R.layout.simple_spinner_item, tipKat);
        kat.setAdapter(arrayAdapter4);



    }


    public void galeri_kayıt(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != 0) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        } else {
            Intent intentToGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intentToGallery, 2);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent galeri_izin = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galeri_izin, 2);

            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 2 && resultCode == RESULT_OK && data != null) {
            Uri resim = data.getData();
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    ImageDecoder.Source source = ImageDecoder.createSource(this.getContentResolver(), resim);
                    secili_resim = ImageDecoder.decodeBitmap(source);
                    imageView.setImageBitmap(secili_resim);
                } else {
                    secili_resim = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resim);
                    imageView.setImageBitmap(secili_resim);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
