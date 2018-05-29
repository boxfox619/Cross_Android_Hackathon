package com.cross.android.crossapplication.data;

public class CoinItem {

    String coin_name, coin_hold, coin_unit, coin_price;

    public CoinItem(String coin_name, String coin_hold, String coin_unit, String coin_price) {
        this.coin_name = coin_name;
        this.coin_hold = coin_hold;
        this.coin_unit = coin_unit;
        this.coin_price = coin_price;
    }

    public String getCoin_name() {
        return coin_name;
    }

    public void setCoin_name(String coin_name) {
        this.coin_name = coin_name;
    }

    public String getCoin_hold() {
        return coin_hold;
    }

    public void setCoin_hold(String coin_hold) {
        this.coin_hold = coin_hold;
    }

    public String getCoin_unit() {
        return coin_unit;
    }

    public void setCoin_unit(String coin_unit) {
        this.coin_unit = coin_unit;
    }

    public String getCoin_price() {
        return coin_price;
    }

    public void setCoin_price(String coin_price) {
        this.coin_price = coin_price;
    }
}
