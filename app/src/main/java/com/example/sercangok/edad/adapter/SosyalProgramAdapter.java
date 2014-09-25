package com.example.sercangok.edad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Program;
import com.example.sercangok.edad.view.TextView300;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by sercangok on 16/09/14.
 */
public class SosyalProgramAdapter extends ArrayAdapter<Program> {
    private LayoutInflater inflater;
    private TextView300 txtIsım, txtTarih, txtAdress;
    private View row;

    public SosyalProgramAdapter(Context context, int resource, List<Program> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.fragment_sosyalprogram, null);
        txtIsım = (TextView300) row.findViewById(R.id.txtIsım);
        txtTarih = (TextView300) row.findViewById(R.id.txtTarih);
        txtAdress = (TextView300) row.findViewById(R.id.txtAdress);
        txtIsım.setText(getItem(position).getYapılcak());
        txtAdress.setText(getItem(position).getAdress());
        Date timeeBaslangic = getItem(position).calendarBaslangic.getTime();
        Date timeeBitis = getItem(position).calendarBitis.getTime();
        SimpleDateFormat format = new SimpleDateFormat("d MMMM EEEE yyyy, ");
        SimpleDateFormat format2 = new SimpleDateFormat("k");
        SimpleDateFormat format3 = new SimpleDateFormat("m");
        String time = format.format(timeeBaslangic);
        if (Integer.parseInt(format2.format(timeeBaslangic)) < 10)
            time += " 0" + format2.format(timeeBaslangic);
        else
            time += format2.format(timeeBaslangic);
        time += ":";
        if (Integer.parseInt(format3.format(timeeBaslangic)) < 10)
            time += "0" + format3.format(timeeBaslangic);
        else
            time += format3.format(timeeBaslangic);
        time += " - ";
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
        return row;
    }
}

