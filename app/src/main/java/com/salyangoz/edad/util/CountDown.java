package com.salyangoz.edad.util;

import java.util.Calendar;

/**
 * Created by sercangok on 09/09/14.
 */
public class CountDown {
    private static float oneMinuteInSec = 60;
    private static float oneHourInSec = oneMinuteInSec * 60;
    private static float oneDayInSec = oneHourInSec * 24;
    private static float oneWeekInSec = oneDayInSec * 7;
    private static float dateInSec;
    public static float temp;
    public static float leftWeek;
    public static float leftDay;
    public static float leftHour;
    public static float leftMin;

    public CountDown(long dateInSec) {
        this.dateInSec = dateInSec;
        calculate();
    }

    public static CountDown getInstance(long dateInSec) {
        return new CountDown(dateInSec);
    }

    private void calculate() {

        temp = (int) (dateInSec / oneWeekInSec);
        dateInSec = dateInSec - (temp * oneWeekInSec);
        leftWeek = temp;

        temp = (int) Math.floor(dateInSec / oneDayInSec);
        dateInSec = dateInSec - (temp * oneDayInSec);
        leftDay = temp;

        temp = (int) Math.floor(dateInSec / oneHourInSec);
        dateInSec = dateInSec - (temp * oneHourInSec);
        leftHour = temp;

        temp = (int) Math.floor(dateInSec / oneMinuteInSec);
        dateInSec = dateInSec - (temp * oneMinuteInSec);
        leftMin = temp;

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_YEAR, (int) leftWeek);
        cal.add(Calendar.DAY_OF_MONTH, (int) leftDay);
        cal.add(Calendar.HOUR, (int) leftHour);
        cal.add(Calendar.MINUTE, (int) leftMin);
    }

}
