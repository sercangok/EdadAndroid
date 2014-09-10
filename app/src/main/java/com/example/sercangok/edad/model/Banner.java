package com.example.sercangok.edad.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sercangok on 27/08/14.
 */
public class Banner {
    @SerializedName("aktifbanner")
    private String aktifbanner;
    @SerializedName("pasifbanner")
    private String pasifbanner;
    @SerializedName("durum")
    private int durum;

    public String getAktifbanner() {
        return aktifbanner;
    }

    public String getPasifbanner() {

        return pasifbanner;
    }

    public int getDurum() {
        return durum;
    }

    public String getBanner() {
        return (durum == 1) ? aktifbanner : pasifbanner;
    }

    public void setBanner(String banner) {
        this.aktifbanner = banner;
    }


}
