package com.cross.android.crossapplication.util;

import android.content.Context;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.User;

import java.io.IOException;

import io.realm.Realm;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    public static Retrofit create(Context ctx){
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                Realm realm = Realm.getDefaultInstance();
                Request.Builder builder = originalRequest.newBuilder();
                if(realm.where(User.class).count()>0){
                    builder.header("Authorization", realm.where(User.class).findFirst().getToken());
                }
                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ctx.getString(R.string.server_host))
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
