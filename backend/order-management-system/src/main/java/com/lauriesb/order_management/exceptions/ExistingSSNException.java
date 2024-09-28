package com.lauriesb.order_management.exceptions;

public class ExistingSSNException extends IllegalArgumentException{
  private final String ssn;

  public ExistingSSNException(String message, String ssn) {
    super(message);
    this.ssn = ssn;
  }

  public String getSsn() {
    return this.ssn;
  }

}
