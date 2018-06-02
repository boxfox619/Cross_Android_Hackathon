package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cross.android.crossapplication.R;

public class SelectCoinFragment extends Fragment {

    FragmentManager fragmentManager;

    LinearLayout selectcoin_bitcoin_linearlayout, selectcoin_etherium_linearlayout, selectcoin_dash_linearlayout, selectcoin_monero_linearlayout, selectcoin_ethereumclassic_linearlayout,
            selectcoin_litecoin_linearlayout, selectcoin_ripple_linearlayout, selectcoin_aurouracoin_linearlayout, selectcoin_dogecoin_linearlayout, selectcoin_flash_linearlayout,
            selectcoin_namecoin_linearlayout, selectcoin_peercoin_linearlayout;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_selectcoin,null);
        fragmentManager = getFragmentManager();
        selectcoin_bitcoin_linearlayout = view.findViewById(R.id.selectcoin_bitcoin_linearlayout);
        selectcoin_etherium_linearlayout = view.findViewById(R.id.selectcoin_etherium_linearlayout);
        selectcoin_dash_linearlayout = view.findViewById(R.id.selectcoin_dash_linearlayout);
        selectcoin_monero_linearlayout = view.findViewById(R.id.selectcoin_monero_linearlayout);
        selectcoin_ethereumclassic_linearlayout = view.findViewById(R.id.selectcoin_ethereumclassic_linearlayout);
        selectcoin_litecoin_linearlayout = view.findViewById(R.id.selectcoin_litecoin_linearlayout);
        selectcoin_ripple_linearlayout = view.findViewById(R.id.selectcoin_ripple_linearlayout);
        selectcoin_aurouracoin_linearlayout = view.findViewById(R.id.selectcoin_aurouracoin_linearlayout);
        selectcoin_flash_linearlayout = view.findViewById(R.id.selectcoin_flash_linearlayout);
        selectcoin_dogecoin_linearlayout = view.findViewById(R.id.selectcoin_dogecoin_linearlayout);
        selectcoin_namecoin_linearlayout = view.findViewById(R.id.selectcoin_namecoin_linearlayout);
        selectcoin_peercoin_linearlayout = view.findViewById(R.id.selectcoin_peercoin_linearlayout);

        selectcoin_bitcoin_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_etherium_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_dash_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_monero_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_litecoin_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_ethereumclassic_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_ripple_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });selectcoin_aurouracoin_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });selectcoin_flash_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });selectcoin_dogecoin_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });

        selectcoin_namecoin_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });
        selectcoin_peercoin_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new RegisterWalletFragment(), "registerwalletfragment").commit();
            }
        });






        return view;
    }

}
