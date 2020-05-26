package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.medecard.user.medecard_doctor.adapters.RecyclerViewAdapter_Consultations;
import com.medecard.user.medecard_doctor.models.Consultations;

import java.util.ArrayList;
import java.util.List;

public class ConsultationsActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView, imageView1;

    private RecyclerView myrecyclerview;
    private List<Consultations> listConsultations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultations);

        listConsultations = new ArrayList<>();

        listConsultations.add(new Consultations("15-04-1982",
                "St Nicholas Hospital, Lagos",
                "Dr Nnamdi Obiakor",
                "Monthly Checkup",
                "Not Started"));

        myrecyclerview = (RecyclerView) findViewById(R.id.recycler_consult);
        RecyclerViewAdapter_Consultations recyclerViewAdapterRecords = new RecyclerViewAdapter_Consultations
                (ConsultationsActivity.this, listConsultations);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(ConsultationsActivity.this));
        myrecyclerview.setAdapter(recyclerViewAdapterRecords);

        imageView = (ImageView) findViewById(R.id.cons_back_btn);
        imageView1 = (ImageView) findViewById(R.id.create_cons_btn);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ConsultationsActivity.this, PatientDetailsActivity.class);
                startActivity(intent);
            }
        });

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ConsultationsActivity.this, CreateConsultationActivity.class);
                startActivity(intent);
            }
        });
    }
}
