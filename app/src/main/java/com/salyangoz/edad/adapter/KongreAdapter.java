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
public class KongreAdapter extends ArrayAdapter<String> {
    private LayoutInflater inflater;

    public KongreAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.row_etkinliklerimiz, null);
            holder.txtAd = (TextView) convertView.findViewById(R.id.txtAd);
            holder.txtTarih = (TextView) convertView.findViewById(R.id.txtTarih);
            holder.txtAdres = (TextView) convertView.findViewById(R.id.txtAdress);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
            holder.txtAd.setText(getItem(position));
            holder.txtTarih.setText("4-6 Ekim");
            holder.txtAdres.setText("Istanbul Lütfi Kırdar Kongre Merkezi");
        }
        return convertView;
    }


    public View getHeaderView(int i, View converView, ViewGroup viewGroup) {
        HeaderViewHolder holder;
        if (converView == null) {
            holder = new HeaderViewHolder();
            converView = inflater.inflate(R.layout.custom_listview_header, viewGroup, false);
            holder.txtHeader = (TextView) converView.findViewById(R.id.txtHeader);
            converView.setTag(holder);
        } else {
            holder = (HeaderViewHolder) converView.getTag();
        }
        return converView;
    }


    public long getHeaderId(int i) {
        return 0;
    }

    static class HeaderViewHolder {
        public TextView txtHeader;

    }
    static class ViewHolder {
        public TextView txtAd;
        public TextView txtTarih;
        public TextView txtAdres;
        public ImageView imgAd;
        public ImageView imgTarih;
        public ImageView imgAdres;
    }
}
