package com.salyangoz.edad.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.salyangoz.edad.R;
import com.salyangoz.edad.adapter.YonetimKuruluAdapter;
import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.salyangoz.edad.model.Etkinlik;
import com.salyangoz.edad.model.Hakkimizda;
import com.salyangoz.edad.model.IstGenelMerkez;
import com.salyangoz.edad.model.Temsilcilik;
import com.salyangoz.edad.model.YonetimKurulu;
import com.salyangoz.edad.tasks.BaskanResimTask;
import com.salyangoz.edad.tasks.HakkimizdaTask;
import com.salyangoz.edad.tasks.YonetimKuruluTask;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class HakkimizdaActivity extends Activity implements ReadyToSetView {
    private GridView grdYonetim;
    private TextView txtHakkimizda;
    private ProgressBar prgHakkimizda, prgYonetim;
    private LinearLayout lnrHakkimizda;
    private CircleImageView imgBaskan;

    public static String url = "http://mobilklinik.net/edad/view/hakkimizda.php";
    public static String urlKurul = "http://mobilklinik.net/edad/view/yonetimkurulu.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hakkimizda);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        grdYonetim = (GridView) findViewById(R.id.grdYonetim);
        grdYonetim.setClickable(false);
        grdYonetim.setLongClickable(false);
        txtHakkimizda = (TextView) findViewById(R.id.txtHakkimizda);
        txtHakkimizda.setMovementMethod(new ScrollingMovementMethod());
        prgHakkimizda = (ProgressBar) findViewById(R.id.prgHakkimizda);
        prgYonetim = (ProgressBar) findViewById(R.id.prgYonetimKurulu);
        lnrHakkimizda = (LinearLayout) findViewById(R.id.lnrHakkimizda);
        imgBaskan = (CircleImageView) findViewById(R.id.imgBaskan);
        lnrHakkimizda.setVisibility(View.GONE);
        prgHakkimizda.setVisibility(View.VISIBLE);
        new YonetimKuruluTask(this).execute();
    }

    @Override
    public void readyToSet(List<String> array) {
        // grdYonetim.setAdapter(new YonetimKuruluAdapter(this, R.layout.cell_yonetimkurulu, array));
    }

    @Override
    public void readToSetObject(Object object) {
        txtHakkimizda.setText(object instanceof Hakkimizda ? ((Hakkimizda) object).getHakkimizda() : "Değer Bulunamadı");
        prgHakkimizda.setVisibility(View.GONE);
        lnrHakkimizda.setVisibility(View.VISIBLE);
        new BaskanResimTask(this, ((Hakkimizda) object).getResim()).execute();

    }

    @Override
    public void readToSetBitmap(Bitmap object,int durum) {
        imgBaskan.setImageBitmap(object);
    }

    @Override
    public void readyToSetYonetimKurulu(List<YonetimKurulu> objectList) {
        grdYonetim.setAdapter(new YonetimKuruluAdapter(this, R.layout.cell_yonetimkurulu, objectList));
        new HakkimizdaTask(this).execute();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hakkimizda, menu);
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
