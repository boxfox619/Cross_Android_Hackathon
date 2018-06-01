package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cross.android.crossapplication.R;

public class Remittance1Fragment extends Fragment {

    RecyclerView remittance_recyclerview;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_remittance1, null);

        remittance_recyclerview = view.findViewById(R.id.remittance_recyclerview);


        return view;
    }
}
