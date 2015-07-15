package com.salyangoz.edad.tasks;

import android.os.AsyncTask;

import com.salyangoz.edad.interfaces.ReadyToSetView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class KursTask extends AsyncTask<Void, Void, List<String>> {
    private ReadyToSetView mListener;

    public KursTask(ReadyToSetView mListener) {
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
        String[] strings = new String[]{"Kurs 1", "Kurs 2", "Kurs 3", "Kurs 4", "Kurs 5", "Kurs 6", "Kurs 7", "Kurs 8", "Kurs 9", "Kurs 10", "Kurs 11",
                "Kurs 12"};
        for (String s : strings) {
            lst.add(s);
        }
        return lst;
    }
}
