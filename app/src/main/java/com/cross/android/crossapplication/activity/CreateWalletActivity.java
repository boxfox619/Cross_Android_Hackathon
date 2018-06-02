package com.cross.android.crossapplication.activity;

import android.app.FragmentManager;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.fragment.SelectCoinFragment;

public class CreateWalletActivity extends AppCompatActivity {

    FrameLayout createwallet_framelayout;
    FragmentManager fragmentManager;
    ImageView remittance_close_imageveiw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createwallet);
        createwallet_framelayout = findViewById(R.id.createwallet_framelayout);
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.createwallet_framelayout,new SelectCoinFragment(),"selectcoinfragment").commit();
        remittance_close_imageveiw = findViewById(R.id.remittance_close_imageveiw);
        remittance_close_imageveiw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}