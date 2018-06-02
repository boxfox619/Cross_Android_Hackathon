package com.cross.android.crossapplication.service;

import com.cross.android.crossapplication.model.Coin;
import com.cross.android.crossapplication.model.TransactionStatus;
import com.cross.android.crossapplication.model.Wallet;
import com.cross.android.crossapplication.model.WalletFile;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WalletService {

    @GET("support/wallet/list")
    Call<List<Coin>> getSupportedCoins();

    @FormUrlEncoded
    @POST("wallet/{symbol}/create")
    Call<WalletFile> createWallet(@Path("symbol") String symbol, @Field("name") String name,@Field("description")  String description, @Field("password")  String password, @Field("major")boolean major);

    @GET("wallet/list")
    Call<List<Wallet>> getWalletList();

    @GET("wallet/:symbol/balance")
    Call<String> getBalance(@Path("symbol") String symbol, @Query("address") String address);

    @GET("wallet/:symbol/price")
    Call<String> getPrice(@Path("symbol") String symbol, @Query("address") String address);

    @GET("wallet/:symbol/price/all")
    Call<String> getTotalPrice();

    @GET("wallet/{symbol}/lookup")
    Call<Wallet> getWalletInfo(@Path("symbol") String symbol, @Query("address") String address);


    @GET("wallet/:symbol/transaction")
    Call<TransactionStatus> getTransactionStatus(@Path("symbol") String symbol, @Query("hash") String hash);

    @GET("wallet/:symbol/transaction/count")
    Call<Integer> getTransactionCount(@Path("symbol") String symbol, @Query("address") String address);

    @GET("wallet/:symbol/transaction/list")
    Call<List<TransactionStatus>> transactionList(@Path("symbol") String symbol, @Query("address") String address);
}
