package com.salyangoz.edad.model;

import android.content.Context;

import com.salyangoz.edad.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sercangok on 27/08/14.
 */
public class Konusmacilar {
    public List<Konusmaci> konusmacilar;
    private Context context;

    public Konusmacilar(Context context) {
        this.context = context;
        konusmacilar = new ArrayList<Konusmaci>();
        fillList();
    }

    private void fillList() {
        konusmacilar.add(new Konusmaci("Nicole Arweiler", context.getResources().getDrawable(R.drawable.arweiler)));
        konusmacilar.add(new Konusmaci("Wael Att", context.getResources().getDrawable(R.drawable.att)));
        konusmacilar.add(new Konusmaci("Stephane Browet", context.getResources().getDrawable(R.drawable.browet)));
        konusmacilar.add(new Konusmaci("Marco Degidi", context.getResources().getDrawable(R.drawable.degidi)));
        konusmacilar.add(new Konusmaci("Daniel Edelhoff", context.getResources().getDrawable(R.drawable.edelhoff)));
        konusmacilar.add(new Konusmaci("Gerhard Iglhaut", context.getResources().getDrawable(R.drawable.iglhaut)));
        konusmacilar.add(new Konusmaci("Arne Lund", context.getResources().getDrawable(R.drawable.lund)));
        konusmacilar.add(new Konusmaci("IIja Mihatovic", context.getResources().getDrawable(R.drawable.mihatovic)));
        konusmacilar.add(new Konusmaci("Paulo Monteiro", context.getResources().getDrawable(R.drawable.monteiro)));
        konusmacilar.add(new Konusmaci("Axel Mory", context.getResources().getDrawable(R.drawable.mory)));
        konusmacilar.add(new Konusmaci("Michael Müller", context.getResources().getDrawable(R.drawable.muller)));
        konusmacilar.add(new Konusmaci("Selim Pamuk", context.getResources().getDrawable(R.drawable.pamuk)));
        konusmacilar.add(new Konusmaci("Joseph Sabbagh", context.getResources().getDrawable(R.drawable.sabbagh)));
        konusmacilar.add(new Konusmaci("Florin Stoboran", context.getResources().getDrawable(R.drawable.stoboran)));
    }
}
