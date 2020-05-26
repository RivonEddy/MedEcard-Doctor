package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;

import static com.thekhaeng.pushdownanim.PushDownAnim.MODE_STATIC_DP;

public class PersonalInfoPTActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info_pt);
        button = (Button) findViewById(R.id.ok_btn);
        imageView = (ImageView) findViewById(R.id.pinfo_back_btn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PersonalInfoPTActivity.this, PatientDetailsActivity.class);
                startActivity(intent);
            }
        });

        PushDownAnim.setPushDownAnimTo(button)
                .setScale(MODE_STATIC_DP, 8 )
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        intent = new Intent(PersonalInfoPTActivity.this, PatientDetailsActivity.class);
                        startActivity(intent);
                    }
                });
    }
}
