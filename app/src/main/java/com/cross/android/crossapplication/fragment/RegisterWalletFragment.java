package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.Wallet;
import com.cross.android.crossapplication.model.WalletFile;
import com.cross.android.crossapplication.service.WalletService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import java.util.List;

import io.realm.Realm;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterWalletFragment extends Fragment {

    Button registerwallet_addwallet_imageview;
    FragmentManager fragmentManager;
    EditText registerwallet_walletname_edittext, registerwallet_description_edittext, registerwallet_pw_edittext, registerwallet_confirmpw_edittext;
    Bundle bundle = new Bundle();
    CompleteWalletFragment completeWalletFragment = new CompleteWalletFragment();

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
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("지갑을 생성중입니다");
        registerwallet_addwallet_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                RetrofitUtil.create(getActivity()).create(WalletService.class).createWallet("eth", registerwallet_walletname_edittext.getText().toString(), registerwallet_description_edittext.getText().toString(), registerwallet_pw_edittext.getText().toString(), false).enqueue(new Callback<WalletFile>() {
                    @Override
                    public void onResponse(Call<WalletFile> call, Response<WalletFile> response) {
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
                                    getActivity().finish();
                                }
                            }
                            @Override
                            public void onFailure(Call<List<Wallet>> call, Throwable t) {
                                t.printStackTrace();
                                getActivity().finish();
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<WalletFile> call, Throwable t) {
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
                                    getActivity().finish();
                                }
                            }
                            @Override
                            public void onFailure(Call<List<Wallet>> call, Throwable t) {
                                t.printStackTrace();
                                getActivity().finish();
                            }
                        });
                    }
                });


            }
        });
        return view;

    }
}
