package com.medecard.user.medecard_doctor;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroVewPagerAdapter introVewPagerAdapter;
    TextView textView;
    TabLayout tabIndicator;
    Button btnNext;
    int position = 0;
    Button btnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // make app on full screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        // hide the action bar
        getSupportActionBar().hide();

        // ini views
        tabIndicator = findViewById(R.id.tab_indicator);
        btnNext = findViewById(R.id.btn_next);
        btnGetStarted = findViewById(R.id.btn_getStarted);

        // fill list screen
        List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Meet New Doctors", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.new_doctors));
        mList.add(new ScreenItem("Share your Records", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.share_records));
        mList.add(new ScreenItem("Easy Payment", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.easy_pay));
        mList.add(new ScreenItem("Sign Up Today", "Lorem ipsum dolor sit amet consectetur adipisicing elit. Fugit id reiciendis ratione distinctio ipsam atque quos sed velit iusto tenetur.", R.drawable.sign_up));

        // setup viewpager
        screenPager = findViewById(R.id.screen_viewpager);
        introVewPagerAdapter = new IntroVewPagerAdapter(this, mList);
        screenPager.setAdapter(introVewPagerAdapter);

        textView = (TextView) findViewById(R.id.next_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, LogRegActivity.class));
                finish();
            }
        });

        // setup tablayout with viewpager
        tabIndicator.setupWithViewPager(screenPager);

        // next button click Listener
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = screenPager.getCurrentItem();
                if (position < mList.size()) {
                    position++;
                    screenPager.setCurrentItem(position);
                }

                if (position == mList.size()-1) { // when we reach the last screen
                    // TODO : show the GETSTARTED button and hide the indicator and the next button
                    loadLastScreen();
                }
            }
        });
    }

        //show the GETSTARTED button and hide the indicator and the next button
    private void loadLastScreen() {
        btnNext.setVisibility(View.INVISIBLE);
        btnGetStarted.setVisibility(View.VISIBLE);
        tabIndicator.setVisibility(View.INVISIBLE);
    }
}
