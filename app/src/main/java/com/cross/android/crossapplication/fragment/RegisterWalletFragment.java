package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cross.android.crossapplication.R;

public class RegisterWalletFragment extends Fragment {

    ImageView registerwallet_addwallet_imageview;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registerwallet,null);
        registerwallet_addwallet_imageview = view.findViewById(R.id.registerwallet_addwallet_imageview);
        fragmentManager = getFragmentManager();
        registerwallet_addwallet_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new CompleteWalletFragment(),"completewalletfragment").commit();
            }
        });
        return view;

    }
}
