package com.example.sercangok.edad.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sercangok.edad.activity.EtkinlikActivity;
import com.example.sercangok.edad.interfaces.ReadyToSetView;
import com.example.sercangok.edad.model.Etkinlik;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by sercangok on 27/08/14.
 */
public class EtkinlikTask extends AsyncTask<Void, Void, List<Etkinlik>> {

    private ReadyToSetView mListener;

    public EtkinlikTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<Etkinlik> doInBackground(Void... voids) {
        return setConnection();
    }

    @Override
    protected void onPostExecute(List<Etkinlik> etkinliks) {
        super.onPostExecute(etkinliks);
        mListener.readyToSetEtkinlik(etkinliks);
    }

    private List<Etkinlik> setConnection() {
        InputStream source = retrieveStream(EtkinlikActivity.url);
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-d HH:m:s").create();
        Reader reader = new InputStreamReader(source);
        Type listOfItems = new TypeToken<List<Etkinlik>>() {
        }.getType();
        List<Etkinlik> response = gson.fromJson(reader, listOfItems);
        return response;
    }

    private InputStream retrieveStream(String url) {
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet getRequest = new HttpGet(url);
        try {
            HttpResponse getResponse = client.execute(getRequest);
            final int statusCode = getResponse.getStatusLine().getStatusCode();
            if (statusCode != HttpStatus.SC_OK) {
                Log.w(getClass().getSimpleName(),
                        "Error " + statusCode + " for URL " + url);
                return null;
            }
            HttpEntity getResponseEntity = getResponse.getEntity();
            return getResponseEntity.getContent();
        } catch (IOException e) {
            getRequest.abort();
            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        return null;
    }
}
