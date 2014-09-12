package com.example.sercangok.edad.util;

import android.content.Intent;
import android.net.Uri;

/**
 * Created by sercangok on 12/09/14.
 */
public class TelFunction {
    public String telNumber;
    public String mail;
    public String subject;
    public String text;

    public TelFunction() {
    }

    public TelFunction(String telNumber) {
        this.telNumber = telNumber;
    }

    public TelFunction(String mail, String subject, String text) {
        this.mail = mail;
        this.subject = subject;
        this.text = text;
    }

    public static TelFunction getInstance(String mail, String subject, String text) {
        return new TelFunction(mail, subject, text);
    }

    public static TelFunction getInstance(String number) {
        return new TelFunction(number);
    }

    public Intent sendMail() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[]{mail});
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        return intent;
        //startActivity(Intent.createChooser(intent, "Send Email"));

    }

    public Intent call() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + telNumber));
        return intent;
    }
}
