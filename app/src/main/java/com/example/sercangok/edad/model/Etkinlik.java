package com.example.sercangok.edad.model;

import java.sql.Date;

/**
 * Created by sercangok on 27/08/14.
 */
public class Etkinlik {
    @SuppressWarnings("etkinlikid")
    private int etkinlikid;
    @SuppressWarnings("isim")
    private String isim;
    @SuppressWarnings("konusmaci")
    private String konusmaci;
    @SuppressWarnings("tarih")
    private Date tarih;
    @SuppressWarnings("yer")
    private String yer;
    @SuppressWarnings("kategoriid")
    private int kategoriid;
    @SuppressWarnings("lat")
    private String lat;
    @SuppressWarnings("lon")
    private String lon;

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

    public Date getTarih() {
        return tarih;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public String getYer() {
        return yer;
    }

    public void setYer(String yer) {
        this.yer = yer;
    }
}
