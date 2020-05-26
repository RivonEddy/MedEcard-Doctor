package com.medecard.user.medecard_doctor.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.medecard.user.medecard_doctor.PatientDetailsActivity;
import com.medecard.user.medecard_doctor.R;
import com.medecard.user.medecard_doctor.models.Patient;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter_Patient extends RecyclerView.Adapter<RecyclerViewAdapter_Patient
        .MyViewHolder> {

    Intent intent;

    Context mContext;
    List<Patient> mData;

    public RecyclerViewAdapter_Patient(Context mContext, List<Patient> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recycler_patients_search, viewGroup, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.recycler_patient_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(mContext, PatientDetailsActivity.class);
                mContext.startActivity(intent);
            }
        });

        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.pt_img.setImageResource(mData.get(i).getPt_img());
        myViewHolder.pt_name.setText(mData.get(i).getPt_name());
        myViewHolder.pt_addrs.setText(mData.get(i).getPt_addrs());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout recycler_patient_search;
        private CircleImageView pt_img;
        private TextView pt_name;
        private TextView pt_addrs;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recycler_patient_search = (LinearLayout) itemView.findViewById(R.id
                    .recycler_patient_search);
            pt_img = (CircleImageView) itemView.findViewById(R.id.patient_img);
            pt_name = (TextView) itemView.findViewById(R.id.patient_name);
            pt_addrs = (TextView) itemView.findViewById(R.id.patient_address);
        }
    }
}
