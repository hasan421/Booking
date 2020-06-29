package com.example.HuseyinSonmez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.HuseyinSonmez.Kullanici.Entitiy;
import com.example.HuseyinSonmez.Kullanici.Kullanici;

public class Giris extends AppCompatActivity {
EditText email;
EditText sifre;


Entitiy entitiy;
Kullanici kullanici;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email=findViewById(R.id.emailTxt);
        sifre=findViewById(R.id.sifreTxt);
entitiy=new Entitiy(Giris.this,"Booking");
    }

    public void btn_giris(View view)
    {
      kullanici =new Kullanici(email.getText().toString(),sifre.getText().toString());

        entitiy.Giriş(kullanici);
        System.out.println(kullanici.getEmailstring());

        if (email.getText().toString().equals(kullanici.getEmailstring())&& sifre.getText().toString().equals(kullanici.getSifrestring()))
        {


            Intent intent=new Intent(Giris.this, Listeleme.class);
            startActivity(intent);
            finish();
        }
        else
        {

            Toast.makeText(Giris.this,"Kullanıcı Adı veya Şifre Yanlış.",Toast.LENGTH_SHORT).show();
        }
    }

    public void btn_kayit(View view)
    {
        Intent intent=new Intent(Giris.this,Kayit.class);
        startActivity(intent);
    }



}
