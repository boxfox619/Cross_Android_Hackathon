package com.cross.android.crossapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.model.TransactionStatus;

import java.util.List;

public class LogRecyclerAdapter extends RecyclerView.Adapter<LogRecyclerAdapter.ViewHolder> {

    List<TransactionStatus> transactionStatuses;
    Context context;

    public LogRecyclerAdapter(Context context, List<TransactionStatus> transactionStatuses) {
        this.context = context;
        this.transactionStatuses = transactionStatuses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.log_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public int getItemCount() {
        return transactionStatuses.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.log_date_textview.setText(transactionStatuses.get(position).getDate());
        holder.log_email_textview.setText(transactionStatuses.get(position).getEmail());
        holder.log_hash_textview.setText(transactionStatuses.get(position).getTransactionHash());
        if (transactionStatuses.get(position).getStatus() == true) {
            holder.log_success_imageview.setBackground(context.getDrawable(R.drawable.ic_success));
            holder.log_success_textview.setText("Success");
        } else {
            holder.log_success_imageview.setBackground(context.getDrawable(R.drawable.ic_red_circle));
            holder.log_success_textview.setText("Fail");
        }
        if (transactionStatuses.get(position).getBlockNumber().intValue() < 0) {
            holder.log_amount_textview.setText(String.valueOf("-" + transactionStatuses.get(position).getAmount() + "ETH"));
            holder.log_amount_textview.setTextColor(context.getColor(R.color.colorRed));
        } else {
            holder.log_amount_textview.setText(String.valueOf("+" + transactionStatuses.get(position).getAmount() + "ETH"));
            holder.log_amount_textview.setTextColor(context.getColor(R.color.colorGreen));
        }

        holder.log_confirmation_textview.setText("Confirmed" + String.valueOf(transactionStatuses.get(position).getConfirmation()));

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView log_date_textview, log_email_textview, log_hash_textview, log_success_textview, log_amount_textview, log_confirmation_textview;
        ImageView log_success_imageview;

        public ViewHolder(View view) {
            super(view);
            log_date_textview = view.findViewById(R.id.log_date_textview);
            log_email_textview = view.findViewById(R.id.log_email_textview);
            log_hash_textview = view.findViewById(R.id.log_hash_textview);
            log_success_imageview = view.findViewById(R.id.log_success_imageview);
            log_success_textview = view.findViewById(R.id.log_success_textview);
            log_amount_textview = view.findViewById(R.id.log_amount_textview);
            log_confirmation_textview = view.findViewById(R.id.log_confirmation_textview);

        }
    }

}








