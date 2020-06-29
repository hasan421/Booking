package com.example.HuseyinSonmez;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.HuseyinSonmez.Kullanici.Entitiy;
import com.example.HuseyinSonmez.Kullanici.Kullanici;



public class Kayit extends AppCompatActivity {
  EditText isim,soyisim,eposta,sifre,sifretekrar,cep_tel;
  String value_isim;
  String value_soyisim;
  String value_eposta;
  Button Kayit;
  String value_sifre;
  String value_sifretekrar;
  String value_cep_tel;
    Kullanici kullanici;
    Entitiy entitiy;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);
      isim=findViewById(R.id.isim_txt);
      soyisim=findViewById(R.id.soyisim_txt);
      Kayit=findViewById(R.id.btnKayit);
      eposta=findViewById(R.id.email_txt);
      sifre=findViewById(R.id.sifre_txt);
      sifretekrar=findViewById(R.id.sifre_txt2);
      cep_tel=findViewById(R.id.cep_tel_txt);
      value_isim=isim.getText().toString();
      value_soyisim=soyisim.getText().toString();
      value_eposta=eposta.getText().toString();
      value_sifre=sifre.getText().toString();
      value_sifretekrar=sifretekrar.getText().toString();
      value_cep_tel=cep_tel.getText().toString();
        entitiy=new Entitiy(Kayit.this,"Booking");

        Kayit.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

            kullanici =new Kullanici(isim.getText().toString(),soyisim.getText().toString(),eposta.getText().toString(),sifre.getText().toString(),sifretekrar.getText().toString(),cep_tel.getText().toString());
            System.out.println(eposta.getText().toString());
            if (sifre.getText().toString().equals(sifretekrar.getText().toString()))
            {
              entitiy.KullaniciOluştur(kullanici);
              Intent intent=new Intent(Kayit.this, Giris.class);
              startActivity(intent);
              finish();
            }
            else{

              Toast.makeText(Kayit.this,"Girilen Parolalar Aynı Değer Olmalıdır.",Toast.LENGTH_SHORT).show();
            }
          }
        });
    }
}
