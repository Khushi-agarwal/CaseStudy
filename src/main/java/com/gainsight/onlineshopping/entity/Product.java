package com.gainsight.onlineshopping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @Column(name="prod_Id")
    private int productId;

    @Column(name="prod_Name")
    private String productName;
    @Column(name="prod_Price")
    private double productPrice;
    @Column(name="prod_Desc")
    private String productDesc;
    @Column(name="prod_Category")
    private String productCategory;


    @Column(name="Ratings")
    private int productRating;

    public Product(){}

    public Product(int productId, String productName, double productPrice, String productDesc, String productCategory,int productRating) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productCategory = productCategory;
        this.productRating=productRating;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
    public int getProductRating() {
        return productRating;
    }

    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }

}
