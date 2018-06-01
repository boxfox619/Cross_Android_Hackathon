package com.cross.android.crossapplication.model;

import com.google.gson.JsonObject;

public class WalletFile {
    private String address;
    private String name;
    private JsonObject wallet;

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

    public JsonObject getWallet() {
        return wallet;
    }

    public void setWallet(JsonObject wallet) {
        this.wallet = wallet;
    }
}
