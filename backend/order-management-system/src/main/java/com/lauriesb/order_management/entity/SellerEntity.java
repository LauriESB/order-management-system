package com.lauriesb.order_management.entity;

import com.lauriesb.order_management.dto.SellerDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Objects;

@Entity

@Table(name = "Seller")
public class SellerEntity extends PersonEntity {

  @Column(nullable = false)
  private int baseSalary;

  @Column(nullable = false)
  private int commissionRate;

  @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
  private ArrayList<OrdersEntity> orders;

  // entity constructors

  public SellerEntity(String name, String ssn) {
    super(name, ssn);
  }

  public SellerEntity(SellerDTO seller) {
    BeanUtils.copyProperties(seller, this);
  }

  public SellerEntity() {

  }

  //getters and setters

  public int getBaseSalary() {
    return baseSalary;
  }

  public void setBaseSalary(int baseSalary) {
    this.baseSalary = baseSalary;
  }

  public int getCommissionRate() {
    return commissionRate;
  }

  public void setCommissionRate(int commissionRate) {
    this.commissionRate = commissionRate;
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
