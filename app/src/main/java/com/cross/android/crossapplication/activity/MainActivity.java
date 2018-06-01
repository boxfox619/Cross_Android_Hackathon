package com.cross.android.crossapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.cross.android.crossapplication.R;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import net.cachapa.expandablelayout.ExpandableLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout main_topbox_linearlayout;
    ExpandableLinearLayout main_topbox_expandable;
    boolean flag = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_topbox_linearlayout = findViewById(R.id.main_topbox_linearlayout);
        main_topbox_expandable = findViewById(R.id.main_topbox_expandable);



        main_topbox_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == true){
                    main_topbox_expandable.expand();

                    main_topbox_linearlayout.setBackground(getDrawable(R.color.colorWhite));
                    flag = false;
                }else{
                    main_topbox_expandable.collapse();
                    flag = true;
                }

            }
        });

    }


}
