/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236369
 */
//xml annotations for the transformer
@XmlRootElement(name = "orderProduct")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderProduct implements Serializable {

    //private List<Product> products = new ArrayList<>();
    private int orderID;
    private int productID;
    private int quantity;

    //default constructo
    public OrderProduct() {
    }

    //constructor to initilize the fields
    public OrderProduct(int orderID, int productID, int quantity) {
        // this.products = products;
        this.orderID = orderID;
        this.quantity = quantity;
        this.productID = productID;
    }

    //update the quantity
    public void update(int quantity) {
        this.quantity = quantity;
    }

    //return the orderID
    public int getOrderID() {
        return orderID;
    }

    //return productID
    public int getProductID() {
        return productID;
    }

    //return the quantity of that product
    public int getQuantity() {
        return quantity;
    }

    //change the order ID
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    //change the product ID
    public void setProductID(int productID) {
        this.productID = productID;
    }

    //change the quantity of the product
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    //check if the product is the same in that specific order
    public boolean match(int orderID, int productID) {
        return (this.orderID == orderID && this.productID == productID);
    }

    //toString to print the fields
    @Override
    public String toString() {
        return "OrderProduct{" + "orderID=" + orderID + ", productID=" + productID + ", quantity=" + quantity + '}';
    }

}
