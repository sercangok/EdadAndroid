package com.example.sercangok.edad.activity;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.sercangok.edad.interfaces.ProgramAddedToCalender;
import com.example.sercangok.edad.model.Konusmacilar;
import com.example.sercangok.edad.model.Programlar;
import com.example.sercangok.edad.util.CalenderUtil;
import com.example.sercangok.edad.view.ExpandableHeightGridView;


public class KongreActivity extends FragmentActivity implements ProgramAddedToCalender, View.OnClickListener {
    private ExpandableHeightGridView lstProgram;
    private FrameLayout indicator;
    private LinearLayout ilkGun, ikinciGun, ucuncuGun, galaYemegi, kokteyl = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kongre);
        new Programlar();
        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
        CalenderUtil.mListener = this;
    }

    private void init() {
        Konusmacilar k = new Konusmacilar(this);
        indicator = (FrameLayout) findViewById(R.id.frmIndıcator);
        lstProgram = (ExpandableHeightGridView) findViewById(R.id.lstProgram);
        ilkGun = (LinearLayout) findViewById(R.id.ilkGun);
        ikinciGun = (LinearLayout) findViewById(R.id.ikinciGun);
        ucuncuGun = (LinearLayout) findViewById(R.id.ucuncuGün);
        galaYemegi = (LinearLayout) findViewById(R.id.galaYemegi);
        kokteyl = (LinearLayout) findViewById(R.id.kokteyl);
        ikinciGun.setOnClickListener(this);
        ilkGun.setOnClickListener(this);
        ucuncuGun.setOnClickListener(this);
        galaYemegi.setOnClickListener(this);
        kokteyl.setOnClickListener(this);
        lstProgram.setExpanded(true);
        lstProgram.setAdapter(new ProgramAdapter(this, R.layout.row_program, Programlar.programlar17EkimCuma));
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
                //intent.setData(geoLocation);
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

    @Override
    public void readyToShowToast() {
        Toast.makeText(this, "Etkinliğimiz takviminize eklendi.", Toast.LENGTH_LONG).show();
    }

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
        } else {
            ((FrameLayout) kokteyl.findViewById(R.id.frmIndıcatorKokteyl)).setVisibility(View.VISIBLE);
            ((FrameLayout) galaYemegi.findViewById(R.id.frmIndıcatorGala)).setVisibility(View.GONE);
        }
    }
}
