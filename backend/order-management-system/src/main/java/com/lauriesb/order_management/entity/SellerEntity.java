package com.lauriesb.order_management.entity;

import com.lauriesb.order_management.dto.SellerDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

@Table(name = "Seller")
public class SellerEntity extends PersonEntity {

  @Column(nullable = false)
  private double baseSalary;

  @Column(nullable = false)
  private double commissionRate;

  @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
  private List<OrdersEntity> sellerOrders;

  // entity constructors

  public SellerEntity(String name, String ssn, double baseSalary) {
    super(name, ssn);
    this.baseSalary = baseSalary;
  }

  public SellerEntity(SellerDTO seller) {
    BeanUtils.copyProperties(seller, this);
  }

  public SellerEntity() {

  }

  //getters and setters

  public double getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(double baseSalary) {
    this.baseSalary = baseSalary;
  }

  public double getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(double commissionRate) {
    this.commissionRate = commissionRate;
  }

  public void addSellerOrder(OrdersEntity order) {
    order.setSeller(this);
    this.sellerOrders.add(order);
  }

  public void removeSellerOrder(OrdersEntity order) {
    order.setSeller(null);
    this.sellerOrders.remove(order);
  }

  // equals and hashcode methods

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    SellerEntity that = (SellerEntity) o;
    return Objects.equals(super.getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.getId());
  }

}
