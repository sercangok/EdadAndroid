package com.example.sercangok.edad.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.adapter.EtkinlikAdapter;
import com.example.sercangok.edad.adapter.KongreAdapter;
import com.example.sercangok.edad.interfaces.ProgramAddedToCalender;
import com.example.sercangok.edad.interfaces.ReadyToSetView;
import com.example.sercangok.edad.model.Etkinlik;
import com.example.sercangok.edad.model.IstGenelMerkez;
import com.example.sercangok.edad.model.Temsilcilik;
import com.example.sercangok.edad.model.YonetimKurulu;
import com.example.sercangok.edad.tasks.EtkinlikTask;
import com.example.sercangok.edad.tasks.KursTask;
import com.example.sercangok.edad.tasks.SeminerTask;
import com.example.sercangok.edad.tasks.SempozyumTask;
import com.example.sercangok.edad.util.CalenderUtil;

import java.util.ArrayList;
import java.util.List;


public class EtkinlikActivity extends Activity implements ReadyToSetView, ProgramAddedToCalender {
    public static String url = "http://mobilklinik.net/edad/view/etkinliklistesi.php";
    private ListView lstKongre, lstSempozyum, lstSeminer, lstKurs;
    private List<String> stringLstKongre, stringLstSempozyum, stringLstSeminer, stringLstKurs;
    public static List<String> lst;
    private int counter = 0;
    public static KongreAdapter customAdapter;
    private ProgressBar prgEtkinlik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etkinlik);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        CalenderUtil.mListener = this;
        init();
    }

    private void init() {
        lstKongre = (ListView) findViewById(R.id.lstKongre);
        prgEtkinlik = (ProgressBar) findViewById(R.id.prgEtkinlik);
        lst = new ArrayList<String>();
        new EtkinlikTask(this).execute();
        prgEtkinlik.setVisibility(View.VISIBLE);
    }

    @Override
    public void readyToSet(List<String> array) {
        lst.addAll(array);
        if (counter == 0) {
            //customAdapter = new KongreAdapter(this, R.layout.row_etkinliklerimiz, lst);
            lstKongre.setAdapter(customAdapter);
            new SempozyumTask(this).execute();
        } else if (counter == 1) {
            customAdapter.notifyDataSetChanged();
            //lstSempozyum.setAdapter(new KongreAdapter(this, R.layout.row_etkinliklerimiz, array));
            new SeminerTask(this).execute();
        } else if (counter == 2) {
            customAdapter.notifyDataSetChanged();
            //lstSeminer.setAdapter(new KongreAdapter(this, R.layout.row_etkinliklerimiz, array));
            new KursTask(this).execute();
        } else if (counter == 3) {
            customAdapter.notifyDataSetChanged();
            //lstKurs.setAdapter(new KongreAdapter(this, R.layout.row_etkinliklerimiz, array));
        }
        counter++;
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
        lstKongre.setAdapter(new EtkinlikAdapter(this, R.layout.row_etkinliklerimiz, objectList));
        prgEtkinlik.setVisibility(View.GONE);
    }


    @Override
    public void readToSetObject(Object object) {

    }

    @Override
    public void readToSetBitmap(Bitmap object) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.etkinlik, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.mapAction:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void readyToShowToast() {
        Toast.makeText(this, "Etkinliğimiz takviminize eklendi.", Toast.LENGTH_LONG).show();
    }
}
