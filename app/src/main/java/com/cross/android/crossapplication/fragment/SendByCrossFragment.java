package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cross.android.crossapplication.R;

public class SendByCrossFragment extends Fragment {

    Button sendbycross_next_imagebutton;
    FragmentManager fragmentManager;
    EditText sendbycross_account_edittext;
    CheckReceiverFragment checkReceiverFragment = new CheckReceiverFragment();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sendbycross,null);
        sendbycross_next_imagebutton = view.findViewById(R.id.sendbycross_next_imagebutton);
        sendbycross_account_edittext = view.findViewById(R.id.sendbycross_account_edittext);


        Bundle bundle = new Bundle();
        bundle.putString("amount", getArguments().getString("amount"));
        bundle.putString("symbol", getArguments().getString("symbol"));
        bundle.putString("address", sendbycross_account_edittext.getText().toString());
        checkReceiverFragment.setArguments(bundle);
        fragmentManager = getFragmentManager();
        sendbycross_next_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.remittance_framelayout, checkReceiverFragment, "checkreceiverfragment").commit();
            }
        });

        return view;
    }
}
