package com.example.sercangok.edad.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sercangok.edad.activity.TemsilciliklerimizActivity;
import com.example.sercangok.edad.interfaces.ReadyToSetView;
import com.example.sercangok.edad.model.Temsilcilik;
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
import java.net.UnknownHostException;
import java.util.List;

/**
 * Created by sercangok on 26/08/14.
 */
public class TemsilcilikTask extends AsyncTask<Void, Void, List<Temsilcilik>> {
    private ReadyToSetView mListener;
    private List<Temsilcilik> response;

    public TemsilcilikTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<Temsilcilik> doInBackground(Void... voids) {
        return setConnection();
    }

    @Override
    protected void onPostExecute(List<Temsilcilik> temsilcilik) {
        super.onPostExecute(temsilcilik);
        mListener.readyToSetTemsilcilik(temsilcilik);
    }


    private List<Temsilcilik> setConnection() {
        try {
            InputStream source = retrieveStream(TemsilciliklerimizActivity.url);
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(source);
            Type listOfItems = new TypeToken<List<Temsilcilik>>() {
            }.getType();
            response = gson.fromJson(reader, listOfItems);
        } catch (NullPointerException e) {
        }
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
        } catch (UnknownHostException e) {
        } catch (IOException e) {
            getRequest.abort();
            Log.w(getClass().getSimpleName(), "Error for URL " + url, e);
        }
        return null;
    }

}
