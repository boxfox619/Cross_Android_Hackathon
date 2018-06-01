package com.cross.android.crossapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;

import com.cross.android.crossapplication.R;

import net.cachapa.expandablelayout.ExpandableLayout;

public class MainActivity extends Activity {

    LinearLayout main_linearlayout1 ;
    ExpandableLayout main_topbox_linearlayout;
    boolean topFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_linearlayout1 = findViewById(R.id.main_linearlayout1);
        main_topbox_linearlayout = findViewById(R.id.main_topbox_linearlayout);

        main_topbox_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_topbox_linearlayout.setExpanded(true, true);
            }
        });


    }


}
