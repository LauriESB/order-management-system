package com.lauriesb.order_management.dto;

import com.lauriesb.order_management.entity.SellerEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.BeanUtils;

public class SellerDTO {

  private Long id;

  private String ssn;

  private String name;

  private String address;

  private String city;

  private String state;

  private String areaCode;

  private String phone;

  private String postalCode;

  private int baseSalary;

  private int commissionRate;



  // DTO constructors

  public SellerDTO(SellerEntity seller) {
    BeanUtils.copyProperties(seller, this);
  }

  public SellerDTO() {

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

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

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

}
