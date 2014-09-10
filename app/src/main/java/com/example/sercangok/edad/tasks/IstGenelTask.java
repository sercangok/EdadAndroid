package com.example.sercangok.edad.tasks;

import android.os.AsyncTask;
import android.util.Log;

import com.example.sercangok.edad.activity.IstGenelMerkezActivity;
import com.example.sercangok.edad.interfaces.ReadyToSetView;
import com.example.sercangok.edad.model.IstGenelMerkez;
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
public class IstGenelTask extends AsyncTask<Void, Void, List<IstGenelMerkez>> {
    private ReadyToSetView mListener;
    private List<IstGenelMerkez> response;

    public IstGenelTask(ReadyToSetView mListener) {
        this.mListener = mListener;
    }

    @Override
    protected List<IstGenelMerkez> doInBackground(Void... voids) {
        return setConnection();
    }

    @Override
    protected void onPostExecute(List<IstGenelMerkez> IstGenelMerkez) {
        super.onPostExecute(IstGenelMerkez);
        mListener.readyToSetIstGenel(IstGenelMerkez);
    }

    private List<IstGenelMerkez> setConnection() {
        try {
            InputStream source = retrieveStream(IstGenelMerkezActivity.url);
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(source);
            Type listOfItems = new TypeToken<List<IstGenelMerkez>>() {
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
