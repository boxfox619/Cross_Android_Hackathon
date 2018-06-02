package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.cross.android.crossapplication.R;

public class SendByCrossFragment extends Fragment {

    ImageButton sendbycross_next_imagebutton;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sendbycross,null);
        sendbycross_next_imagebutton = view.findViewById(R.id.sendbycross_next_imagebutton);
        fragmentManager = getFragmentManager();
        sendbycross_next_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.remittance_framelayout, new CheckReceiverFragment(), "checkreceiverfragment").commit();
            }
        });

        return view;
    }
}
