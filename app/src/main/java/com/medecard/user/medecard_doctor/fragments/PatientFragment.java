package com.medecard.user.medecard_doctor.fragments;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.medecard.user.medecard_doctor.CreateConsultationActivity;
import com.medecard.user.medecard_doctor.models.Patient;
import com.medecard.user.medecard_doctor.R;
import com.medecard.user.medecard_doctor.adapters.RecyclerViewAdapter_Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientFragment extends Fragment {

    ImageButton imageButton;
    Intent intent;

    private RecyclerView myrecyclerview;
    private List<Patient> listPatient;

    private Context context;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    public static PatientFragment newInstance() {
        PatientFragment fragment = new PatientFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listPatient = new ArrayList<>();

        listPatient.add(new Patient(R.drawable.cc3,
                "Biodun Hassan",
                "31 Opebi Road, Ikeja"));
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_patient, container,
                false);

        myrecyclerview = (RecyclerView) rootView.findViewById(R.id.recycler_patient);
        RecyclerViewAdapter_Patient recyclerViewAdapter_patient = new RecyclerViewAdapter_Patient
                (getContext(), listPatient);
        myrecyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecyclerview.setAdapter(recyclerViewAdapter_patient);

        imageButton = (ImageButton) rootView.findViewById(R.id.cons_create_btn);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(context, CreateConsultationActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
