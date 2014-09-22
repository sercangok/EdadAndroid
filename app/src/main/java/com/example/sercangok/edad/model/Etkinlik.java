package com.example.sercangok.edad.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by sercangok on 27/08/14.
 */
public class Etkinlik implements Serializable {
    @SuppressWarnings("etkinlikid")
    private int etkinlikid;
    @SuppressWarnings("isim")
    private String isim;
    @SuppressWarnings("konusmaci")
    private String konusmaci;
    @SuppressWarnings("baslangictarihi")
    private Date baslangictarihi;
    @SuppressWarnings("bitistarihi")
    private Date bitistarihi;
    @SuppressWarnings("yer")
    private String yer;
    @SuppressWarnings("kategoriid")
    private int kategoriid;
    @SuppressWarnings("lat")
    private String lat;
    @SuppressWarnings("lon")
    private String lon;
    @SuppressWarnings("kategoriismi")
    private String kategoriismi;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }


    public int getKategoriid() {
        return kategoriid;
    }

    public void setKategoriid(int kategoriid) {
        this.kategoriid = kategoriid;
    }

    public int getEtkinlikid() {
        return etkinlikid;
    }

    public void setEtkinlikid(int etkinlikid) {
        this.etkinlikid = etkinlikid;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getKonusmaci() {
        return konusmaci;
    }

    public void setKonusmaci(String konusmaci) {
        this.konusmaci = konusmaci;
    }

    public String getYer() {
        return yer;
    }

    public void setYer(String yer) {
        this.yer = yer;
    }

    public String getKategoriismi() {
        return kategoriismi;
    }

    public void setKategoriismi(String kategoriismi) {
        this.kategoriismi = kategoriismi;
    }

    public Date getBaslangictarihi() {
        return baslangictarihi;
    }

    public void setBaslangictarihi(Date baslangictarihi) {
        this.baslangictarihi = baslangictarihi;
    }

    public Date getBitistarihi() {
        return bitistarihi;
    }

    public void setBitistarihi(Date bitistarihi) {
        this.bitistarihi = bitistarihi;
    }
}
