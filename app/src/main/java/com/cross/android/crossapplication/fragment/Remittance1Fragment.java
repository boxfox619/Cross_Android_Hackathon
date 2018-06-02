package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.CoinRecyclerAdapter;
import com.cross.android.crossapplication.model.Wallet;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class Remittance1Fragment extends Fragment {

    RecyclerView remittance_recyclerview;
    CoinRecyclerAdapter coinRecyclerAdapter;
    ArrayList<Wallet> wallets = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remittance1, null);
        coinRecyclerAdapter = new CoinRecyclerAdapter(getActivity(), wallets);
        coinRecyclerAdapter.setVisibleMenu(false);
        remittance_recyclerview = view.findViewById(R.id.remittance_recyclerview);

        RealmResults<Wallet> walletResult = Realm.getDefaultInstance().where(Wallet.class).findAll();
        for(Wallet w : walletResult){
            wallets.add(w);
        }
        remittance_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        remittance_recyclerview.setAdapter(coinRecyclerAdapter);

        return view;
    }
}
