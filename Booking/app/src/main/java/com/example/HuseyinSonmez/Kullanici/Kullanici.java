package com.example.HuseyinSonmez.Kullanici;

public class Kullanici {
String ad,soyad,email,sifre,sifre_tekrar,cep_tel;
String emailstring,sifrestring;

    public Kullanici(String ad, String soyad, String email, String sifre, String sifre_tekrar, String cep_tel) {
        this.ad = ad;
        this.soyad = soyad;
        this.email = email;
        this.sifre = sifre;
        this.sifre_tekrar=sifre_tekrar;
        this.cep_tel = cep_tel;
    }
public Kullanici(String email, String sifre)
{
    this.email=email;
    this.sifre=sifre;
}

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getSifre_tekrar() {
        return sifre_tekrar;
    }

    public void setSifre_tekrar(String sifre_tekrar) {
        this.sifre_tekrar = sifre_tekrar;
    }

    public String getCep_tel() {
        return cep_tel;
    }

    public void setCep_tel(String cep_tel) {
        this.cep_tel = cep_tel;
    }

    public String getEmailstring() {
        return emailstring;
    }

    public void setEmailstring(String emailstring) {
        this.emailstring = emailstring;
    }

    public String getSifrestring() {
        return sifrestring;
    }

    public void setSifrestring(String sifrestring) {
        this.sifrestring = sifrestring;
    }
}
