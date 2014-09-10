package com.example.sercangok.edad.tasks;

import android.os.AsyncTask;

import com.example.sercangok.edad.interfaces.ReadyToSetView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class KongreTask extends AsyncTask<Void, Void, List<String>> {
    private ReadyToSetView mListener;

    public KongreTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<String> doInBackground(Void... voids) {
        List<String> lst = new ArrayList<String>();
        String[] strings = new String[]{"Kongre 1", "Kongre 2", "Kongre 3", "Kongre 4", "Kongre 5", "Kongre 6", "Kongre 7", "Kongre 8", "Kongre 9", "Kongre 10", "Kongre 11",
                "Kongre 12"};
        for (String s : strings) {
            lst.add(s);
        }
        return lst;
    }

    @Override
    protected void onPostExecute(List<String> strings) {
        super.onPostExecute(strings);
        mListener.readyToSet(strings);
    }

}
