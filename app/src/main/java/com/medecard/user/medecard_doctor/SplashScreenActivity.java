package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {

    Handler handler;
    private ImageView imv;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        imv = (ImageView) findViewById(R.id.app_theme);
        tv = (TextView) findViewById(R.id.app_theme_text);

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        imv.startAnimation(myanim);
        tv.startAnimation(myanim);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, IntroActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
