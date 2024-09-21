package com.lauriesb.order_management.entity;

import com.lauriesb.order_management.dto.CustomerDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Objects;

@Entity

@Table(name = "Customer")
public class CustomerEntity extends PersonEntity {

  @Column(nullable = false)
  private int creditLimit;

  @Column(nullable = false)
  private int availableCredit;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private ArrayList<OrdersEntity> customerOrders;

  // entity constructors

  public CustomerEntity(String name, String ssn, int creditLimit) {
    super(name, ssn);
    this.creditLimit = creditLimit;
    customerOrders = new ArrayList<>();
  }

  public CustomerEntity(CustomerDTO customer) {
    BeanUtils.copyProperties(customer, this);
  }

  public CustomerEntity() {

  }

  //getters and setters

  public int getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(int creditLimit) {
    this.creditLimit = creditLimit;
  }

  public int getAvailableCredit() {
    return availableCredit;
  }

  public void setAvailableCredit(int availableCredit) {
    this.availableCredit = availableCredit;
  }

  public ArrayList<OrdersEntity> getCustomerOrders() {
    return customerOrders;
  }

  public void addCustomerOrders(OrdersEntity order) {
    this.customerOrders.add(order);
    order.setCustomer(this);
    this.availableCredit -= order.getOrderValue();
  }

  public void removeCustomerOrders(OrdersEntity order) {
    this.customerOrders.remove(order);
    order.setCustomer(null);
    this.availableCredit += order.getOrderValue();
  }

  // equals and hashcode methods

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CustomerEntity that = (CustomerEntity) o;
    return Objects.equals(super.getId(), that.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(super.getId());
  }

}
