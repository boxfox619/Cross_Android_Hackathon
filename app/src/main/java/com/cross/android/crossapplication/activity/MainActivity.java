package com.cross.android.crossapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.CoinRecyclerAdapter;
import com.cross.android.crossapplication.data.CoinItem;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout main_topbox_linearlayout;
    ExpandableLinearLayout main_topbox_expandable;
    DrawerLayout main_drawer_layout;
    ImageView main_drawer_imageview;
    RecyclerView main_coin_recyclerview;
    CoinRecyclerAdapter coinRecyclerAdapter;
    ArrayList<CoinItem> coinItems = new ArrayList<>();
    LinearLayout main_remittance_linearlayout;
    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_topbox_linearlayout = findViewById(R.id.main_topbox_linearlayout);
        main_topbox_expandable = findViewById(R.id.main_topbox_expandable);
        main_drawer_layout = findViewById(R.id.main_drawer_layout);
        main_drawer_imageview = findViewById(R.id.main_drawer_imageview);
        main_remittance_linearlayout = findViewById(R.id.main_remittance_linearlayout);
        main_coin_recyclerview = findViewById(R.id.main_coin_recyclerview);
        coinRecyclerAdapter = new CoinRecyclerAdapter(MainActivity.this, coinItems);

        main_remittance_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RemittanceActivity.class));
            }
        });


        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));
        coinItems.add(new CoinItem("Ethereum", "ETH", "32.0938274347"));




        main_coin_recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        main_coin_recyclerview.setAdapter(coinRecyclerAdapter);

        main_drawer_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_drawer_layout.openDrawer(Gravity.START);
            }
        });


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
