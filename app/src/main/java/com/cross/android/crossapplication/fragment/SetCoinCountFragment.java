package com.cross.android.crossapplication.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.cross.android.crossapplication.R;

public class SetCoinCountFragment extends Fragment {

    LinearLayout remittance_wallet_linearlayout, remittance_cross_linearlayout, remittance_friend_linearlayout;
    FragmentManager fragmentManager;
    EditText setcoincount_amount_edittext;

    View overlay;
    LinearLayout bottomSheet;
    BottomSheetBehavior mBottomSheetBehavior;
   Button setcoincount_next_imagebutton;

    SendByCrossFragment sendByCrossFragment = new SendByCrossFragment();



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setcoincount, null);

        remittance_friend_linearlayout = view.findViewById(R.id.remittance_friend_linearlayout);
        remittance_cross_linearlayout = view.findViewById(R.id.remittance_cross_linearlayout);
        remittance_wallet_linearlayout = view.findViewById(R.id.remittance_wallet_linearlayout);
        setcoincount_amount_edittext = view.findViewById(R.id.setcoincount_amount_edittext);
        Log.d("DEBUG", getArguments().getString("symbol"));

        fragmentManager = getActivity().getFragmentManager();

        remittance_cross_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("amount",setcoincount_amount_edittext.getText().toString());
                bundle.putString("symbol",getArguments().getString("symbol"));
                sendByCrossFragment.setArguments(bundle);
                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.remittance_framelayout, sendByCrossFragment, "sendbycrossfragment").commit();

            }
        });

        remittance_wallet_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 지갑으로 전송하는 방법 연결
            }
        });

        remittance_friend_linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).replace(R.id.remittance_framelayout, new FriendFragment(), "friendfragmentd").commit();
            }
        });

        overlay = view.findViewById(R.id.overlay_background);
        setcoincount_next_imagebutton = view.findViewById(R.id.setcoincount_next_imagebutton);

        bottomSheet = view.findViewById(R.id.bottom_sheet);

        mBottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        mBottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState){
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        if(overlay.getVisibility() == View.VISIBLE) {
                            overlay.setVisibility(View.INVISIBLE);
                            fadeAnimation(overlay, false);
                        }
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        fragmentManager = getActivity().getFragmentManager();

        setcoincount_next_imagebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overlay.setVisibility(View.VISIBLE);
                fadeAnimation(overlay, true);
                /*fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right)
                        .replace(R.id.remittance_framelayout, new SendWayFragment(), "sendwayfragment").commit();*/
                mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        return view;
    }

    public void fadeAnimation(final View view, boolean isfadeOut) {
        final Animation animationFade;
        view.setAlpha(0f);
        if (isfadeOut) {
            animationFade = AnimationUtils.loadAnimation(getContext(), R.anim.fadeout);
        } else {
            animationFade = AnimationUtils.loadAnimation(getContext(), R.anim.fadein);
        }
        Handler mhandler = new Handler();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                view.setAlpha(1f);
                view.startAnimation(animationFade);
            }
        }, 0);
    }
}
