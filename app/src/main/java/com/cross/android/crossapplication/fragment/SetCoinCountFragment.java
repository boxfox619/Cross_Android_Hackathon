package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.cross.android.crossapplication.R;

public class SetCoinCountFragment extends Fragment {

    ImageButton setcoincount_next_imagebutton;
    FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setcoincount, null);
        setcoincount_next_imagebutton = view.findViewById(R.id.setcoincount_next_imagebutton);
        fragmentManager = getActivity().getFragmentManager();

        setcoincount_next_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left,R.anim.slide_out_right)
                        .replace(R.id.remittance_framelayout, new SendWayFragment(), "sendwayfragment").commit();

            }
        });
        return view;
    }
}
