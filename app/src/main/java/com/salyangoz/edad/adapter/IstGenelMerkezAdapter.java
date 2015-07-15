package com.salyangoz.edad.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.salyangoz.edad.R;
import com.salyangoz.edad.model.IstGenelMerkez;
import com.salyangoz.edad.util.TelFunction;
import com.salyangoz.edad.view.TextView300;
import com.salyangoz.edad.view.TextView500;

import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class IstGenelMerkezAdapter extends ArrayAdapter<IstGenelMerkez> {
    private LayoutInflater inflater;
    View row;
    public TextView500 txtUnvan;
    public TextView300 txtIsım;
    public TextView300 txtAdres;
    public TextView300 txtTel;
    public TextView300 txtEvtel;
    public TextView300 txtMail;
    public TextView300 txtFax;
    public ImageView imgProfil;
    public ImageView imgAdres;
    public ImageView imgTel;
    public ImageView imgEvtel;
    public ImageView imgMail;
    private LinearLayout lnrTelefon, lnrFax;

    public IstGenelMerkezAdapter(Context context, int resource, List<IstGenelMerkez> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.row_istgenelmerkez, null);
        txtIsım = (TextView300) row.findViewById(R.id.txtIsım);
        txtUnvan = (TextView500) row.findViewById(R.id.txtUnvan);
        txtAdres = (TextView300) row.findViewById(R.id.txtAdress);
        txtTel = (TextView300) row.findViewById(R.id.txtTel);
        txtEvtel = (TextView300) row.findViewById(R.id.txtEvTel);
        txtMail = (TextView300) row.findViewById(R.id.txtMail);
        txtFax = (TextView300) row.findViewById(R.id.txtFax);
        imgAdres = (ImageView) row.findViewById(R.id.imgAdress);
        imgTel = (ImageView) row.findViewById(R.id.imgTel);
        imgEvtel = (ImageView) row.findViewById(R.id.imgEvTel);
        imgMail = (ImageView) row.findViewById(R.id.imgMail);
        lnrTelefon = (LinearLayout) row.findViewById(R.id.lnrTelefon);
        lnrFax = (LinearLayout) row.findViewById(R.id.lnrFaks);

        txtIsım.setText(getItem(position).getIsim());
        txtUnvan.setText(getItem(position).getUnvan());
        txtAdres.setText(getItem(position).getAdres());
        if (getItem(position).getGsm() != "")
            txtTel.setText(getItem(position).getGsm());
        else
            lnrTelefon.setVisibility(View.GONE);
        if (getItem(position).getFax() != "")
            txtFax.setText(getItem(position).getFax());
        else
            lnrFax.setVisibility(View.GONE);
        txtEvtel.setText(getItem(position).getTel());
        txtMail.setText(getItem(position).getEmail());


        ((LinearLayout) row.findViewById(R.id.lnrTelefon)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(TelFunction.getInstance(getItem(position).getGsm()).call());
            }
        });
        ((LinearLayout) row.findViewById(R.id.lnrEvTel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(TelFunction.getInstance(getItem(position).getTel()).call());
            }
        });
        ((LinearLayout) row.findViewById(R.id.lnrMail)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(Intent.createChooser(TelFunction.getInstance(getItem(position).getEmail(), "", "").sendMail(), "Send Email"));
            }
        });
        ((LinearLayout) row.findViewById(R.id.lnrFaks)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getContext().startActivity(TelFunction.getInstance(getItem(position).getFax()).call());
            }
        });
        return row;
    }

    public View getVieww(int position, View convertView, ViewGroup parent) {
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
            holder.txtAdSoyad.setText(getItem(position).getIsim().toUpperCase() + " SALYANGOZ");
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
