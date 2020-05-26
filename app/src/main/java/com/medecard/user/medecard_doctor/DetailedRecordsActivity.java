package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.medecard.user.medecard_doctor.adapters.RecyclerViewAdapter_DetailedRecords;
import com.medecard.user.medecard_doctor.models.DetailedRecords;

import java.util.ArrayList;
import java.util.List;

public class DetailedRecordsActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView;

    private RecyclerView myrecyclerview;
    private List<DetailedRecords> listDetailedRecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_records);

        listDetailedRecords = new ArrayList<>();

        listDetailedRecords.add(new DetailedRecords("15-04-1982",
                "St Nicholas Hospital, Lagos",
                "Dr Nnamdi Obiakor",
                "Monthly Checkup",
                "Not Started"));

        myrecyclerview = (RecyclerView) findViewById(R.id.recycler_drecords);
        RecyclerViewAdapter_DetailedRecords recyclerViewAdapterRecords = new
                RecyclerViewAdapter_DetailedRecords
                (DetailedRecordsActivity.this, listDetailedRecords);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(DetailedRecordsActivity.this));
        myrecyclerview.setAdapter(recyclerViewAdapterRecords);

        imageView = (ImageView) findViewById(R.id.back_rec);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DetailedRecordsActivity.this, RecordsActivity.class);
                startActivity(intent);
            }
        });
    }
}
