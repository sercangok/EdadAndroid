package com.example.sercangok.edad.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.model.Temsilcilik;
import com.example.sercangok.edad.util.TelFunction;

import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class TemsilcilikAdapter extends ArrayAdapter<Temsilcilik> {
    private LayoutInflater inflater;
    View row;
    public TextView txtIsım;
    public TextView txtUnvan;
    public TextView txtAdres;
    public TextView txtTel;
    public TextView txtCep;
    public TextView txtMail;
    public TextView txtFax;
    public ImageView imgProfil;
    public ImageView imgAdres;
    public ImageView imgTel;
    public ImageView imgMail;
    private LinearLayout lnrFax;


    public TemsilcilikAdapter(Context context, int resource, List<Temsilcilik> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.row_temsilciliklerimiz, null);
        txtIsım = (TextView) row.findViewById(R.id.txtIsım);
        txtUnvan = (TextView) row.findViewById(R.id.txtUnvan);
        txtAdres = (TextView) row.findViewById(R.id.txtAdress);
        txtTel = (TextView) row.findViewById(R.id.txtEvTel);
        txtCep = (TextView) row.findViewById(R.id.txtTel);
        txtMail = (TextView) row.findViewById(R.id.txtMail);
        txtFax = (TextView) row.findViewById(R.id.txtFax);
        imgAdres = (ImageView) row.findViewById(R.id.imgAdress);
        imgTel = (ImageView) row.findViewById(R.id.imgTel);
        imgMail = (ImageView) row.findViewById(R.id.imgMail);
        lnrFax = (LinearLayout) row.findViewById(R.id.lnrFaks);

        txtIsım.setText(getItem(position).getIsim());
        txtUnvan.setText(getItem(position).getTemsilciUnvan());
        txtAdres.setText(getItem(position).getAdres());
        txtTel.setText(getItem(position).getTel());
        txtCep.setText(getItem(position).getGsm() != "" ? getItem(position).getGsm() : "--");
        txtMail.setText(getItem(position).getEmail());

        if (getItem(position).getFaks() != "")
            txtFax.setText(getItem(position).getFaks());
        else
            lnrFax.setVisibility(View.GONE);

        ((LinearLayout) row.findViewById(R.id.lnrTel)).setOnClickListener(new View.OnClickListener() {
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
                getContext().startActivity(TelFunction.getInstance(getItem(position).getFaks()).call());
            }
        });
        return row;
    }

    public View getVieww(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_temsilciliklerimiz, null);
            holder = new ViewHolder();
            holder.txtIsım = (TextView) convertView.findViewById(R.id.txtIsım);
            holder.txtUnvan = (TextView) convertView.findViewById(R.id.txtUnvan);
            holder.txtAdres = (TextView) convertView.findViewById(R.id.txtAdress);
            holder.txtTel = (TextView) convertView.findViewById(R.id.txtTel);
            holder.txtMail = (TextView) convertView.findViewById(R.id.txtMail);
            holder.imgAdres = (ImageView) convertView.findViewById(R.id.imgAdress);
            holder.imgTel = (ImageView) convertView.findViewById(R.id.imgTel);
            holder.imgMail = (ImageView) convertView.findViewById(R.id.imgMail);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.txtIsım.setText(getItem(position).getIsim());
            holder.txtUnvan.setText(getItem(position).getTemsilciUnvan());
            holder.txtAdres.setText(getItem(position).getAdres());
            holder.txtTel.setText(getItem(position).getTel());
            holder.txtMail.setText(getItem(position).getEmail());
        }
        return convertView;
    }

    static class ViewHolder {
        public TextView txtIsım;
        public TextView txtUnvan;
        public TextView txtAdres;
        public TextView txtTel;
        public TextView txtMail;
        public ImageView imgProfil;
        public ImageView imgAdres;
        public ImageView imgTel;
        public ImageView imgMail;
    }
}
