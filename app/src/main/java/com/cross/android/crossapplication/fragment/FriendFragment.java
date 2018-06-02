package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.FriendRecyclerAdapter;
import com.cross.android.crossapplication.model.User;
import com.cross.android.crossapplication.service.FriendService;
import com.cross.android.crossapplication.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendFragment extends Fragment {

    RecyclerView friend_recyclerview;
    FriendRecyclerAdapter friendRecyclerAdapter;
    ArrayList<User> users1;

    Button friend_next_button;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, null);
        friend_recyclerview = view.findViewById(R.id.friend_recyclerview);
        friend_next_button = view.findViewById(R.id.friend_next_button);
        friend_next_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
        users1 = new ArrayList<>();
        friendRecyclerAdapter = new FriendRecyclerAdapter(getActivity(), users1);
        RetrofitUtil.create(getActivity()).create(FriendService.class).getFriends().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                Log.d("DEBUG", String.valueOf(response.body()));
                if (response.isSuccessful()) {
                    List<User> users = response.body();
                    for (int i = 0; i < users.size(); i++) {
                        users1.add(new User(users.get(i).getName(), users.get(i).getEmail()));
                        friend_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
                        friend_recyclerview.setAdapter(friendRecyclerAdapter);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(getActivity(), "서버 오류 발생", Toast.LENGTH_SHORT).show();
                Log.d("DEBUG", t.toString());
            }
        });





        return view;
    }
}
