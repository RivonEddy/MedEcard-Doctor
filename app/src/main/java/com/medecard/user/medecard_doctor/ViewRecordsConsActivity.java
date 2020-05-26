package com.medecard.user.medecard_doctor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ViewRecordsConsActivity extends AppCompatActivity {

    Intent intent;
    ImageView imageView;
    ImageButton imageButton;
    LinearLayout linearLayout, linearLayout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_records_cons);

        imageView = (ImageView) findViewById(R.id.back_btn_vrec_con);
        imageButton = (ImageButton) findViewById(R.id.drop_btn);
        linearLayout = (LinearLayout) findViewById(R.id.drop_down_vrec);
        linearLayout1 = (LinearLayout) findViewById(R.id.detailed__crec);

        imageButton.setImageDrawable(getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
        linearLayout1.setVisibility(View.GONE);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(ViewRecordsConsActivity.this, ConsultationsActivity.class);
                startActivity(intent);
            }
        });

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton.setImageDrawable(getDrawable(R.drawable.ic_arrow_drop_down_black_24dp));
                linearLayout1.setVisibility(View.VISIBLE);
            }
        });

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageButton.setImageDrawable(getDrawable(R.drawable.ic_arrow_drop_up_black_24dp));
                linearLayout1.setVisibility(View.GONE);
            }
        });

    }
}
