package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RecordsActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        imageView = (ImageView) findViewById(R.id.rec_back_btn);
        linearLayout = (LinearLayout) findViewById(R.id.detl_rec);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RecordsActivity.this, PatientDetailsActivity.class);
                startActivity(intent);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(RecordsActivity.this, DetailedRecordsActivity.class);
                startActivity(intent);
            }
        });
    }
}
