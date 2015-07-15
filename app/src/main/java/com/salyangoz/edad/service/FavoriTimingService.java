package com.salyangoz.edad.service;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.salyangoz.edad.R;
import com.salyangoz.edad.activity.mainActivity.MainActivity;
import com.salyangoz.edad.model.Etkinlik;

import java.util.Calendar;

/**
 * Created by sercangok on 22/09/14.
 */
public class FavoriTimingService extends Service {
    Etkinlik etkinlik;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        etkinlik = (Etkinlik) intent.getSerializableExtra("etkinlik");
        int kalanGün = (int) intent.getIntExtra("kalangün", 0);
        if (kalanGün == 15) {
            sendNotification(etkinlik.getIsim() + "  etkinliğine son 15 gün.");
            setAlarmManager();
        } else if (kalanGün == 3)
            sendNotification(etkinlik.getIsim() + "  etkinliğine son 3 gün.");
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendNotification(String msg) {
        NotificationManager mNotificationManager = (NotificationManager)
                this.getSystemService(Context.NOTIFICATION_SERVICE);

        PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, MainActivity.class), 0);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.logo)
                        .setContentTitle(getString(R.string.app_name))
                        .setStyle(new NotificationCompat.BigTextStyle()
                                .bigText(msg))
                        .setContentText(msg);

        mBuilder.setContentIntent(contentIntent);
        mNotificationManager.notify(1, mBuilder.build());
    }

    private void setAlarmManager() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(etkinlik.getBaslangictarihi());
        calendar.add(Calendar.DAY_OF_MONTH, -15);

        calendar.setTime(Calendar.getInstance().getTime());
        calendar.add(Calendar.SECOND, 30);
        calendar.add(Calendar.SECOND, -15);

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        Intent _myIntent = new Intent(this, FavoriTimingService.class);
        _myIntent.putExtra("etkinlik", etkinlik);
        _myIntent.putExtra("kalangün", 3);
        PendingIntent _myPendingIntent = PendingIntent.getService(this, 0, _myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), _myPendingIntent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
