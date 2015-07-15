package com.salyangoz.edad.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.salyangoz.edad.R;
import com.salyangoz.edad.adapter.TemsilcilikAdapter;
import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.salyangoz.edad.model.Etkinlik;
import com.salyangoz.edad.model.IstGenelMerkez;
import com.salyangoz.edad.model.Temsilcilik;
import com.salyangoz.edad.model.YonetimKurulu;
import com.salyangoz.edad.tasks.TemsilcilikTask;

import java.util.List;


public class TemsilciliklerimizActivity extends Activity implements ReadyToSetView {

    public static String url = "http://mobilklinik.net/edad/view/temsilcilikler.php";
    private ListView lstTemsilciliklerimiz;
    private TemsilcilikAdapter customAdapter;
    private ProgressBar prgTemsilcilik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temsilciliklerimiz);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        lstTemsilciliklerimiz = (ListView) findViewById(R.id.lstTemsilcilirlerimiz);
        prgTemsilcilik = (ProgressBar) findViewById(R.id.prgTemsilcilik);
        prgTemsilcilik.setVisibility(View.VISIBLE);
        new TemsilcilikTask(this).execute();
    }

    @Override
    public void readyToSet(List<String> array) {
        // customAdapter = new TemsilcilikAdapter(this, R.layout.row_temsilciliklerimiz, array);
        lstTemsilciliklerimiz.setAdapter(customAdapter);
        prgTemsilcilik.setVisibility(View.GONE);
    }

    @Override
    public void readyToSetYonetimKurulu(List<YonetimKurulu> objectList) {

    }

    @Override
    public void readyToSetTemsilcilik(List<Temsilcilik> objectList) {
        prgTemsilcilik.setVisibility(View.GONE);
        if (objectList != null)
            lstTemsilciliklerimiz.setAdapter(new TemsilcilikAdapter(this, R.layout.row_temsilciliklerimiz, objectList));
        else {
            Toast.makeText(this, "Internet Bağlantısı Bulunmuyor..", Toast.LENGTH_LONG).show();
            finish();
        }
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

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.temsilciliklerimiz, menu);
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
                Uri geoLocation = Uri.parse("geo:41.048680,28.986519");
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
