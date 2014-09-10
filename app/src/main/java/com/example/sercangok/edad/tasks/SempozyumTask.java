package com.example.sercangok.edad.tasks;

import android.os.AsyncTask;

import com.example.sercangok.edad.interfaces.ReadyToSetView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class SempozyumTask extends AsyncTask<Void, Void, List<String>> {
    private ReadyToSetView mListener;

    public SempozyumTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        mListener.readyToSet(strings);
    }

    @Override
    protected List<String> doInBackground(Void... voids) {
        List<String> lst = new ArrayList<String>();
        String[] strings = new String[]{"Sempozyum 1", "Sempozyum 2", "Sempozyum 3", "Sempozyum 4", "Sempozyum 5", "Sempozyum 6", "Sempozyum 7", "Sempozyum 8", "" +
                "Sempozyum 9", "Sempozyum 10", "Sempozyum 11",
                "Sempozyum 12"};
        for (String s : strings) {
            lst.add(s);
        }
        return lst;
    }
}
