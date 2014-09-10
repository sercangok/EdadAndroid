package com.example.sercangok.edad.util;

import java.util.Calendar;

/**
 * Created by sercangok on 01/09/14.
 */
public class KongreInfo {
    public int kongreYil;
    public int kongreAy;
    public int kongreGun;
    public static KongreInfo ilkGun;
    public static KongreInfo ikinciGun;
    public static KongreInfo sonGUn;

    public KongreInfo() {
        ilkGun = new KongreInfo(2014, Calendar.OCTOBER, 17);
        ikinciGun = new KongreInfo(2014, Calendar.OCTOBER, 18);
        sonGUn = new KongreInfo(2014, Calendar.OCTOBER, 19);
    }

    public KongreInfo(int kongreYil, int kongreAy, int kongreGun) {
        this.kongreYil = kongreYil;
        this.kongreAy = kongreAy;
        this.kongreGun = kongreGun;
    }
}
