package com.cross.android.crossapplication.adapter;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.FragmentManager;
import android.app.WallpaperColors;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cross.android.crossapplication.R;
import com.cross.android.crossapplication.fragment.SetCoinCountFragment;
import com.cross.android.crossapplication.model.Wallet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoinRecyclerAdapter extends RecyclerView.Adapter<CoinRecyclerAdapter.ViewHolder> {

    List<Wallet> coinItems;
    Context context;
    private boolean visibleMenu = true;

    public CoinRecyclerAdapter(Context context, List<Wallet> coinItems) {
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
        holder.coin_name_textview.setText(coinItems.get(position).getName());
        holder.coin_hold_textview.setText(coinItems.get(position).getBalance());
        holder.coin_unit_textview.setText(coinItems.get(position).getSymbol());
        holder.coin_item_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityManager m = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
                List<ActivityManager.RunningTaskInfo> runningTaskInfoList = m.getRunningTasks(10);
                Iterator<ActivityManager.RunningTaskInfo> itr = runningTaskInfoList.iterator();
                ActivityManager.RunningTaskInfo runningTaskInfo  = itr.next();
                String topActivity = runningTaskInfo.topActivity.getShortClassName();
                if(topActivity.equals(".activity.RemittanceActivity")){
                    FragmentManager fragmentManager = ((Activity) context).getFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.remittance_framelayout,new SetCoinCountFragment(),"fragment_setcoincount").commit();
                }
            }
        });
        if(!visibleMenu)
            holder.btn_menu.setVisibility(View.INVISIBLE);
    }

    @Override
    public int getItemCount() {
        return coinItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView coin_name_textview, coin_hold_textview, coin_unit_textview;
        LinearLayout coin_item_linearlayout;
        View btn_menu;


        public ViewHolder(View view) {
            super(view);
            coin_name_textview = view.findViewById(R.id.coin_name_textview);
            coin_hold_textview = view.findViewById(R.id.coin_hold_textview);
            coin_unit_textview = view.findViewById(R.id.coin_unit_textview);
            coin_item_linearlayout = view.findViewById(R.id.coin_item_linearlayout);
            btn_menu = view.findViewById(R.id.btn_menu);
        }
    }

    public void setVisibleMenu(boolean visibleMenu){
        this.visibleMenu = visibleMenu;
    }

    public void clear() {
        this.coinItems.removeAll(coinItems);
        this.notifyDataSetChanged();
    }

    public void add(Wallet wallet){
        this.coinItems.add(wallet);
    }

}
