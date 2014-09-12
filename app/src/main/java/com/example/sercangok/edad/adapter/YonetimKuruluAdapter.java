package com.example.sercangok.edad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.YonetimKurulu;

import java.util.List;

/**
 * Created by sercangok on 27/08/14.
 */
public class YonetimKuruluAdapter extends ArrayAdapter<YonetimKurulu> {
    private View row;
    private LayoutInflater inflater;
    private TextView txtAdSoyad, txtPozisyon;
    private ImageView imgProfil;

    public YonetimKuruluAdapter(Context context, int resource, List<YonetimKurulu> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.cell_yonetimkurulu, null);
        txtAdSoyad = (TextView) row.findViewById(R.id.txtAdSoyad);
        txtPozisyon = (TextView) row.findViewById(R.id.txtPozisyon);
        imgProfil = (ImageView) row.findViewById(R.id.imgProfile);
        txtAdSoyad.setText(getItem(position).getIsim());
        txtPozisyon.setText(getItem(position).getUnvan());
        return row;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
