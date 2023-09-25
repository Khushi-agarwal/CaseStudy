package com.gainsight.onlineshopping.entity;

import jakarta.persistence.*;

@Entity
@Table(name="user_cart")
public class UserCart {

    @Id
    @Column(name="prod_Id")
    private int productId;
    @Column(name="prod_Quantity")
    private int productQuantity;

    @OneToOne
    @JoinColumn(name="prod_Id")
    private Product product;
    UserCart(){}

    public UserCart(int productId, int productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}
