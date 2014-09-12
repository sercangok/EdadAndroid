package com.example.sercangok.edad.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Program;
import com.example.sercangok.edad.model.Programlar;
import com.example.sercangok.edad.view.ExpandableHeightGridView;
import com.example.sercangok.edad.view.TextView300;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sercangok on 09/09/14.
 */
public class SosyalProgramFragment extends Fragment {
    private View row;
    private int position = -1;
    private TextView300 txtIsım, txtTarih, txtAdress;
    private ExpandableHeightGridView lst;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        row = inflater.inflate(R.layout.fragment_test, null);
        Bundle bnd = this.getArguments();
        position = bnd.getInt("position");
        //init();
        lst = (ExpandableHeightGridView) row.findViewById(R.id.heightView);
        List<Program> list = new ArrayList<Program>();
        if (position == 1)
            list.add(Programlar.sosyalProgramKokteyl);
        else
            list.add(Programlar.sosyalProgramGala);
        lst.setExpanded(true);
        lst.setAdapter(new adapter(getActivity().getApplicationContext(), R.layout.fragment_sosyalprogram, list));
        return row;
    }

    private void init() {

        txtIsım = (TextView300) row.findViewById(R.id.txtIsım);
        txtTarih = (TextView300) row.findViewById(R.id.txtTarih);
        txtAdress = (TextView300) row.findViewById(R.id.txtAdress);
        if (position == 1) {
            txtIsım.setText(Programlar.sosyalProgramGala.getYapılcak());
            txtTarih.setText(Programlar.sosyalProgramGala.toString());
            //txtAdress.setText("Ankara");
        } else {
            txtIsım.setText(Programlar.sosyalProgramKokteyl.getYapılcak());
            txtTarih.setText(Programlar.sosyalProgramKokteyl.toString());
            //txtAdress.setText("Ankara");
        }
    }

    public class adapter extends ArrayAdapter<Program> {
        private LayoutInflater inflater;
        private TextView300 txtIsım, txtTarih, txtAdress;

        public adapter(Context context, int resource, List<Program> objects) {
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
            txtTarih.setText(getItem(position).toString());
            return row;
        }
    }
}
