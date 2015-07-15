package com.salyangoz.edad.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.salyangoz.edad.R;

import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class SeminerAdapter extends ArrayAdapter<List<String>> {
    private LayoutInflater inflater;

    public SeminerAdapter(Context context, int resource, List<List<String>> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_istgenelmerkez, null);
            holder = new ViewHolder();
            holder.txtPozisyon = (TextView) convertView.findViewById(R.id.txtPozisyon);
            holder.txtAdSoyad = (TextView) convertView.findViewById(R.id.txtAdSoyad);
            holder.txtAdres = (TextView) convertView.findViewById(R.id.txtAdress);
            holder.txtTel = (TextView) convertView.findViewById(R.id.txtTel);
            holder.txtEvtel = (TextView) convertView.findViewById(R.id.txtEvTel);
            holder.txtMail = (TextView) convertView.findViewById(R.id.txtMail);
            holder.imgProfil = (ImageView) convertView.findViewById(R.id.imgProfile);
            holder.imgAdres = (ImageView) convertView.findViewById(R.id.imgAdress);
            holder.imgTel = (ImageView) convertView.findViewById(R.id.imgTel);
            holder.imgEvtel = (ImageView) convertView.findViewById(R.id.imgEvTel);
            holder.imgMail = (ImageView) convertView.findViewById(R.id.imgMail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.txtPozisyon.setText("Genel Mudur");
            holder.txtAdSoyad.setText(getItem(position).toString().toUpperCase() + " SALYANGOZ");
            holder.txtAdres.setText("Gunesli MAh.");
            holder.txtTel.setText("05342751044");
            holder.txtEvtel.setText("02126561992");
            holder.txtMail.setText(getItem(position) + "@mail.com");
        }
        return convertView;
    }

    static class ViewHolder {
        public TextView txtPozisyon;
        public TextView txtAdSoyad;
        public TextView txtAdres;
        public TextView txtTel;
        public TextView txtEvtel;
        public TextView txtMail;
        public ImageView imgProfil;
        public ImageView imgAdres;
        public ImageView imgTel;
        public ImageView imgEvtel;
        public ImageView imgMail;
    }

}
