package com.cross.android.crossapplication.service;

import com.cross.android.crossapplication.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginService {
    @POST("signin/fb")
    Call<User> signin(@Body String accessToken);
}
