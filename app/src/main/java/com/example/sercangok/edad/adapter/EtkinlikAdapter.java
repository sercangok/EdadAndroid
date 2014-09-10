package com.example.sercangok.edad.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Etkinlik;
import com.example.sercangok.edad.util.CalenderUtil;

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
        txtTarih.setText(getItem(position).getTarih().toString());
        txtAdres.setText(getItem(position).getYer());
        txtKategori.setText(getKategoriName(getItem(position).getKategoriid()));

        imgPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(geoLocation);
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

        switch (getItem(position).getKategoriid()) {
            case 1:
                row.setBackground(getContext().getResources().getDrawable(R.drawable.borderblue));
                return row;
            case 2:
                row.setBackground(getContext().getResources().getDrawable(R.drawable.bordergreen));
                return row;
            case 3:
                row.setBackground(getContext().getResources().getDrawable(R.drawable.borderorange));
                return row;
            default:
                return row;
        }
    }

    private String getKategoriName(int kategoriid) {
        switch (kategoriid) {
            case 0:
                return "KONGRE";
            case 1:
                return "SEMPOZYUM";
            case 2:
                return "SEMİNER";
            case 3:
                return "KURS";
            default:
                return "HATA!";
        }
    }
}
