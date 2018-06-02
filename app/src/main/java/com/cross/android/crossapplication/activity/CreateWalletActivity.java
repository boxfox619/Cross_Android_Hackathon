package com.cross.android.crossapplication.activity;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.fragment.SelectCoinFragment;

public class CreateWalletActivity extends AppCompatActivity {

    FrameLayout createwallet_framelayout;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createwallet);
        createwallet_framelayout = findViewById(R.id.createwallet_framelayout);
        fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().add(R.id.createwallet_framelayout,new SelectCoinFragment(),"selectcoinfragment").commit();
    }
}