package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cross.android.crossapplication.R;

public class CheckReceiverFragment extends Fragment {

    TextView checkreceiver_ok_textview, checkreceiver_cancel_textview;
    FragmentManager fragmentManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkreceiver, null);
        checkreceiver_ok_textview = view.findViewById(R.id.checkreceiver_ok_textview);
        checkreceiver_cancel_textview = view.findViewById(R.id.checkreceiver_cancel_textview);
        fragmentManager = getFragmentManager();

        checkreceiver_ok_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        checkreceiver_cancel_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.remittance_framelayout, new SendByCrossFragment(), "sendbycrossfragment").commit();
            }
        });

        return view;
    }
}
