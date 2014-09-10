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

    public CalenderUtil(Context context) {
        this.context = context;
        beginTime = Calendar.getInstance();
        endTime = Calendar.getInstance();
        beginTime.set(2014, Calendar.OCTOBER, 17, 9, 30);
        endTime.set(2014, Calendar.OCTOBER, 19, 15, 30);
        _beginTime = beginTime.getTimeInMillis();
        _endTime = endTime.getTimeInMillis();
        setRemainder(addEventToCalender(getCalenders().get(0)));
    }

    public CalenderUtil(Context context, Program program) {
        this.context = context;
        this.beginTime = program.calendarBaslangic;
        this.endTime = program.calendarBitis;
        _beginTime = beginTime.getTimeInMillis();
        _endTime = endTime.getTimeInMillis();
        setRemainder(addEventToCalender(getCalenders().get(0), program));
    }

    public CalenderUtil(Context context, Etkinlik etkinlik) {
        this.context = context;
        this.beginTime = Calendar.getInstance();
        this.endTime = Calendar.getInstance();
        this.beginTime.setTime(etkinlik.getTarih());
        this.endTime.setTime(etkinlik.getTarih());
        this.endTime.add(Calendar.HOUR, 2);
        _beginTime = beginTime.getTimeInMillis();
        _endTime = endTime.getTimeInMillis();
        setRemainder(addEventToCalender(getCalenders().get(0), etkinlik));
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
        values.put(CalendarContract.Events.TITLE, "EDAD KONGRE");
        values.put(CalendarContract.Events.DESCRIPTION, etkinlik.getIsim());
        values.put(CalendarContract.Events.CALENDAR_ID, calID);
        values.put(CalendarContract.Events.EVENT_TIMEZONE, "Turkey/Istanbul");
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
        values.put(CalendarContract.Reminders.MINUTES, 30);
        values.put(CalendarContract.Reminders.EVENT_ID, eventID);
        values.put(CalendarContract.Reminders.METHOD, CalendarContract.Reminders.METHOD_ALERT);
        Uri uri = cr.insert(CalendarContract.Reminders.CONTENT_URI, values);
        mListener.readyToShowToast();
    }


}
