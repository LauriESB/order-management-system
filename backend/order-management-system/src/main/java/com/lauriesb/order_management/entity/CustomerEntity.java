package com.lauriesb.order_management.entity;

import com.lauriesb.order_management.dto.CustomerDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity

@Table(name = "Customer")
public class CustomerEntity extends PersonEntity {

  @Column(nullable = false)
  private Double creditLimit;

  @Column(nullable = false)
  private Double availableCredit;

  @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
  private List<OrdersEntity> customerOrders;


  // entity constructors

  public CustomerEntity(String name, String ssn, Double creditLimit) {
    super(name, ssn);
    this.creditLimit = creditLimit;
    if (this.availableCredit == null) {
      this.availableCredit = creditLimit; // availableCredit inicia com creditLimit se não definido
    }
  }

  public CustomerEntity(CustomerDTO customer) {
    BeanUtils.copyProperties(customer, this);
    if (this.availableCredit == null) {
      this.availableCredit = creditLimit; // availableCredit inicia com creditLimit se não definido
    }
  }

  public CustomerEntity() {

  }

  //getters and setters

  public Double getCreditLimit() {
    return creditLimit;
  }

  public void setCreditLimit(Double creditLimit) {
    this.creditLimit = creditLimit;
  }

  public Double getAvailableCredit() {
    return availableCredit;
  }

  public void setAvailableCredit(Double availableCredit) {

      this.availableCredit = availableCredit;


  }

  public List<OrdersEntity> getCustomerOrders() {
    return customerOrders;
  }

  public void addCustomerOrders(OrdersEntity order) {
    if(this.availableCredit - order.getOrderValue() < 0) {
      System.out.println("Insufficient credit");
    } else {

      order.setCustomer(this);

      this.availableCredit -= order.getOrderValue();
      this.customerOrders.add(order);
    }

  }

  public void removeCustomerOrders(OrdersEntity order) {
    order.setCustomer(null);
    this.customerOrders.remove(order);
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
