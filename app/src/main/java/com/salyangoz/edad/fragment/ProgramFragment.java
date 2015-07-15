package com.salyangoz.edad.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.salyangoz.edad.R;
import com.salyangoz.edad.adapter.ProgramAdapter;
import com.salyangoz.edad.model.Programlar;
import com.salyangoz.edad.view.ExpandableHeightGridView;

/**
 * Created by sercangok on 08/09/14.
 */
public class ProgramFragment extends Fragment {
    private View row;
    private int position = -1;
    private ExpandableHeightGridView lst;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        row = inflater.inflate(R.layout.fragment_program, null);
        Bundle bnd = this.getArguments();
        position = bnd.getInt("position");
        init();
        return row;
    }

    private void init() {
        lst = (ExpandableHeightGridView) row.findViewById(R.id.lstProgram);
        lst.setExpanded(true);
        switch (position) {
            case 0:
                lst.setAdapter(new ProgramAdapter(getActivity().getApplicationContext(), R.layout.row_program, Programlar.programlar17EkimCuma));
                break;
            case 1:
                lst.setAdapter(new ProgramAdapter(getActivity().getApplicationContext(), R.layout.row_program, Programlar.programlar18EkimCtesi));
                break;
            case 2:
                lst.setAdapter(new ProgramAdapter(getActivity().getApplicationContext(), R.layout.row_program, Programlar.programlar19EkimPazar));
                break;
            default:
                ProgramAdapter adapter = new ProgramAdapter(getActivity().getApplicationContext(), R.layout.row_program, Programlar.programlar17EkimCuma);
                lst.setAdapter(adapter);
                break;
        }
    }
}
