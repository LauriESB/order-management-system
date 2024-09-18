package com.lauriesb.order_management.dto;

import com.lauriesb.order_management.entity.CustomerEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;

public class CustomerDTO {

  private Long id;

  private String ssn;

  private String name;

  private String address;

  private String city;

  private String state;

  private String areaCode;

  private String phoneNumber;

  private String postalCode;

  private int creditLimit;

  private int availableCredit;

   // connect to entity attributes (database search using dto)
  // convert entity to DTO

  public CustomerDTO(CustomerEntity customer) {
    BeanUtils.copyProperties(customer, this);
  }

  public CustomerDTO() {

  }

  // getters and setters

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

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

}
