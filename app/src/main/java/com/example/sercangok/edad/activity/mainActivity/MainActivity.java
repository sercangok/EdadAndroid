package com.example.sercangok.edad.activity.mainActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.activity.EtkinlikActivity;
import com.example.sercangok.edad.activity.HakkimizdaActivity;
import com.example.sercangok.edad.activity.IletisimActivity;
import com.example.sercangok.edad.activity.UyelikActivity;
import com.example.sercangok.edad.activity.fragmentActivity.KongreFragmetnActivity;
import com.example.sercangok.edad.interfaces.ReadyToSetView;
import com.example.sercangok.edad.model.Etkinlik;
import com.example.sercangok.edad.model.IstGenelMerkez;
import com.example.sercangok.edad.model.Temsilcilik;
import com.example.sercangok.edad.model.YonetimKurulu;
import com.example.sercangok.edad.tasks.OzelEdadKongreTask;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class MainActivity extends Activity implements ReadyToSetView {
    public static final String EXTRA_MESSAGE = "message";
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    private final static int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    private GoogleCloudMessaging gcm;
    private ImageView imgKongre;
    public static final String urlPost = "http://mobilklinik.net/edad/view/kullaniciekle.php";
    public static String url = "http://mobilklinik.net/edad/view/anasayfabanner.php";
    private ProgressBar prgKongre;
    AtomicInteger msgId = new AtomicInteger();
    SharedPreferences prefs;
    String SENDER_ID = "154367357517";
    static final String TAG = "GCMDemo";
    String regid;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        context = (Context) this;
        //storeRegistrationId(this, "");
        // register();
        init();
        setBitmaps();
        checkForKongre();
    }

    private void setBitmaps() {
        Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.kongrepic);
        ((ImageView) findViewById(R.id.imgKongre)).setImageBitmap(getRoundedCornerBitmap(icon, 10));
        icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.hakkimizdapic);
        ((ImageView) findViewById(R.id.imgHakkimizda)).setImageBitmap(getRoundedCornerBitmap(icon, 10));
        icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.uyelikpic);
        ((ImageView) findViewById(R.id.imgUyelik)).setImageBitmap(getRoundedCornerBitmap(icon, 10));
        icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.etkinliklerimizpic);
        ((ImageView) findViewById(R.id.imgEtkinliklerimiz)).setImageBitmap(getRoundedCornerBitmap(icon, 10));
        icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.iletisimpic);
        ((ImageView) findViewById(R.id.imgIletisim)).setImageBitmap(getRoundedCornerBitmap(icon, 10));
    }

    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void register() {
        if (checkPlayServices()) {
            gcm = GoogleCloudMessaging.getInstance(this);
            regid = getRegistrationId(context);

            if (regid.isEmpty()) {
                registerInBackground();
            }
        } else {
            Log.i(TAG, "No valid Google Play Services APK found.");
        }
    }


    private String getRegistrationId(Context context) {
        final SharedPreferences prefs = getGCMPreferences(context);
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }

    private int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

    private SharedPreferences getGCMPreferences(Context context) {
        return getSharedPreferences(MainActivity.class.getSimpleName(),
                Context.MODE_PRIVATE);
    }

    private void registerInBackground() {
        new AsyncTask<Void, Void, Void>() {


            @Override
            protected Void doInBackground(Void... voids) {
                String msg = "";
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    regid = gcm.register(SENDER_ID);
                    Log.e("log", regid);
                    msg = "Device registered, registration ID=" + regid;

                    // You should send the registration ID to your server over HTTP,
                    // so it can use GCM/HTTP or CCS to send messages to your app.
                    // The request to your server should be authenticated if your app
                    // is using accounts.
                    sendRegistrationIdToBackend(urlPost);

                    // For this demo: we don't need to send it because the device
                    // will send upstream messages to a server that echo back the
                    // message using the 'from' address in the message.

                    // Persist the regID - no need to register again.
                    storeRegistrationId(context, regid);
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                    // If there is an error, don't just keep trying to register.
                    // Require the user to click a button again, or perform
                    // exponential back-off.
                }
                final String finalMsg = msg;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(context, finalMsg, Toast.LENGTH_LONG).show();
                    }
                });
                return null;
            }
        }.execute(null, null, null);
    }

    private void storeRegistrationId(Context context, String regid) {
        final SharedPreferences prefs = getGCMPreferences(context);
        int appVersion = getAppVersion(context);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regid);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }

    private void sendRegistrationIdToBackend(String url) {
        //Servera registerId yi atcaz burda
        DefaultHttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        try {
            StringEntity stringEntity = new StringEntity("anroidkey=+" + regid + "+&devicetype=2");
            post.setEntity(stringEntity);
            final HttpResponse response = client.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                final HttpEntity entity = response.getEntity();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Toast.makeText(context, EntityUtils.toString(entity), Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        } catch (final Exception e) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
                }
            });
        }


    }

    private boolean checkPlayServices() {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, this,
                        PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
                Log.i("log", "This device is not supported.");
                finish();
            }
            return false;
        }
        return true;
    }

    private void init() {
        imgKongre = (ImageView) findViewById(R.id.imgKongre);
        prgKongre = (ProgressBar) findViewById(R.id.prgKongre);
    }

    private void checkForKongre() {
        prgKongre.setVisibility(View.VISIBLE);
        new OzelEdadKongreTask(this).execute();
    }

    public void onClick_Etkinliklerimiz(View v) {
        if (isNetworkAvailable())
            startActivity(new Intent(this, EtkinlikActivity.class));
        else
            Toast.makeText(this, "Internet Bağlantınızı Kontrol Ediniz.", Toast.LENGTH_LONG).show();
    }

    public void onClick_Hakkimizda(View v) {
        if (isNetworkAvailable())
            startActivity(new Intent(this, HakkimizdaActivity.class));
        else
            Toast.makeText(this, "Internet Bağlantınızı Kontrol Ediniz.", Toast.LENGTH_LONG).show();
    }

    public void onClick_Uyelik(View v) {
        startActivity(new Intent(this, UyelikActivity.class));
    }

    public void onClick_Iletişim(View v) {
        if (isNetworkAvailable())
            startActivity(new Intent(this, IletisimActivity.class));
        else
            Toast.makeText(this, "Internet Bağlantınızı Kontrol Ediniz.", Toast.LENGTH_LONG).show();
    }

    public void onClick_Kongre(View v) {
        startActivity(new Intent(this, KongreFragmetnActivity.class));
    }

    public void onClick_KayitOl(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[]{"edad@mail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Edad Uyelik");
        intent.putExtra(Intent.EXTRA_TEXT, "Buraya Adınızı ve Soyadınızı giriniz.!");
        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    @Override
    public void readyToSet(List<String> array) {

    }

    @Override
    public void readyToSetYonetimKurulu(List<YonetimKurulu> objectList) {

    }

    @Override
    public void readyToSetTemsilcilik(List<Temsilcilik> objectList) {

    }

    @Override
    public void readyToSetIstGenel(List<IstGenelMerkez> objectList) {

    }

    @Override
    public void readyToSetEtkinlik(List<Etkinlik> objectList) {

    }

    @Override
    public void readToSetObject(Object object) {
        String path = null;
        if (object instanceof String) path = (String) object;
        prgKongre.setVisibility(View.GONE);
        Picasso.with(this).load(path).fit().into(imgKongre);
    }

    @Override
    public void readToSetBitmap(Bitmap object) {
        ((ImageView) findViewById(R.id.imgKongre)).setImageBitmap(getRoundedCornerBitmap(object, 10));
        prgKongre.setVisibility(View.GONE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        checkPlayServices();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mapAction:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
