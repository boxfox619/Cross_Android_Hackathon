package com.cross.android.crossapplication.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.fragment.Remittance1Fragment;

public class RemittanceActivity extends AppCompatActivity {

    FrameLayout remittance_framelayout;
    FragmentManager fragmentManager;
    Remittance1Fragment remittance1Fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remittance);
        remittance_framelayout = findViewById(R.id.remittance_framelayout);
        fragmentManager = getFragmentManager();
        remittance1Fragment = new Remittance1Fragment();

        fragmentManager.beginTransaction().add(R.id.remittance_framelayout,remittance1Fragment,"remittance1fragment").commit();

    }
}
