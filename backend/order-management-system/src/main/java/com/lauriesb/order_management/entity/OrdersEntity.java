package com.lauriesb.order_management.entity;

import jakarta.persistence.*;

@Entity

@Table(name ="Orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String issueDate;

    @Column(nullable = false)
    private int orderValue;

    @Column(nullable = false)
    private String customerSSN;

    @Column(nullable = false)
    private String sellerSSN;

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
