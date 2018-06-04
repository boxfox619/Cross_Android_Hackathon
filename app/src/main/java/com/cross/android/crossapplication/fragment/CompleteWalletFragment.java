package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.activity.MainActivity;
import com.cross.android.crossapplication.activity.SplashActivity;
import com.cross.android.crossapplication.model.Wallet;
import com.cross.android.crossapplication.service.WalletService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        RetrofitUtil.create(getContext()).create(WalletService.class).getWalletList().enqueue(new Callback<List<Wallet>>() {
            @Override
            public void onResponse(Call<List<Wallet>> call, Response<List<Wallet>> response) {
                if(response.isSuccessful()){
                    List<Wallet> list = response.body();
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    realm.where(Wallet.class).findAll().deleteAllFromRealm();
                    realm.copyToRealm(list);
                    realm.commitTransaction();
                }
            }

            @Override
            public void onFailure(Call<List<Wallet>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return view;
    }
}
