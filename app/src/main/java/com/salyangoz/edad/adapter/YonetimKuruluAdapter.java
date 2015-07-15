package com.salyangoz.edad.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.salyangoz.edad.R;
import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.salyangoz.edad.model.Etkinlik;
import com.salyangoz.edad.model.IstGenelMerkez;
import com.salyangoz.edad.model.Temsilcilik;
import com.salyangoz.edad.model.YonetimKurulu;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

/**
 * Created by sercangok on 27/08/14.
 */
public class YonetimKuruluAdapter extends ArrayAdapter<YonetimKurulu> implements ReadyToSetView {
    private View row;
    private LayoutInflater inflater;
    private TextView txtAdSoyad, txtPozisyon;
    private ImageView imgProfil;

    public YonetimKuruluAdapter(Context context, int resource, List<YonetimKurulu> objects) {
        super(context, resource, objects);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = inflater.inflate(R.layout.cell_yonetimkurulu, null);
        txtAdSoyad = (TextView) row.findViewById(R.id.txtAdSoyad);
        txtPozisyon = (TextView) row.findViewById(R.id.txtPozisyon);
        imgProfil = (ImageView) row.findViewById(R.id.imgProfile);
        txtAdSoyad.setText(getItem(position).getIsim());
        txtPozisyon.setText(getItem(position).getUnvan());
        Bitmap icon = BitmapFactory.decodeResource(getContext().getResources(),
                R.drawable.suliyet);
        Drawable drawable = new BitmapDrawable(getContext().getResources(), getRoundedShape(icon));
        imgProfil.setBackground(drawable);
        Picasso.with(getContext()).load(getItem(position).getResim()).into(target);
        //Picasso.with(getContext()).load(getItem(position).getResim()).transform(new RoundedTransformation(360, 0)).into(imgProfil);
        return row;
    }

    Target target = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            Drawable drawable = new BitmapDrawable(getContext().getResources(), getRoundedShape(bitmap));
            imgProfil.setBackground(drawable);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void readyToSet(List<String> array) {

    }

    @Override
    public void readyToSetYonetimKurulu(List<YonetimKurulu> objectList) {

    }

    @Override
    public void readyToSetTemsilcilik(List<Temsilcilik> objectList) {

    }

    @Override
    public void readyToSetIstGenel(List<IstGenelMerkez> objectList) {

    }

    @Override
    public void readyToSetEtkinlik(List<Etkinlik> objectList) {

    }

    @Override
    public void readToSetObject(Object object) {

    }

    @Override
    public void readToSetBitmap(Bitmap object,int durum) {
        Drawable drawable = new BitmapDrawable(getContext().getResources(), object);
        imgProfil.setImageDrawable(drawable);
    }

    public static Bitmap getRoundedShape(Bitmap scaleBitmapImage) {
        // TODO Auto-generated method stub
        int targetWidth = 256;
        int targetHeight = 256;
        Bitmap targetBitmap = Bitmap.createBitmap(targetWidth,

                targetHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(targetBitmap);
        Path path = new Path();
        path.addCircle(((float) targetWidth - 1) / 2,
                ((float) targetHeight - 1) / 2,
                (Math.min(((float) targetWidth), ((float) targetHeight)) / 2),
                Path.Direction.CCW);

        canvas.clipPath(path);
        Bitmap sourceBitmap = scaleBitmapImage;
        canvas.drawBitmap(sourceBitmap, new Rect(0, 0, sourceBitmap.getWidth(),
                sourceBitmap.getHeight()), new Rect(0, 0, targetWidth,
                targetHeight), null);
        return targetBitmap;
    }
}
