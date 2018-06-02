package com.cross.android.crossapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.LogRecyclerAdapter;
import com.cross.android.crossapplication.model.TransactionStatus;

import java.math.BigInteger;
import java.util.ArrayList;

public class LogActivity extends AppCompatActivity {

    RecyclerView log_coin_recyclerview;
    DrawerLayout log_drawer_layout;
    Toolbar log_toolbar;
    ArrayList<TransactionStatus> transactionStatuses;
    LogRecyclerAdapter logRecyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        transactionStatuses = new ArrayList<>();
        logRecyclerAdapter = new LogRecyclerAdapter(LogActivity.this, transactionStatuses);
        log_coin_recyclerview = findViewById(R.id.log_coin_recyclerview);
        log_drawer_layout = findViewById(R.id.log_drawer_layout);


        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", true, 12, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", false, 12, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", true, 12, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", true, 123, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", false, 123, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", true, 123, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", true, 123, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", false, 123, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        transactionStatuses.add(new TransactionStatus("0xasd1231fdva1231vas", true, 123, BigInteger.valueOf(123), BigInteger.valueOf(123), "dogyhbin12345@gmail.com", "2018.01.02"));
        log_coin_recyclerview.setLayoutManager(new LinearLayoutManager(LogActivity.this));
        log_coin_recyclerview.setAdapter(logRecyclerAdapter);


        log_toolbar = findViewById(R.id.log_toolbar);
        setSupportActionBar(log_toolbar);
        log_toolbar.setNavigationIcon(R.drawable.ic_menu);
        log_toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.ic_menu_right));
        log_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log_drawer_layout.openDrawer(Gravity.START);
            }
        });
        log_toolbar.inflateMenu(R.menu.share_menu);
    }
}
