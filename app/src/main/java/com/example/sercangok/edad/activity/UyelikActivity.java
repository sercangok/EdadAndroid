package com.example.sercangok.edad.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.sercangok.edad.R;
import com.example.sercangok.edad.util.TelFunction;


public class UyelikActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uyelik);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick_UyeFormu(View v) {
        /*
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL,
                new String[]{"edad@mail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Edad Uyelik");
        intent.putExtra(Intent.EXTRA_TEXT, "Buraya Adınızı ve Soyadınızı giriniz.!");
        startActivity(Intent.createChooser(intent, "Send Email"));*/
        startActivity(TelFunction.getInstance("02122174707").call());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.uyelik, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.mapAction:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri geoLocation = Uri.parse("geo:41.048680,28.986519");
                intent.setData(geoLocation);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
