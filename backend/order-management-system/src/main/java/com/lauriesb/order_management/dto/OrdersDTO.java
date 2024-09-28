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

  private double orderValue;

  private Long sellerId;

  private Long customerId;

  // constructors

  public OrdersDTO(OrdersEntity orders) {
    BeanUtils.copyProperties(orders, this);
    if (orders.getSeller() != null) {
      this.sellerId = orders.getSeller().getId();
    }

    if (orders.getCustomer() != null) {
      this.customerId = orders.getCustomer().getId();
    }

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

  public double getOrderValue() {
    return orderValue;
  }

  public void setOrderValue(double orderValue) {
    this.orderValue = orderValue;
  }


  public Long getSellerId() {
    return sellerId;
  }

  public void setSellerId(Long sellerId) {
    this.sellerId = sellerId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

}
