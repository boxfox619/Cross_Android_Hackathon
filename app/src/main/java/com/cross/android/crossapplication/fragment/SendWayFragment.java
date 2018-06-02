package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.cross.android.crossapplication.R;

public class SendWayFragment extends Fragment {

    LinearLayout remittance_wallet_linearlayout, remittance_cross_linearlayout, remittance_friend_linearlayout;
    FragmentManager fragmentManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sendway, null);
        remittance_friend_linearlayout = view.findViewById(R.id.remittance_friend_linearlayout);
        remittance_cross_linearlayout = view.findViewById(R.id.remittance_cross_linearlayout);
        remittance_wallet_linearlayout = view.findViewById(R.id.remittance_wallet_linearlayout);
        fragmentManager = getFragmentManager();

        remittance_cross_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fragmentManager.beginTransaction().replace(R.id.remittance_framelayout, new SendByCrossFragment(), "sendbycrossfragment").commit();
            }
        });

        remittance_wallet_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 지갑으로 전송하는 방법 연결
            }
        });

        remittance_friend_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 친구로 전송하는 방법 연결
            }
        });
        return view;
    }
}
