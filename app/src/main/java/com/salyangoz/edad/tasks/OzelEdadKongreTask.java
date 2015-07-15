package com.salyangoz.edad.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.salyangoz.edad.interfaces.ReadyToSetView;
import com.salyangoz.edad.model.Banner;
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
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sercangok on 27/08/14.
 */
public class OzelEdadKongreTask extends AsyncTask<Void, Void, Bitmap> {
    ReadyToSetView mListener;
    private String url;
    private int durum=0;

    public OzelEdadKongreTask(ReadyToSetView mListener, String url) {
        this.mListener = mListener;
        this.url = url;
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        return setConnection();
    }

    @Override
    protected void onPostExecute(Bitmap image) {
        super.onPostExecute(image);
        mListener.readToSetBitmap(image,durum);
    }

    private Bitmap setConnection() {
        InputStream source = retrieveStream(url);
        Gson gson = new Gson();
        Reader reader = new InputStreamReader(source);
        Banner response = gson.fromJson(reader, Banner.class);
        URL url = null;
        Bitmap image = null;
        try {
            url = new URL(response.getBanner());
            durum= response.getDurum();
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
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
