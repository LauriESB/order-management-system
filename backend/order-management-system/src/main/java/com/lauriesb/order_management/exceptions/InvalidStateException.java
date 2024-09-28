package com.lauriesb.order_management.exceptions;

public class InvalidStateException extends IllegalArgumentException {
  private final String state;

  public InvalidStateException(String message, String state) {
    super(message);
    this.state = state;
  }

  public String getState() {
    return state;
  }
}
