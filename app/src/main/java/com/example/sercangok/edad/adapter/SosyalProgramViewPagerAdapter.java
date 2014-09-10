package com.example.sercangok.edad.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.sercangok.edad.fragment.SosyalProgramFragment;

/**
 * Created by sercangok on 09/09/14.
 */
public class SosyalProgramViewPagerAdapter extends FragmentPagerAdapter {

    public SosyalProgramViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        SosyalProgramFragment fragment = new SosyalProgramFragment();
        Bundle bnd = new Bundle();
        bnd.putInt("position", position);
        fragment.setArguments(bnd);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Kokteyl";
            case 1:
                return "Gala Yemeği";
            default:
                return "Hata";
        }
    }
}
