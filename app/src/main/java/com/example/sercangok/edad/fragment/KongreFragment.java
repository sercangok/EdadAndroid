package com.example.sercangok.edad.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.adapter.ProgramViewPagerAdapter;
import com.example.sercangok.edad.adapter.SosyalProgramViewPagerAdapter;
import com.example.sercangok.edad.interfaces.ProgramAddedToCalender;
import com.example.sercangok.edad.model.Programlar;
import com.example.sercangok.edad.util.CalenderUtil;
import com.example.sercangok.edad.util.CountDown;
import com.example.sercangok.edad.view.ExpandedViewPager;
import com.example.sercangok.edad.view.TextView300;

import java.util.Calendar;

/**
 * Created by sercangok on 09/09/14.
 */
public class KongreFragment extends Fragment implements View.OnClickListener, ProgramAddedToCalender {
    private FrameLayout frmTakvimeEkle;
    private TextView300 txtHafta, txtGun, txtSaat, txtDk;
    public static ExpandedViewPager mPagerProgram, mPagerSosyalProgram;
    private ProgramViewPagerAdapter mAdapter;
    private SosyalProgramViewPagerAdapter mAdapterSosyal;
    private View row;
    private static long SEC;
    private long delaySec = 60 * 1000;
    Handler handler = new android.os.Handler();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        new Programlar();
        CalenderUtil.mListener = this;

        row = inflater.inflate(R.layout.fragment_kongre, null);
        init();
        registerEvents();
        return row;
    }

    private void init() {
        frmTakvimeEkle = (FrameLayout) row.findViewById(R.id.frmKongreEkle);
        txtHafta = (TextView300) row.findViewById(R.id.txtHafta);
        txtGun = (TextView300) row.findViewById(R.id.txtGun);
        txtSaat = (TextView300) row.findViewById(R.id.txtSaat);
        txtDk = (TextView300) row.findViewById(R.id.txtDakika);
        mPagerProgram = (ExpandedViewPager) row.findViewById(R.id.program);
        mPagerSosyalProgram = (ExpandedViewPager) row.findViewById(R.id.sosyalProgram);
        mAdapter = new ProgramViewPagerAdapter(getFragmentManager());
        mAdapterSosyal = new SosyalProgramViewPagerAdapter(getFragmentManager());
        mPagerProgram.setAdapter(mAdapter);
        mPagerSosyalProgram.setAdapter(mAdapterSosyal);
        updateSecond();
        handler.postDelayed(geriSayim, delaySec);

    }


    private void registerEvents() {
        frmTakvimeEkle.setOnClickListener(this);
        mPagerProgram.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                ((ExpandedViewPager) view).requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    }

    public void updateSecond() {
        SEC = Programlar.programlar17EkimCuma.get(0).calendarBaslangic.getTime().getTime() - Calendar.getInstance().getTime().getTime();
        CountDown.getInstance(SEC / 1000);
        txtHafta.setText((int) CountDown.leftWeek + " W");
        txtGun.setText((int) CountDown.leftDay + " D");
        txtSaat.setText((int) CountDown.leftHour + " H");
        txtDk.setText((int) CountDown.leftMin + "M");
    }

    Runnable geriSayim = new Runnable() {
        @Override
        public void run() {
            try {
                KongreFragment.this.getActivity().runOnUiThread(new Runnable() {
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
        switch (view.getId()) {
            case R.id.frmKongreEkle:
                onClick_KongreEkle(view);
                break;
        }
    }

    public void onClick_KongreEkle(View v) {
        CalenderUtil.getInstanceEdadKongre(getActivity().getApplicationContext());
    }

    @Override
    public void readyToShowToast() {
        Toast.makeText(getActivity().getApplicationContext(), "Etkinliğimiz takviminize eklendi.", Toast.LENGTH_LONG).show();
    }
}
