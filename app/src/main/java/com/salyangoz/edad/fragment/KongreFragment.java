package com.salyangoz.edad.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.salyangoz.edad.R;
import com.salyangoz.edad.adapter.ProgramViewPagerAdapter;
import com.salyangoz.edad.adapter.SosyalProgramViewPagerAdapter;
import com.salyangoz.edad.interfaces.ProgramAddedToCalender;
import com.salyangoz.edad.model.Programlar;
import com.salyangoz.edad.util.CalenderUtil;
import com.salyangoz.edad.util.CountDown;
import com.salyangoz.edad.view.ExpandedViewPager;
import com.salyangoz.edad.view.TextView300;

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
        txtHafta.setText(String.valueOf((int) CountDown.leftWeek));
        txtGun.setText(String.valueOf((int) CountDown.leftDay));
        txtSaat.setText(String.valueOf((int) CountDown.leftHour));
        txtDk.setText(String.valueOf((int) CountDown.leftMin));
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
    public void readyToShowToast(boolean isFav) {
        Toast.makeText(getActivity().getApplicationContext(), "Etkinliğimiz " + ((isFav == false) ?
                "takvinize" : "favorilerinize") + " eklendi.", Toast.LENGTH_LONG).show();
    }
}
