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

import com.medecard.user.medecard_doctor.models.DetailedRecords;
import com.medecard.user.medecard_doctor.R;
import com.medecard.user.medecard_doctor.ViewRecordsActivity;

import java.util.List;

public class RecyclerViewAdapter_DetailedRecords extends RecyclerView
        .Adapter<RecyclerViewAdapter_DetailedRecords.MyViewHolder> {

    Intent intent;

    Context mContext;
    List<DetailedRecords> mData;

    public RecyclerViewAdapter_DetailedRecords(Context mContext, List<DetailedRecords> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.recycler_consultations_drecords, viewGroup, false);
        MyViewHolder vHolder = new MyViewHolder(v);

        vHolder.recycler_cons_drec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(mContext, ViewRecordsActivity.class);
                mContext.startActivity(intent);
            }
        });


        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.tv_date.setText(mData.get(i).getDate());
        myViewHolder.tv_hosp_location.setText(mData.get(i).getHosp_location());
        myViewHolder.tv_doctor_name.setText(mData.get(i).getDoctor_name());
        myViewHolder.tv_cons_type.setText(mData.get(i).getCons_type());
        myViewHolder.tv_cons_status.setText(mData.get(i).getCons_status());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout recycler_cons_drec;
        private TextView tv_date;
        private TextView tv_hosp_location;
        private TextView tv_doctor_name;
        private TextView tv_cons_type;
        private TextView tv_cons_status;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            recycler_cons_drec = (LinearLayout) itemView.findViewById(R.id
                    .recycler_cons_drec);
            tv_date = (TextView) itemView.findViewById(R.id.cons_date);
            tv_hosp_location = (TextView) itemView.findViewById(R.id.cons_hosp_address);
            tv_doctor_name = (TextView) itemView.findViewById(R.id.cons_doc_name);
            tv_cons_type = (TextView) itemView.findViewById(R.id.cons_type);
            tv_cons_status = (TextView) itemView.findViewById(R.id.cons_status);

        }
    }
}
