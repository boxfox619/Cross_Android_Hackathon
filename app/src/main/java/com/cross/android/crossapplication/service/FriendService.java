package com.cross.android.crossapplication.service;

import com.cross.android.crossapplication.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FriendService {

    @GET("search/account/:type")
    Call<List<User>> searchFriends(@Path("type") String type, @Query("text") String text);

    @GET("friend")
    Call<List<User>> getFriends();

    @PUT("friend")
    Call<Void> addFriend(@Body String uid);

    @DELETE("friend")
    Call<Void> deleteFriend(@Body String uid);
}
