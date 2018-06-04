package com.cross.android.crossapplication.model;

import java.math.BigInteger;

public class TransactionStatus {
  private String transactionHash;
  private String sourceAddress;
  private String targetAddress;
  private boolean venefit;
  private boolean status;
  private double amount;
  private Wallet targetWallet;
  private User targetProfile;
  private String date;
  private BigInteger blockNumber;
  private int confirmation;

  public String getTransactionHash() {
    return transactionHash;
  }

  public void setTransactionHash(String transactionHash) {
    this.transactionHash = transactionHash;
  }

  public String getSourceAddress() {
    return sourceAddress;
  }

  public void setSourceAddress(String sourceAddress) {
    this.sourceAddress = sourceAddress;
  }

  public String getTargetAddress() {
    return targetAddress;
  }

  public void setTargetAddress(String targetAddress) {
    this.targetAddress = targetAddress;
  }

  public double getAmount() {
    return amount;
  }

  public void setAmount(double amount) {
    this.amount = amount;
  }

  public BigInteger getBlockNumber() {
    return blockNumber;
  }

  public void setBlockNumber(BigInteger blockNumber) {
    this.blockNumber = blockNumber;
  }

  public int getConfirmation() {
    return confirmation;
  }

  public void setConfirmation(int confirmation) {
    this.confirmation = confirmation;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public boolean getStatus() {
    return status;
  }

  public boolean isVenefit() {
    return venefit;
  }

  public void setVenefit(boolean venefit) {
    this.venefit = venefit;
  }


  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Wallet getTargetWallet() {
    return targetWallet;
  }

  public void setTargetWallet(Wallet targetWallet) {
    this.targetWallet = targetWallet;
  }

  public User getTargetProfile() {
    return targetProfile;
  }

  public void setTargetProfile(User targetProfile) {
    this.targetProfile = targetProfile;
  }
}