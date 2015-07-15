package com.salyangoz.edad.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.salyangoz.edad.model.Hakkimizda;
import com.salyangoz.edad.activity.HakkimizdaActivity;
import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.google.gson.Gson;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by sercangok on 26/08/14.
 */
public class HakkimizdaTask extends AsyncTask<Void, Void, Hakkimizda> {
    private ReadyToSetView mListener;

    public HakkimizdaTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected void onPostExecute(Hakkimizda hakkimizda) {
        super.onPostExecute(hakkimizda);
        mListener.readToSetObject(hakkimizda);
    }

    @Override
    protected Hakkimizda doInBackground(Void... voids) {
        return setConnection();
    }

    private Hakkimizda setConnection() {
        InputStream source = retrieveStream(HakkimizdaActivity.url);
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(source);
        Hakkimizda response = gson.fromJson(reader, Hakkimizda.class);
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
