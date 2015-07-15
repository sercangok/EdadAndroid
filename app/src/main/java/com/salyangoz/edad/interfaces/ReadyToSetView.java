package com.salyangoz.edad.interfaces;

import android.graphics.Bitmap;

import com.salyangoz.edad.model.Etkinlik;
import com.salyangoz.edad.model.IstGenelMerkez;
import com.salyangoz.edad.model.Temsilcilik;
import com.salyangoz.edad.model.YonetimKurulu;

import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public interface ReadyToSetView {
    public abstract void readyToSet(List<String> array);

    public abstract void readyToSetYonetimKurulu(List<YonetimKurulu> objectList);

    public abstract void readyToSetTemsilcilik(List<Temsilcilik> objectList);

    public abstract void readyToSetIstGenel(List<IstGenelMerkez> objectList);

    public abstract void readyToSetEtkinlik(List<Etkinlik> objectList);

    public abstract void readToSetObject(Object object);

    public abstract void readToSetBitmap(Bitmap object,int durum);

}
