package com.salyangoz.edad.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

import com.salyangoz.edad.R;
import com.salyangoz.edad.activity.mainActivity.MainActivity;

/**
 * Created by sercangok on 02/09/14.
 */
public class SplashScreenActivity extends Activity {
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);
        iv = (ImageView) findViewById(R.id.imgSplash);
        fadeIn.run();
        ct.start();
    }

    CountDownTimer ct = new CountDownTimer(2000, 500) {
        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {
            finish();
            startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
        }
    };

    Runnable fadeIn = new Runnable() {
        public void run() {
            iv.animate().setDuration(1750)
                    .setInterpolator(new LinearInterpolator()).alpha(1.0f);
        }
    };
}
