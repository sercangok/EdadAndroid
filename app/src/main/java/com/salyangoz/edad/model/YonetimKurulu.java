package com.salyangoz.edad.model;

/**
 * Created by sercangok on 27/08/14.
 */
public class YonetimKurulu {
    @SuppressWarnings("yonetimid")
    private int id;
    @SuppressWarnings("isim")
    private String isim;
    @SuppressWarnings("unvan")
    private String unvan;
    @SuppressWarnings("resim")
    private String resim;
    @SuppressWarnings("sira")
    private int sira;

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public int getSira() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira = sira;
    }

    public String getResim() {
        return resim;
    }

    public void setResim(String resim) {
        this.resim = resim;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return isim;
    }
}
