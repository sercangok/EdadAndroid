package com.salyangoz.edad.tasks;

import android.os.AsyncTask;

import com.salyangoz.edad.interfaces.ReadyToSetView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class SeminerTask extends AsyncTask<Void, Void, List<String>> {
    private ReadyToSetView mListener;

    public SeminerTask(ReadyToSetView mListener) {
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
        String[] strings = new String[]{"Seminer 1", "Seminer 2", "Seminer 3", "Seminer 4", "Seminer 5", "Seminer 6", "Seminer 7", "Seminer 8", "Seminer 9", "Seminer 10", "Seminer 11",
                "Seminer 12"};
        for (String s : strings) {
            lst.add(s);
        }
        return lst;
    }
}
