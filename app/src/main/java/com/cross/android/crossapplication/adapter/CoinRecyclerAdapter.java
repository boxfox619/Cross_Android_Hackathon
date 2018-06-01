package com.cross.android.crossapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.data.CoinItem;

import java.util.ArrayList;

public class CoinRecyclerAdapter extends RecyclerView.Adapter<CoinRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<CoinItem> coinItems;

    public CoinRecyclerAdapter(Context context, ArrayList<CoinItem> coinItems) {
        this.context = context;
        this.coinItems = coinItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.coin_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.coin_name_textview.setText(coinItems.get(position).getCoin_name());
        holder.coin_hold_textview.setText(coinItems.get(position).getCoin_hold());
        holder.coin_unit_textview.setText(coinItems.get(position).getCoin_unit());
        holder.coin_price_textview.setText(coinItems.get(position).getCoin_price());

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView coin_name_textview, coin_hold_textview, coin_unit_textview, coin_price_textview;

        public ViewHolder(View view) {
            super(view);
            coin_name_textview = view.findViewById(R.id.coin_name_textview);
            coin_hold_textview = view.findViewById(R.id.coin_hold_textview);
            coin_unit_textview = view.findViewById(R.id.coin_unit_textview);

        }
    }

}
