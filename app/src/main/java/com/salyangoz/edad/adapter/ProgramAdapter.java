package com.salyangoz.edad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.salyangoz.edad.R;
import com.salyangoz.edad.model.Program;
import com.salyangoz.edad.util.CalenderUtil;
import com.salyangoz.edad.view.TextView300;
import com.salyangoz.edad.view.TextView500;

import java.util.List;

/**
 * Created by sercangok on 01/09/14.
 */
public class ProgramAdapter extends ArrayAdapter<Program> {
    private LayoutInflater inflater;
    private View row;
    private TextView300 txtSaat, txtAcıklama;
    private TextView500 txtTitle, txtTitle2;
    private ImageButton imgTakvimeEkle;
    private LinearLayout lnrPanel;

    public ProgramAdapter(Context context, int resource, List<Program> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.row_program, null);
        getItem(position).saatlikEvent = true;
        txtSaat = (TextView300) row.findViewById(R.id.txtSaat);
        txtAcıklama = (TextView300) row.findViewById(R.id.txtAcıklama);
        imgTakvimeEkle = (ImageButton) row.findViewById(R.id.imgTakvimeEkle);
        txtTitle = (TextView500) row.findViewById(R.id.txtTitle);
        txtTitle2 = (TextView500) row.findViewById(R.id.txtTitle2);
        lnrPanel = (LinearLayout) row.findViewById(R.id.lnrTextPanel);
        txtSaat.setText(getItem(position).toString());
        if (getItem(position).getYapılcak().equals("")) {
            lnrPanel.setVisibility(View.GONE);
            txtTitle2.setVisibility(View.VISIBLE);
            txtTitle2.setText(getItem(position).getTitle());
        } else {
            txtAcıklama.setText(getItem(position).getYapılcak());
            txtTitle.setText(getItem(position).getTitle());
        }
        imgTakvimeEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CalenderUtil.getInstanceEdadKongreProgram(ProgramAdapter.this.getContext(), getItem(position));
            }
        });
        return row;

    }
}
