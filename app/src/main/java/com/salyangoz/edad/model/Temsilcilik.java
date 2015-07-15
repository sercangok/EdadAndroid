package com.salyangoz.edad.model;

/**
 * Created by sercangok on 27/08/14.
 */
public class Temsilcilik {
    @SuppressWarnings("temsilciid")
    protected String temsilciid;
    @SuppressWarnings("temsilciadi")
    protected String temsilciadi;
    @SuppressWarnings("isim")
    protected String isim;
    @SuppressWarnings("adres")
    protected String adres;
    @SuppressWarnings("tel")
    protected String tel;
    @SuppressWarnings("email")
    protected String email;
    @SuppressWarnings("gsm")
    protected String gsm;
    @SuppressWarnings("faks")
    protected String faks;

    public String getFaks() {
        return faks;
    }

    public void setFaks(String faks) {
        this.faks = faks;
    }

    public String getTemsilciid() {
        return temsilciid;
    }

    public void setTemsilciid(String temsilciid) {
        this.temsilciid = temsilciid;
    }

    public String getTemsilciUnvan() {
        return temsilciadi;
    }

    public void setTemsilciUnvan(String temsilciUnvan) {
        this.temsilciadi = temsilciUnvan;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }
}
