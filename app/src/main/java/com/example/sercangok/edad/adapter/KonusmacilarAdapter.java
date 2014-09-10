package com.example.sercangok.edad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Konusmaci;

import java.util.List;

/**
 * Created by sercangok on 28/08/14.
 */
public class KonusmacilarAdapter extends ArrayAdapter<Konusmaci> {
    View row;
    LayoutInflater inflater;
    ImageView imgProfil;
    TextView txtKonusmaci;

    public KonusmacilarAdapter(Context context, int resource, List<Konusmaci> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.cell_yonetimkurulu, null);
        imgProfil = (ImageView) row.findViewById(R.id.imgProfile);
        txtKonusmaci = (TextView) row.findViewById(R.id.txtAdSoyad);
        ((TextView) row.findViewById(R.id.txtPozisyon)).setText("KONUŞMACI");
        txtKonusmaci.setText(getItem(position).getAdi());
        imgProfil.setImageDrawable(getItem(position).getResim());
        return row;
    }
}
