package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    private ViewPager screenPager;
    IntroVewPagerAdapter introVewPagerAdapter;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

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

        textView = (TextView) findViewById(R.id.skip_btn);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this, LogRegActivity.class));
                finish();
            }
        });
    }
}
