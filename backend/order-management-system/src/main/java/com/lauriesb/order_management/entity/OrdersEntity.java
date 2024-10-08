package com.lauriesb.order_management.entity;

import com.lauriesb.order_management.dto.OrdersDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity

@Table(name ="Orders")
public class OrdersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String issueDate;

  @Column(nullable = false)
  private double orderValue;

  @ManyToOne
  @JoinColumn(name = "customerID")
  private CustomerEntity customer;

  @ManyToOne
  @JoinColumn(name = "sellerID")
  private SellerEntity seller;

  // entity constructors

  public OrdersEntity(Long id) {
    this.id = id;
  }

  public OrdersEntity(OrdersDTO orders) {
    BeanUtils.copyProperties(orders, this);
  }

  public OrdersEntity() {

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

  public CustomerEntity getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerEntity customer) {
    this.customer = customer;
  }

  public SellerEntity getSeller() {
    return seller;
  }

  public void setSeller(SellerEntity seller) {
    this.seller = seller;
  }

  // equals and hashcode methods

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrdersEntity that = (OrdersEntity) o;
    return Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

}
