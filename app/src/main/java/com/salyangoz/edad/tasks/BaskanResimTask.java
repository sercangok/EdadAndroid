package com.salyangoz.edad.tasks;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.salyangoz.edad.interfaces.ReadyToSetView;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by sercangok on 16/09/14.
 */
public class BaskanResimTask extends AsyncTask<Void, Void, Bitmap> {
    ReadyToSetView mListener;
    private String link;

    public BaskanResimTask(ReadyToSetView mListener, String url) {
        this.mListener = mListener;
        this.link = url;
    }

    @Override
    protected Bitmap doInBackground(Void... voids) {
        return setConnection();
    }

    @Override
    protected void onPostExecute(Bitmap image) {
        super.onPostExecute(image);
        mListener.readToSetBitmap(image,0);
    }

    private Bitmap setConnection() {
        URL url = null;
        Bitmap image = null;
        try {
            url = new URL(link);
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
