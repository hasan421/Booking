package com.example.HuseyinSonmez.ilanlar;

public class Ilanlar {
    String baslik, il, ilce, kat, kira, adres, tip, oda, isitma;
    int position;
    byte[] resim;

    public Ilanlar(String baslik, String il, String ilce, String kat, String kira, String adres, String tip, String oda, String isitma, byte[] resim) {
        this.baslik = baslik;
        this.il = il;
        this.ilce = ilce;
        this.kat = kat;
        this.kira = kira;
        this.adres = adres;
        this.tip = tip;
        this.oda = oda;
        this.isitma = isitma;
        this.resim = resim;
    }

    public Ilanlar(String baslik, String il, String ilce, String kat, String kira, String tip, byte[] resim) {
        this.baslik = baslik;
        this.il = il;
        this.ilce = ilce;
        this.tip = tip;
        this.kat = kat;
        this.kira = kira;
        this.resim = resim;
    }

    public Ilanlar() {
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public String getKira() {
        return kira;
    }

    public void setKira(String kira) {
        this.kira = kira;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getOda() {
        return oda;
    }

    public void setOda(String oda) {
        this.oda = oda;
    }

    public String getIsitma() {
        return isitma;
    }

    public void setIsitma(String isitma) {
        this.isitma = isitma;
    }

    public byte[] getResim() {
        return resim;
    }

    public void setResim(byte[] resim) {
        this.resim = resim;
    }
}
