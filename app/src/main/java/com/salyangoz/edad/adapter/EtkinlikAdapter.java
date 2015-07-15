package com.salyangoz.edad.adapter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.salyangoz.edad.R;
import com.salyangoz.edad.interfaces.ProgramAddedToCalender;
import com.salyangoz.edad.model.Etkinlik;
import com.salyangoz.edad.service.FavoriTimingService;
import com.salyangoz.edad.util.CalenderUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by sercangok on 27/08/14.
 */
public class EtkinlikAdapter extends ArrayAdapter<Etkinlik> {
    View row;
    public TextView txtAd;
    public TextView txtTarih;
    public TextView txtAdres;
    public TextView txtKategori;
    public ImageView imgAd;
    public ImageView imgTarih;
    public ImageView imgAdres;
    public ImageView imgKategori;
    public FrameLayout frmTakvimeEkle;
    public ImageButton imgPin;
    public ImageButton imgFav;
    public static ProgramAddedToCalender mListener;
    LayoutInflater inflater;

    public EtkinlikAdapter(Context context, int resource, List<Etkinlik> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.row_etkinliklerimiz, null);
        txtAd = (TextView) row.findViewById(R.id.txtAd);
        txtTarih = (TextView) row.findViewById(R.id.txtTarih);
        txtKategori = (TextView) row.findViewById(R.id.txtKategori);
        txtAdres = (TextView) row.findViewById(R.id.txtAdress);
        imgAd = (ImageView) row.findViewById(R.id.imgAd);
        imgAdres = (ImageView) row.findViewById(R.id.imgAdress);
        imgTarih = (ImageView) row.findViewById(R.id.imgTarih);
        imgPin = (ImageButton) row.findViewById(R.id.imgPin);
        frmTakvimeEkle = (FrameLayout) row.findViewById(R.id.frmTakvimeEkle);
        txtAd.setText(getItem(position).getIsim());
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //txtTarih.setText(simpleDateFormat.format(getItem(position).getBaslangictarihi()));


        final Date timeeBaslangic = getItem(position).getBaslangictarihi();
        Date timeeBitis = getItem(position).getBitistarihi();
        SimpleDateFormat format = new SimpleDateFormat("d MMMM EEEE yyyy, ");
        SimpleDateFormat formatt = new SimpleDateFormat("d MMMM EEEE yyyy, k:m");
        SimpleDateFormat format2 = new SimpleDateFormat("k");
        SimpleDateFormat format3 = new SimpleDateFormat("m");
        String time = format.format(timeeBaslangic);
        String timeTemp = formatt.format(timeeBaslangic) + "\n" + formatt.format(timeeBitis);
        if (Integer.parseInt(format2.format(timeeBaslangic)) < 10)
            time += " 0" + format2.format(timeeBaslangic);
        else
            time += format2.format(timeeBaslangic);
        time += ":";
        if (Integer.parseInt(format3.format(timeeBaslangic)) < 10)
            time += "0" + format3.format(timeeBaslangic);
        else
            time += format3.format(timeeBaslangic);
        time += " \n" + format.format(timeeBitis);
        if (Integer.parseInt(format2.format(timeeBitis)) < 10)
            time += "0" + format2.format(timeeBitis);
        else
            time += format2.format(timeeBitis);
        time += ":";
        if (Integer.parseInt(format3.format(timeeBitis)) < 10)
            time += "0" + format3.format(timeeBitis);
        else
            time += format3.format(timeeBitis);
        txtTarih.setText(time);


        txtAdres.setText(getItem(position).getYer());
        txtKategori.setText(getItem(position).getKategoriismi());

        imgPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse("geo:" + getItem(position).getLat() + "," + getItem(position).getLon());
                intent.setData(geoLocation);
                if (intent.resolveActivity(getContext().getPackageManager()) != null) {
                    getContext().startActivity(intent);
                }
            }
        });


        frmTakvimeEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalenderUtil.getInstanceEdadKongreProgram(getContext(), getItem(position));
            }
        });


        ((ImageButton) row.findViewById(R.id.imgFav)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(getItem(position).getBaslangictarihi());
                calendar.add(Calendar.DAY_OF_MONTH, -15);

                calendar.setTime(Calendar.getInstance().getTime());
                calendar.add(Calendar.SECOND, 30);
                calendar.add(Calendar.SECOND, -15);

                AlarmManager alarmManager = (AlarmManager) getContext().getSystemService(Context.ALARM_SERVICE);
                Intent _myIntent = new Intent(getContext(), FavoriTimingService.class);
                _myIntent.putExtra("etkinlik", getItem(position));
                _myIntent.putExtra("kalangün", 15);
                PendingIntent _myPendingIntent = PendingIntent.getService(getContext(), 0, _myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), _myPendingIntent);
                mListener.readyToShowToast(true);
            }
        });

        switch (getItem(position).getKategoriid()) {
            case 1:
                row.setBackgroundResource(R.drawable.borderorange);
                return row;
            case 2:
                row.setBackgroundResource(R.drawable.bordergreen);
                return row;
            case 3:
                row.setBackgroundResource(R.drawable.borderblue);
                ((ImageButton) row.findViewById(R.id.imgFav)).setVisibility(View.VISIBLE);
                return row;
            default:
                return row;
        }
    }
}
