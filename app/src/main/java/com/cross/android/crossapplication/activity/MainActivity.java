package com.cross.android.crossapplication.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.CoinRecyclerAdapter;
import com.cross.android.crossapplication.model.User;
import com.cross.android.crossapplication.model.Wallet;
import com.cross.android.crossapplication.service.WalletService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    LinearLayout main_topbox_linearlayout;
    DrawerLayout main_drawer_layout;
    RecyclerView main_coin_recyclerview;
    CoinRecyclerAdapter coinRecyclerAdapter;
    LinearLayout main_remittance_linearlayout, main_copy_linearlayout;
    NavigationView navigationView;
    TextView main_krbalance_textview, main_address_textview;
    Toolbar toolbar;
    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_krbalance_textview = findViewById(R.id.main_krbalance_textview);
        main_address_textview = findViewById(R.id.main_address_textview);
        main_topbox_linearlayout = findViewById(R.id.main_topbox_linearlayout);
        main_drawer_layout = findViewById(R.id.main_drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        main_remittance_linearlayout = findViewById(R.id.main_remittance_linearlayout);
        main_copy_linearlayout = findViewById(R.id.main_copy_linearlayout);
        main_coin_recyclerview = findViewById(R.id.main_coin_recyclerview);

        main_krbalance_textview.setText(getIntent().getStringExtra("krbalance"));

        List<Wallet> wallets = new ArrayList<>();
        RealmResults<Wallet> walletResult = Realm.getDefaultInstance().where(Wallet.class).findAll();
        for(Wallet w : walletResult){
            wallets.add(w);
        }
        coinRecyclerAdapter = new CoinRecyclerAdapter(MainActivity.this, wallets);

        main_remittance_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RemittanceActivity.class));
            }
        });
        main_copy_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RemittanceActivity.class));
            }
        });
        main_coin_recyclerview.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        main_coin_recyclerview.setAdapter(coinRecyclerAdapter);

        main_topbox_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == true){
                    main_topbox_linearlayout.setBackground(getDrawable(R.color.colorWhite));
                    flag = false;
                }else{
                    flag = true;
                }
            }
        });

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        toolbar.setOverflowIcon(ContextCompat.getDrawable(this, R.drawable.ic_menu_right));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main_drawer_layout.openDrawer(Gravity.START);
            }
        });
        toolbar.inflateMenu(R.menu.share_menu);
        findViewById(R.id.btn_create_wallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CreateWalletActivity.class));
            }
        });
        initViews();
    }

    @Override
    public void onResume() {
        super.onResume();
        List<Wallet> wallets = new ArrayList<>();
        RealmResults<Wallet> walletResult = Realm.getDefaultInstance().where(Wallet.class).findAll();
        for(Wallet w : walletResult){
            wallets.add(w);
        }
        coinRecyclerAdapter = new CoinRecyclerAdapter(MainActivity.this, wallets);
        main_coin_recyclerview.setAdapter(coinRecyclerAdapter);
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
        findViewById(R.id.iv_create_wallet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.btn_create_wallet).performClick();
            }
        });
        registerAnimation(main_remittance_linearlayout);
        registerAnimation(main_copy_linearlayout);
    }

    private void registerAnimation(final LinearLayout layout){
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        if (view instanceof TextView) {
                            ((TextView) view).setTextColor(Color.parseColor("#FFFFFF"));
                        } else if (view instanceof ImageView) {
                            ((ImageView) view).setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                        }
                    }
                    layout.setBackground(getDrawable(R.drawable.main_button_pressed_bg));
                }else if(event.getAction() == MotionEvent.ACTION_UP){
                    for (int i = 0; i < layout.getChildCount(); i++) {
                        View view = layout.getChildAt(i);
                        if (view instanceof TextView) {
                            ((TextView) view).setTextColor(Color.parseColor("#A283F3"));
                        } else if (view instanceof ImageView) {
                            ((ImageView) view).clearColorFilter();
                        }
                    }
                    layout.setBackground(getDrawable(R.drawable.main_button_bg));
                }
                return false;
            }
        });
    }


}
