package com.salyangoz.edad.service;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

import com.salyangoz.edad.R;
import com.salyangoz.edad.activity.mainActivity.MainActivity;
import com.google.android.gms.gcm.GoogleCloudMessaging;

/**
 * Created by sercangok on 30/08/14.
 */
public class GcmIntentService extends IntentService {
    public static final int NOTIFICATION_ID = 1;
    private int number=0;
    private NotificationManager mNotificationManager;
    NotificationCompat.Builder builder;

    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {
            if (GoogleCloudMessaging.ERROR_MAIN_THREAD.equals(messageType)) {

            } else if (GoogleCloudMessaging.MESSAGE_TYPE_DELETED.equals(messageType)) {

            } else if (GoogleCloudMessaging.ERROR_SERVICE_NOT_AVAILABLE.equals(messageType)) {

            } else if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                sendNotification(extras.getString("message"));

            } else if (GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR.equals(messageType)) {

            }
        }
    }


    private void sendNotification(String msg) {
        mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle(getString(R.string.app_name))
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setNumber(number)
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(NOTIFICATION_ID, mBuilder.build());
        number++;
    }
}
