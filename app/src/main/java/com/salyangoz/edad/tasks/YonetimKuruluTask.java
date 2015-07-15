package com.salyangoz.edad.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.salyangoz.edad.activity.HakkimizdaActivity;
import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.salyangoz.edad.model.YonetimKurulu;
import com.google.gson.Gson;
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
public class YonetimKuruluTask extends AsyncTask<Void, Void, List<YonetimKurulu>> {
    ReadyToSetView mListener;

    public YonetimKuruluTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<YonetimKurulu> doInBackground(Void... voids) {
        return setConnection();
    }

    @Override
    protected void onPostExecute(List<YonetimKurulu> yonetimKurulu) {
        super.onPostExecute(yonetimKurulu);
        mListener.readyToSetYonetimKurulu(yonetimKurulu);
    }
//test
    private List<YonetimKurulu> setConnection() {
        InputStream source = retrieveStream(HakkimizdaActivity.urlKurul);
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(source);
        Type listOfItems = new TypeToken<List<YonetimKurulu>>() {
        }.getType();
        List<YonetimKurulu> response = gson.fromJson(reader, listOfItems);
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
