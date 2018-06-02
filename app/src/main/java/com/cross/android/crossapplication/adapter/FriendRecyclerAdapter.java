package com.cross.android.crossapplication.adapter;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.activity.LogActivity;
import com.cross.android.crossapplication.fragment.SetCoinCountFragment;
import com.cross.android.crossapplication.model.User;
import com.cross.android.crossapplication.model.Wallet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FriendRecyclerAdapter extends RecyclerView.Adapter<FriendRecyclerAdapter.ViewHolder> {

    List<User> users;
    Context context;

    public FriendRecyclerAdapter(Context context, List<User> users) {
        this.context = context;
        this.users= users;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.friend_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.friend_email.setText(users.get(position).getName());
        holder.friend_name.setText(users.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView friend_name, friend_email;
        CheckBox friend_checkbox;
        public ViewHolder(View view) {
            super(view);
            friend_checkbox = view.findViewById(R.id.friend_checkbox);
            friend_name = view.findViewById(R.id.friend_name);
            friend_email = view.findViewById(R.id.friend_email);
        }

    }



}
