package com.cross.android.crossapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.Wallet;

import java.util.ArrayList;

public class CoinRecyclerAdapter extends RecyclerView.Adapter<CoinRecyclerAdapter.ViewHolder> {

    ArrayList<Wallet> coinItems;
    Context context;

    public CoinRecyclerAdapter(Context context) {
        this.context = context;
        this.coinItems = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.coin_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.coin_name_textview.setText(coinItems.get(position).getName());
        holder.coin_hold_textview.setText(coinItems.get(position).getBalance());
        holder.coin_unit_textview.setText(coinItems.get(position).getSymbol());
        holder.coin_item_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG","눌렀음");
            }
        });
    }

    @Override
    public int getItemCount() {
        return coinItems.size();
    }

    public void clear() {
        this.coinItems.removeAll(coinItems);
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView coin_name_textview, coin_hold_textview, coin_unit_textview;
        LinearLayout coin_item_linearlayout;

        public ViewHolder(View view) {
            super(view);
            coin_name_textview = view.findViewById(R.id.coin_name_textview);
            coin_hold_textview = view.findViewById(R.id.coin_hold_textview);
            coin_unit_textview = view.findViewById(R.id.coin_unit_textview);
            coin_item_linearlayout = view.findViewById(R.id.coin_item_linearlayout);
        }
    }

    public void add(Wallet wallet){
        this.coinItems.add(wallet);
    }

}
