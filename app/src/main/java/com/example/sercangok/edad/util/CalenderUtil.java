package com.example.sercangok.edad.util;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;

import com.example.sercangok.edad.interfaces.ProgramAddedToCalender;
import com.example.sercangok.edad.model.Etkinlik;
import com.example.sercangok.edad.model.Program;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by sercangok on 28/08/14.
 */
public class CalenderUtil {
    private Context context;
    private Calendar beginTime;
    private Calendar endTime;
    private long _beginTime;
    private long _endTime;
    private long eventID;
    private List<Long> calenderIDList;
    public static ProgramAddedToCalender mListener;
    private int remainderMinute = 30;

    public CalenderUtil(Context context) {
        this.context = context;
        beginTime = Calendar.getInstance();
        endTime = Calendar.getInstance();
        beginTime.set(2015, Calendar.OCTOBER, 2, 8, 0);
        endTime.set(2015, Calendar.OCTOBER, 4, 15, 30);
        _beginTime = beginTime.getTimeInMillis();
        _endTime = endTime.getTimeInMillis();
        setRemainderEdadKongre(addEventToCalender(getCalenders().get(0)));
    }

    public CalenderUtil(Context context, Program program) {
        this.context = context;
        this.beginTime = program.calendarBaslangic;
        this.endTime = program.calendarBitis;
        _beginTime = beginTime.getTimeInMillis();
        _endTime = endTime.getTimeInMillis();
        if (program.saatlikEvent) {
            remainderMinute = 10;
            setRemainder(addEventToCalender(getCalenders().get(0), program));
        } else
            setRemainderEdadKongre(addEventToCalender(getCalenders().get(0), program));
    }

    public CalenderUtil(Context context, Etkinlik etkinlik) {
        switch (etkinlik.getKategoriid()) {
            case 1:
                remainderMinute = 3 * 60;
                break;
            case 2:
                remainderMinute = 3 * 60;
                break;
            case 3:
                remainderMinute = 24 * 60;
                break;
        }
        this.context = context;
        this.beginTime = Calendar.getInstance();
        this.endTime = Calendar.getInstance();
        this.beginTime.setTime(etkinlik.getBaslangictarihi());
        this.endTime.setTime(etkinlik.getBitistarihi());
        _beginTime = beginTime.getTimeInMillis();
        _endTime = endTime.getTimeInMillis();
        if (etkinlik.getKategoriid() == 1)
            setRemainderEventActivity(addEventToCalender(getCalenders().get(0), etkinlik), true);
        else
            setRemainderEventActivity(addEventToCalender(getCalenders().get(0), etkinlik), false);
        //setRemainder(addEventToCalender(getCalenders().get(0), etkinlik));
    }


    public static CalenderUtil getInstanceEdadKongre(Context con) {
        return new CalenderUtil(con);
    }

    public static CalenderUtil getInstanceEdadKongreProgram(Context con, Program p) {
        return new CalenderUtil(con, p);
    }

    public static CalenderUtil getInstanceEdadKongreProgram(Context con, Etkinlik e) {
        return new CalenderUtil(con, e);
    }

    private Long addEventToCalender(long calID) {
        ContentResolver cr = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, _beginTime);
        values.put(CalendarContract.Events.DTEND, _endTime);
        values.put(CalendarContract.Events.TITLE, "EDAD KONGRE");
        values.put(CalendarContract.Events.DESCRIPTION, "Group workout");
        values.put(CalendarContract.Events.CALENDAR_ID, calID);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, "Turkey/Istanbul");
        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
        return Long.parseLong(uri.getLastPathSegment());
    }

    private Long addEventToCalender(long calID, Program program) {
        ContentResolver cr = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, _beginTime);
        values.put(CalendarContract.Events.DTEND, _endTime);
        values.put(CalendarContract.Events.TITLE, "EDAD KONGRE");
        values.put(CalendarContract.Events.DESCRIPTION, program.getYapılcak());
        values.put(CalendarContract.Events.CALENDAR_ID, calID);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, "Turkey/Istanbul");
        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
        return Long.parseLong(uri.getLastPathSegment());
    }

    private Long addEventToCalender(long calID, Etkinlik etkinlik) {
        ContentResolver cr = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Events.DTSTART, _beginTime);
        values.put(CalendarContract.Events.DTEND, _endTime);
        values.put(CalendarContract.Events.TITLE, etkinlik.getKategoriismi());
        values.put(CalendarContract.Events.DESCRIPTION, etkinlik.getIsim());
        values.put(CalendarContract.Events.CALENDAR_ID, calID);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, "Turkey/Istanbul");
        values.put(CalendarContract.Events.EVENT_LOCATION, etkinlik.getYer());
        Uri uri = cr.insert(CalendarContract.Events.CONTENT_URI, values);
        return Long.parseLong(uri.getLastPathSegment());
    }

    public List<Long> getCalenders() {
        List<Long> calenderIDList = new ArrayList<Long>();
        String[] EVENT_PROJECTION = new String[]{
                CalendarContract.Calendars._ID,
        };
        Cursor cur = null;
        ContentResolver cr = context.getContentResolver();
        Uri uri = CalendarContract.Calendars.CONTENT_URI;
        cur = cr.query(uri, EVENT_PROJECTION, null, null, null);
        while (cur.moveToNext()) {
            long calIDs = cur.getLong(cur.getColumnIndex(CalendarContract.Calendars._ID));
            calenderIDList.add(calIDs);
        }
        return calenderIDList;
    }

    public void setRemainder(long eventID) {
        ContentResolver cr = context.getContentResolver();
        ContentValues values = new ContentValues();
        values.put(CalendarContract.Reminders.MINUTES, remainderMinute);
        values.put(CalendarContract.Reminders.EVENT_ID, eventID);
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
        Uri uri = cr.insert(CalendarContract.Reminders.CONTENT_URI, values);
        mListener.readyToShowToast(false);
    }

    public void setRemainderEventActivity(long eventID, boolean isAksamToplantisi) {
        for (int i = 0; i < 2; i++) {
            if (i == 0 && !isAksamToplantisi) remainderMinute = 15 * 24 * 60;
            else if (i == 0 && isAksamToplantisi) remainderMinute = 24 * 60;
            else remainderMinute = 3 * 24 * 60;
            ContentResolver cr = context.getContentResolver();
            ContentValues values = new ContentValues();
            values.put(CalendarContract.Reminders.MINUTES, remainderMinute);
            values.put(CalendarContract.Reminders.EVENT_ID, eventID);
            values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
            Uri uri = cr.insert(CalendarContract.Reminders.CONTENT_URI, values);
        }
        mListener.readyToShowToast(false);
    }

    private void setRemainderEdadKongre(Long eventID) {
        for (int i = 1; i <= 3; i++) {
            if (i == 1) remainderMinute = 3 * 24 * 60;
            else if (i == 2) remainderMinute = 24 * 60;
            else remainderMinute = 60;
            ContentResolver cr = context.getContentResolver();
            ContentValues values = new ContentValues();
            values.put(CalendarContract.Reminders.MINUTES, remainderMinute);
            values.put(CalendarContract.Reminders.EVENT_ID, eventID);
            values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
            Uri uri = cr.insert(CalendarContract.Reminders.CONTENT_URI, values);
        }
        mListener.readyToShowToast(false);
    }

}
