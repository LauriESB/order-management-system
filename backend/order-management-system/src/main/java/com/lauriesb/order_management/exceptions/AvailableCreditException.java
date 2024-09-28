package com.lauriesb.order_management.exceptions;

public class AvailableCreditException extends RuntimeException{
  private final Double avlbCredit;

  public AvailableCreditException(String message, Double avlbCredit) {
    super(message);
    this.avlbCredit = avlbCredit;
  }

  public Double getAvlbCredit() {
    return this.avlbCredit;
  }

}
