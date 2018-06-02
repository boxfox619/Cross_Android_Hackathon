package com.cross.android.crossapplication.model;

import java.math.BigInteger;

public class TransactionStatus {
  private String transactionHash;
  private String sourceAddress;
  private String targetAddress;
  private boolean status;
  private double amount;
  private BigInteger blockNumber;
  private BigInteger confirmation;
  private String email;
  private String date;

  public TransactionStatus(String transactionHash, boolean status, double amount, BigInteger blockNumber, BigInteger confirmation, String email, String date) {
    this.transactionHash = transactionHash;
    this.status = status;
    this.amount = amount;
    this.blockNumber = blockNumber;
    this.confirmation = confirmation;
    this.email = email;
    this.date = date;
  }

  public boolean isStatus() {
    return status;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

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

  public BigInteger getConfirmation() {
    return confirmation;
  }

  public void setConfirmation(BigInteger confirmation) {
    this.confirmation = confirmation;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public boolean getStatus() {
    return status;
  }
}
