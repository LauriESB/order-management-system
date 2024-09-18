package com.lauriesb.order_management.dto;

import com.lauriesb.order_management.entity.OrdersEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;

public class OrdersDTO {

  private Long id;

  private String issueDate;

  private int orderValue;

  private String customerSSN;

  private String sellerSSN;

  // constructors

  public OrdersDTO(OrdersEntity orders) {
    BeanUtils.copyProperties(orders, this);
  }

  public OrdersDTO() {

  }

  // getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(String issueDate) {
    this.issueDate = issueDate;
  }

  public int getOrderValue() {
    return orderValue;
  }

  public void setOrderValue(int orderValue) {
    this.orderValue = orderValue;
  }

  public String getCustomerSSN() {
    return customerSSN;
  }

  public void setCustomerSSN(String customerSSN) {
    this.customerSSN = customerSSN;
  }

  public String getSellerSSN() {
    return sellerSSN;
  }

  public void setSellerSSN(String sellerSSN) {
    this.sellerSSN = sellerSSN;
  }

}
