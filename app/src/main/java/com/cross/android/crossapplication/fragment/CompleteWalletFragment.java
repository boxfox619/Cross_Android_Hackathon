package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cross.android.crossapplication.R;

public class CompleteWalletFragment extends Fragment {

    Button completewallet_ok_imageview;
    TextView a, b;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completewallet,null);
        a = view.findViewById(R.id.a);
        b = view.findViewById(R.id.b);


        a.setText(getArguments().getString("name"));
        a.setText(getArguments().getString("address"));
        completewallet_ok_imageview = view.findViewById(R.id.completewallet_ok_imageview);
        completewallet_ok_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}
