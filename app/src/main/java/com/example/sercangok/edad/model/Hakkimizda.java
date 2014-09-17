package com.example.sercangok.edad.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sercangok on 27/08/14.
 */
public class Hakkimizda {
    @SerializedName("hakkimizdaid")
    private int hakkimizdaid;
    @SerializedName("hakkimizda")
    private String hakkimizda;
    @SerializedName("resim")
    private String resim;

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public int getHakkimizdaID() {
        return hakkimizdaid;
    }

    public void setHakkimizdaID(int hakkimizdaID) {
        this.hakkimizdaid = hakkimizdaID;
    }

    public String getHakkimizda() {
        return hakkimizda;
    }

    public void setHakkimizda(String hakkimizda) {
        this.hakkimizda = hakkimizda;
    }

    @Override
    public String toString() {
        return hakkimizda;
    }
}
