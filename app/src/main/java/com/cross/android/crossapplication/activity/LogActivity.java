package com.cross.android.crossapplication.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.LogRecyclerAdapter;
import com.cross.android.crossapplication.model.TransactionStatus;
import com.cross.android.crossapplication.model.User;
import com.cross.android.crossapplication.model.Wallet;
import com.cross.android.crossapplication.service.WalletService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogActivity extends AppCompatActivity {

    RecyclerView log_coin_recyclerview;
    DrawerLayout log_drawer_layout;
    Toolbar log_toolbar;
    ArrayList<TransactionStatus> transactionStatuses;
    LogRecyclerAdapter logRecyclerAdapter;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        transactionStatuses = new ArrayList<>();
        logRecyclerAdapter = new LogRecyclerAdapter(LogActivity.this, transactionStatuses);
        log_coin_recyclerview = findViewById(R.id.log_coin_recyclerview);
        log_drawer_layout = findViewById(R.id.log_drawer_layout);
        String address = getIntent().getStringExtra("address");
        Realm realm = Realm.getDefaultInstance();
        Wallet wallet = realm.where(Wallet.class).equalTo("crossAddress",address).findFirst();
        ((TextView)findViewById(R.id.log_name_imageview)).setText(wallet.getName());
        ((TextView)findViewById(R.id.tv_balance)).setText(wallet.getBalance());
        ((TextView)findViewById(R.id.tv_address)).setText(wallet.getOriginalAddress());
        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("기록을 가져오는중입니다");
        dialog.show();
        RetrofitUtil.create(this).create(WalletService.class).transactionList(wallet.getSymbol(), wallet.getOriginalAddress()).enqueue(new Callback<List<TransactionStatus>>() {
            @Override
            public void onResponse(Call<List<TransactionStatus>> call, Response<List<TransactionStatus>> response) {
                List<TransactionStatus> statuses = response.body();
                for(TransactionStatus status : statuses){
                    transactionStatuses.add(status);
                }
                logRecyclerAdapter.notifyDataSetChanged();
                dialog.hide();
            }

            @Override
            public void onFailure(Call<List<TransactionStatus>> call, Throwable t) {
                dialog.hide();
            }
        });

        log_coin_recyclerview.setLayoutManager(new LinearLayoutManager(LogActivity.this));
        log_coin_recyclerview.setAdapter(logRecyclerAdapter);
        navigationView = findViewById(R.id.log_navigation_view);


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
        initViews();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.share_menu, menu);
        return true;
    }

    private void initViews(){
        Realm realm = Realm.getDefaultInstance();
        User user = realm.where(User.class).findFirst();
        ((TextView)navigationView.getHeaderView(0).findViewById(R.id.tv_name)).setText(user.getName());
        ((TextView)navigationView.getHeaderView(0).findViewById(R.id.tv_email)).setText(user.getEmail());
    }
}
