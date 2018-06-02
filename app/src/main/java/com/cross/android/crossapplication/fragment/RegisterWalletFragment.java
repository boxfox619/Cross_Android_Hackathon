package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.WalletFile;
import com.cross.android.crossapplication.service.WalletService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterWalletFragment extends Fragment {

    Button registerwallet_addwallet_imageview;
    FragmentManager fragmentManager;
    EditText registerwallet_walletname_edittext, registerwallet_description_edittext, registerwallet_pw_edittext, registerwallet_confirmpw_edittext;
    Bundle bundle = new Bundle();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registerwallet,null);
        registerwallet_addwallet_imageview = view.findViewById(R.id.registerwallet_addwallet_imageview);
        registerwallet_confirmpw_edittext = view.findViewById(R.id.registerwallet_confirmpw_edittext);
        registerwallet_description_edittext = view.findViewById(R.id.registerwallet_description_edittext);
        registerwallet_pw_edittext = view.findViewById(R.id.registerwallet_pw_edittext);
        registerwallet_walletname_edittext = view.findViewById(R.id.registerwallet_walletname_edittext);
        fragmentManager = getFragmentManager();
        registerwallet_addwallet_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitUtil.create(getActivity()).create(WalletService.class).createWallet("eth", registerwallet_walletname_edittext.getText().toString(), registerwallet_description_edittext.getText().toString(), registerwallet_pw_edittext.getText().toString(), false).enqueue(new Callback<WalletFile>() {
                    @Override
                    public void onResponse(Call<WalletFile> call, Response<WalletFile> response) {
                        if (response.isSuccessful()) {
                            WalletFile walletFile = response.body();
                            bundle.putString("address", walletFile.getAddress());
                            bundle.putString("name", walletFile.getName());
                        }else{
                            Log.d("DEBUG","Fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<WalletFile> call, Throwable t) {
                        Log.d("DEBUG","Fail");
                    }
                });

                fragmentManager.beginTransaction().replace(R.id.createwallet_framelayout,new CompleteWalletFragment(),"completewalletfragment").commit();
            }
        });
        return view;

    }
}
