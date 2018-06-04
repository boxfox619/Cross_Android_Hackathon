package com.cross.android.crossapplication.model;

import io.realm.RealmObject;

public class WalletFile extends RealmObject{
    private String address;
    private String name;
    private String wallet;

    public WalletFile(){

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }
}
