package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class PatientDetailsActivity extends AppCompatActivity {

    ImageView imageView;
    LinearLayout linearLayout, linearLayout1, linearLayout2;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_details);

        linearLayout = (LinearLayout) findViewById(R.id.pers_info_pt);
        linearLayout1 = (LinearLayout) findViewById(R.id.records_pt);
        linearLayout2 = (LinearLayout) findViewById(R.id.consult_pt);
        imageView = (ImageView) findViewById(R.id.pt_back_btn);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PatientDetailsActivity.this, PersonalInfoPTActivity.class);
                startActivity(intent);
            }
        });

        linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PatientDetailsActivity.this, RecordsActivity.class);
                startActivity(intent);
            }
        });

        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PatientDetailsActivity.this, ConsultationsActivity.class);
                startActivity(intent);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(PatientDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
