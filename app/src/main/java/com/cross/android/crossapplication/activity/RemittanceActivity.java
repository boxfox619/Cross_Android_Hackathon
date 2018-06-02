package com.cross.android.crossapplication.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.fragment.Remittance1Fragment;

public class RemittanceActivity extends AppCompatActivity {

    FrameLayout remittance_framelayout;
    FragmentManager fragmentManager;
    Remittance1Fragment remittance1Fragment;
    ImageView remittance_close_imageveiw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remittance);
        remittance_close_imageveiw = findViewById(R.id.remittance_close_imageveiw);
        remittance_framelayout = findViewById(R.id.remittance_framelayout);
        fragmentManager = getFragmentManager();
        remittance1Fragment = new Remittance1Fragment();
        remittance_close_imageveiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        fragmentManager.beginTransaction().add(R.id.remittance_framelayout,remittance1Fragment,"remittance1fragment").commit();

    }
}
