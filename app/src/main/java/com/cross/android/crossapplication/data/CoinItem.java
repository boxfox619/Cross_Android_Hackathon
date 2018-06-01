package com.cross.android.crossapplication.data;

public class CoinItem {

    String coin_name, coin_hold, coin_unit;

    public CoinItem(String coin_name, String coin_hold, String coin_unit) {
        this.coin_name = coin_name;
        this.coin_hold = coin_hold;
        this.coin_unit = coin_unit;
    }

    public String getCoin_name() {
        return coin_name;
    }


    public String getCoin_hold() {
        return coin_hold;
    }


    public String getCoin_unit() {
        return coin_unit;
    }


}
