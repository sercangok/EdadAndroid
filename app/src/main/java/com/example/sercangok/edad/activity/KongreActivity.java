package com.example.sercangok.edad.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.adapter.ProgramAdapter;
import com.example.sercangok.edad.adapter.SosyalProgramAdapter;
import com.example.sercangok.edad.interfaces.ProgramAddedToCalender;
import com.example.sercangok.edad.model.Konusmacilar;
import com.example.sercangok.edad.model.Program;
import com.example.sercangok.edad.model.Programlar;
import com.example.sercangok.edad.util.CalenderUtil;
import com.example.sercangok.edad.util.CountDown;
import com.example.sercangok.edad.view.ExpandableHeightGridView;
import com.example.sercangok.edad.view.TextView300;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class KongreActivity extends FragmentActivity implements ProgramAddedToCalender, View.OnClickListener {
    private ExpandableHeightGridView lstProgram, lstSosyal;
    private FrameLayout indicator;
    private TextView300 txtHafta, txtGun, txtSaat, txtDk;
    private LinearLayout ilkGun, ikinciGun, ucuncuGun, galaYemegi, kokteyl = null;
    private static long SEC;
    private long delaySec = 60 * 1000;
    Handler handler = new android.os.Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kongre);
        new Programlar();
        CalenderUtil.mListener = this;
        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    private void init() {
        Konusmacilar k = new Konusmacilar(this);
        indicator = (FrameLayout) findViewById(R.id.frmIndıcator);
        lstProgram = (ExpandableHeightGridView) findViewById(R.id.lstProgram);
        lstSosyal = (ExpandableHeightGridView) findViewById(R.id.lstSosyal);
        ilkGun = (LinearLayout) findViewById(R.id.ilkGun);
        ikinciGun = (LinearLayout) findViewById(R.id.ikinciGun);
        ucuncuGun = (LinearLayout) findViewById(R.id.ucuncuGün);
        galaYemegi = (LinearLayout) findViewById(R.id.galaYemegi);
        kokteyl = (LinearLayout) findViewById(R.id.kokteyl);
        txtHafta = (TextView300) findViewById(R.id.txtHafta);
        txtGun = (TextView300) findViewById(R.id.txtGun);
        txtSaat = (TextView300) findViewById(R.id.txtSaat);
        txtDk = (TextView300) findViewById(R.id.txtDakika);
        ikinciGun.setOnClickListener(this);
        ilkGun.setOnClickListener(this);
        ucuncuGun.setOnClickListener(this);
        galaYemegi.setOnClickListener(this);
        kokteyl.setOnClickListener(this);
        lstProgram.setExpanded(true);
        lstProgram.setAdapter(new ProgramAdapter(this, R.layout.row_program, Programlar.programlar17EkimCuma));
        List<Program> list = new ArrayList<Program>();
        list.add(Programlar.sosyalProgramKokteyl);
        lstSosyal.setAdapter(new SosyalProgramAdapter(this, R.layout.fragment_sosyalprogram, list));
        updateSecond();
        handler.postDelayed(geriSayim, delaySec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.kongre, menu);
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
                Uri geoLocation = Uri.parse("geo:41.077338,29.012812?q=41.077338,29.012812");
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void onClick_KongreEkle(View v) {
        CalenderUtil.getInstanceEdadKongre(this);
    }

    public void updateSecond() {
        SEC = Programlar.programlar17EkimCuma.get(0).calendarBaslangic.getTime().getTime() - Calendar.getInstance().getTime().getTime();
        CountDown.getInstance(SEC / 1000);
        txtHafta.setText(String.valueOf((int) CountDown.leftWeek));
        txtGun.setText(String.valueOf((int) CountDown.leftDay));
        txtSaat.setText(String.valueOf((int) CountDown.leftHour));
        txtDk.setText(String.valueOf((int) CountDown.leftMin));
    }

    Runnable geriSayim = new Runnable() {
        @Override
        public void run() {
            try {
                KongreActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            updateSecond();
                            handler.postDelayed(geriSayim, delaySec);
                        } catch (NullPointerException e) {
                        }
                    }
                });
            } catch (NullPointerException e) {
            }

        }
    };

    @Override
    public void onClick(View view) {
        if (view.getId() == ilkGun.getId()) {
            ((FrameLayout) ilkGun.findViewById(R.id.frmIndıcator)).setVisibility(View.VISIBLE);
            ((FrameLayout) ikinciGun.findViewById(R.id.frmIndıcatorIki)).setVisibility(View.GONE);
            ((FrameLayout) ucuncuGun.findViewById(R.id.frmIndıcatorSon)).setVisibility(View.GONE);
            lstProgram.setAdapter(new ProgramAdapter(this, R.layout.row_program, Programlar.programlar17EkimCuma));
        } else if (view.getId() == ikinciGun.getId()) {
            ((FrameLayout) ilkGun.findViewById(R.id.frmIndıcator)).setVisibility(View.GONE);
            ((FrameLayout) ikinciGun.findViewById(R.id.frmIndıcatorIki)).setVisibility(View.VISIBLE);
            ((FrameLayout) ucuncuGun.findViewById(R.id.frmIndıcatorSon)).setVisibility(View.GONE);
            lstProgram.setAdapter(new ProgramAdapter(this, R.layout.row_program, Programlar.programlar18EkimCtesi));
        } else if (view.getId() == ucuncuGun.getId()) {
            ((FrameLayout) ilkGun.findViewById(R.id.frmIndıcator)).setVisibility(View.GONE);
            ((FrameLayout) ikinciGun.findViewById(R.id.frmIndıcatorIki)).setVisibility(View.GONE);
            ((FrameLayout) ucuncuGun.findViewById(R.id.frmIndıcatorSon)).setVisibility(View.VISIBLE);
            lstProgram.setAdapter(new ProgramAdapter(this, R.layout.row_program, Programlar.programlar19EkimPazar));
        } else if (view.getId() == galaYemegi.getId()) {
            ((FrameLayout) kokteyl.findViewById(R.id.frmIndıcatorKokteyl)).setVisibility(View.GONE);
            ((FrameLayout) galaYemegi.findViewById(R.id.frmIndıcatorGala)).setVisibility(View.VISIBLE);
            List<Program> list = new ArrayList<Program>();
            list.add(Programlar.sosyalProgramGala);
            lstSosyal.setAdapter(new SosyalProgramAdapter(this, R.layout.fragment_sosyalprogram, list));
        } else {
            ((FrameLayout) kokteyl.findViewById(R.id.frmIndıcatorKokteyl)).setVisibility(View.VISIBLE);
            ((FrameLayout) galaYemegi.findViewById(R.id.frmIndıcatorGala)).setVisibility(View.GONE);
            List<Program> list = new ArrayList<Program>();
            list.add(Programlar.sosyalProgramKokteyl);
            lstSosyal.setAdapter(new SosyalProgramAdapter(this, R.layout.fragment_sosyalprogram, list));
        }
    }

    @Override
    public void readyToShowToast(boolean isFav) {
        Toast.makeText(this, "Etkinliğimiz " + ((isFav == false) ?
                "takvinize" : "favorilerinize") + " eklendi.", Toast.LENGTH_LONG).show();
    }
}
