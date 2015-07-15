package com.salyangoz.edad.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sercangok on 27/08/14.
 */
public class Program {
    public Calendar calendarBaslangic;
    public Calendar calendarBitis;
    private String title;
    private String yapılcak;
    private String adres;
    public boolean saatlikEvent;

    public Program(Calendar calendarBaslangic, Calendar calendarBitis, String title, String yapılcak) {
        this.calendarBaslangic = calendarBaslangic;
        this.calendarBitis = calendarBitis;
        this.yapılcak = yapılcak;
        this.title = title;
        saatlikEvent = false;
    }

    public Program(Calendar calS, Calendar calF, String yapılcak, String adres, boolean isSosyal) {
        this.calendarBaslangic = calS;
        this.calendarBitis = calF;
        this.yapılcak = yapılcak;
        this.adres = adres;
        saatlikEvent = false;
    }

    public String getYapılcak() {
        return yapılcak;
    }

    public String getTitle() {
        return title;
    }

    public String getAdress() {
        return adres;
    }

    @Override
    public String toString() {
        String returnedString;
        SimpleDateFormat smpHour = new SimpleDateFormat("k");
        SimpleDateFormat smpMin = new SimpleDateFormat("m");
        Date baslangicDate = calendarBaslangic.getTime();
        Date bitisDate = calendarBitis.getTime();
        returnedString = (Integer.parseInt(smpHour.format(baslangicDate)) < 10 ? "0" + smpHour.format(baslangicDate) : smpHour.format(baslangicDate))
                + ":" + (Integer.parseInt(smpMin.format(baslangicDate)) < 10 ? "0" + smpMin.format(baslangicDate) : smpMin.format(baslangicDate))
                + " - " + (Integer.parseInt(smpHour.format(bitisDate)) < 10 ? "0" + smpHour.format(bitisDate) : smpHour.format(bitisDate))
                + ":" + (Integer.parseInt(smpMin.format(bitisDate)) < 10 ? "0" + smpMin.format(bitisDate) : smpMin.format(bitisDate));
        return returnedString;
    }
}
