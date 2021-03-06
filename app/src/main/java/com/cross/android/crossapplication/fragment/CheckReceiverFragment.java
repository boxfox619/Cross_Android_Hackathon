package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.Wallet;
import com.cross.android.crossapplication.service.WalletService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CheckReceiverFragment extends Fragment {

    TextView checkreceiver_ok_textview, checkreceiver_cancel_textview;
    FragmentManager fragmentManager;
    TextView checkreceiver_description_textview, checkreceiver_email_textview, checkreceiver_name_textview, checkreceiver_coinaddress_textview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkreceiver, null);
        checkreceiver_ok_textview = view.findViewById(R.id.checkreceiver_ok_textview);
        checkreceiver_cancel_textview = view.findViewById(R.id.checkreceiver_cancel_textview);
        checkreceiver_description_textview = view.findViewById(R.id.checkreceiver_description_textview);
        checkreceiver_email_textview = view.findViewById(R.id.checkreceiver_email_textview);
        checkreceiver_name_textview = view.findViewById(R.id.checkreceiver_name_textview);
        checkreceiver_coinaddress_textview = view.findViewById(R.id.checkreceiver_coinaddress_textview);
        fragmentManager = getFragmentManager();

        RetrofitUtil.create(getActivity()).create(WalletService.class).getWalletInfo(getArguments().get("symbol").toString(), getArguments().get("address").toString()).enqueue(new Callback<Wallet>() {
            @Override
            public void onResponse(Call<Wallet> call, Response<Wallet> response) {
                if(response.isSuccessful()){

                }else{
                    Log.e("test", "asd");
                }
            }

            @Override
            public void onFailure(Call<Wallet> call, Throwable t) {
                t.printStackTrace();
            }
        });

        checkreceiver_ok_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        checkreceiver_cancel_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.remittance_framelayout, new SendByCrossFragment(), "sendbycrossfragment").commit();
            }
        });

        return view;
    }
}
