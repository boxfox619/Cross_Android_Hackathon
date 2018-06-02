package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.adapter.FriendRecyclerAdapter;
import com.cross.android.crossapplication.model.User;
import com.cross.android.crossapplication.util.RetrofitUtil;

import java.util.ArrayList;

public class FriendFragment extends Fragment {

    RecyclerView friend_recyclerview;
    FriendRecyclerAdapter friendRecyclerAdapter;
    ArrayList<User> users;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_friend, null);
        friend_recyclerview = view.findViewById(R.id.friend_recyclerview);
        users = new ArrayList<>();
        friendRecyclerAdapter = new FriendRecyclerAdapter(getActivity(), users);
RetrofitUtil.create(getActivity())

        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));
        users.add(new User("sadf", "SDf"));


        friend_recyclerview.setAdapter(friendRecyclerAdapter);
        friend_recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }
}
