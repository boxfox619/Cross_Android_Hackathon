package com.cross.android.crossapplication.service;

import com.cross.android.crossapplication.model.TransactionResult;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RemittanceService {

    @POST("wallet/:symbol/send")
    Call<TransactionResult> send(@Path("symbol") String symbol,
                                 @Body String walletFileName,
                                 @Body String walletJsonFile,
                                 @Body String password,
                                 @Body String targetAddress,
                                 @Body String amount);
}
