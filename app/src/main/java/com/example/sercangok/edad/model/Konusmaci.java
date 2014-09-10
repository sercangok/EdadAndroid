package com.example.sercangok.edad.model;

import android.graphics.drawable.Drawable;

/**
 * Created by sercangok on 27/08/14.
 */
public class Konusmaci {
    private String adi;
    private Drawable resim;

    public Konusmaci(String adi, Drawable resim) {
        this.adi = adi;
        this.resim = resim;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public Drawable getResim() {
        return resim;
    }

    public void setResim(Drawable resim) {
        this.resim = resim;
    }
}
