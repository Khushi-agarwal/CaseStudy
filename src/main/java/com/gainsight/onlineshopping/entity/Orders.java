package com.gainsight.onlineshopping.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="Orders")
public class Orders {

//    @Id
//    @Column(name="orderid")
//    private int orderId;
   @Id
    @Column(name="Name")
    private String name;
    @Column
    private long mobile;
    @Column
    private String address;
    @Column(name="paymentmode")
    private String paymentMode;


    @Column(name="total")
    private double totalAmount;
    public Orders(){}

    public Orders( String name, long mobile, String address, String paymentMode,double totalAmount) {
//        this.orderId = orderId;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.paymentMode = paymentMode;
        this.totalAmount = totalAmount;
    }

//    public int getOrderId() {
//        return orderId;
//    }
//
//    public void setOrderId(int orderId) {
//        this.orderId = orderId;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
