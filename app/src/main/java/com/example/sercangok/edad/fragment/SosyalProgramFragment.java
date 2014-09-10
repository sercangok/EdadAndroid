package com.example.sercangok.edad.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Programlar;
import com.example.sercangok.edad.view.TextView300;

/**
 * Created by sercangok on 09/09/14.
 */
public class SosyalProgramFragment extends Fragment {
    private View row;
    private int position = -1;
    private TextView300 txtIsım, txtTarih, txtAdress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        row = inflater.inflate(R.layout.fragment_sosyalprogram, null);
        Bundle bnd = this.getArguments();
        position = bnd.getInt("position");
        init();
        return row;
    }

    private void init() {
        txtIsım = (TextView300) row.findViewById(R.id.txtIsım);
        txtTarih = (TextView300) row.findViewById(R.id.txtTarih);
        txtAdress = (TextView300) row.findViewById(R.id.txtAdress);
        if (position == 1) {
            txtIsım.setText(Programlar.sosyalProgramGala.getYapılcak());
            txtTarih.setText(Programlar.sosyalProgramGala.toString());
            txtAdress.setText("Ankara");
        } else {
            txtIsım.setText(Programlar.sosyalProgramKokteyl.getYapılcak());
            txtTarih.setText(Programlar.sosyalProgramKokteyl.toString());
            txtAdress.setText("Ankara");
        }
    }
}
