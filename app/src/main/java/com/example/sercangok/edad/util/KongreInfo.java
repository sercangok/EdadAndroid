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
        ilkGun = new KongreInfo(2015, Calendar.OCTOBER, 2);
        ikinciGun = new KongreInfo(2015, Calendar.OCTOBER, 3);
        sonGUn = new KongreInfo(2015, Calendar.OCTOBER, 4);
    }

    public KongreInfo(int kongreYil, int kongreAy, int kongreGun) {
        this.kongreYil = kongreYil;
        this.kongreAy = kongreAy;
        this.kongreGun = kongreGun;
    }
}
