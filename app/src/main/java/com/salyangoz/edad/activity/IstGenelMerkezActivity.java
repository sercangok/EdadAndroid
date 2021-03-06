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
import com.salyangoz.edad.adapter.IstGenelMerkezAdapter;
import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.salyangoz.edad.model.Etkinlik;
import com.salyangoz.edad.model.IstGenelMerkez;
import com.salyangoz.edad.model.Temsilcilik;
import com.salyangoz.edad.model.YonetimKurulu;
import com.salyangoz.edad.tasks.IstGenelTask;

import java.util.List;


public class IstGenelMerkezActivity extends Activity implements ReadyToSetView {

    public static String url = "http://mobilklinik.net/edad/view/iletisim.php";
    private ListView lstIstGenelMerkez;
    private IstGenelMerkezAdapter customAdapter;
    private ProgressBar prgIstGenel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ist_genel_merkez);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        lstIstGenelMerkez = (ListView) findViewById(R.id.lstIstGenelMerkez);
        prgIstGenel = (ProgressBar) findViewById(R.id.prgIstGenel);
        prgIstGenel.setVisibility(View.VISIBLE);
        new IstGenelTask(this).execute();
    }

    @Override
    public void readyToSet(List<String> array) {
        //customAdapter = new IstGenelMerkezAdapter(this, R.layout.row_istgenelmerkez, array);
        lstIstGenelMerkez.setAdapter(customAdapter);
        prgIstGenel.setVisibility(View.GONE);
    }

    @Override
    public void readyToSetYonetimKurulu(List<YonetimKurulu> objectList) {

    }

    @Override
    public void readyToSetTemsilcilik(List<Temsilcilik> objectList) {

    }

    @Override
    public void readyToSetIstGenel(List<IstGenelMerkez> objectList) {
        if (objectList != null)
            lstIstGenelMerkez.setAdapter(new IstGenelMerkezAdapter(this, R.layout.row_istgenelmerkez, objectList));
        else {
            Toast.makeText(this, "Internet Bağlantısı Bulunmuyor..", Toast.LENGTH_LONG).show();
            finish();
        }
        prgIstGenel.setVisibility(View.GONE);
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
        inflater.inflate(R.menu.ist_genel_merkez, menu);
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
