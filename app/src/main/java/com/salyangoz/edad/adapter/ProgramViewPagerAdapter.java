package com.salyangoz.edad.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.salyangoz.edad.fragment.ProgramFragment;

/**
 * Created by sercangok on 06/09/14.
 */
public class ProgramViewPagerAdapter extends FragmentPagerAdapter {
    public ProgramViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        ProgramFragment frgment = new ProgramFragment();
        Bundle bnd = new Bundle();
        bnd.putInt("position", position);
        frgment.setArguments(bnd);
        return frgment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return (position + 1) + ".Gün";
    }
}
