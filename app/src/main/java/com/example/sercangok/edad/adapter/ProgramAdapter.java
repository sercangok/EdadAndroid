package com.example.sercangok.edad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Program;
import com.example.sercangok.edad.util.CalenderUtil;
import com.example.sercangok.edad.view.TextView300;

import java.util.List;

/**
 * Created by sercangok on 01/09/14.
 */
public class ProgramAdapter extends ArrayAdapter<Program> {
    private LayoutInflater inflater;
    private View row;
    private TextView300 txtSaat, txtAcıklama;
    private ImageButton imgTakvimeEkle;

    public ProgramAdapter(Context context, int resource, List<Program> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.row_program, null);
        txtSaat = (TextView300) row.findViewById(R.id.txtSaat);
        txtAcıklama = (TextView300) row.findViewById(R.id.txtAcıklama);
        imgTakvimeEkle = (ImageButton) row.findViewById(R.id.imgTakvimeEkle);
        txtSaat.setText(getItem(position).toString());
        txtAcıklama.setText(getItem(position).getYapılcak());
        imgTakvimeEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalenderUtil.getInstanceEdadKongreProgram(ProgramAdapter.this.getContext(), getItem(position));
            }
        });
        return row;

    }
}
