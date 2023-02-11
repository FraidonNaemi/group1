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
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    private int customerID;
    private int orderID;
    private String orderDate;

    //default constructor
    public Order() {
    }
    //constructor to initilize the fields

    public Order(int orderID, String orderDate, int customerID) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderDate = orderDate;
    }
    //constructor to initilize the fields

    public Order(String orderDate, int customerID) {
        this.customerID = customerID;
        this.orderDate = orderDate;
    }

    //update
    public void update(int customerID, int orderID, String orderDate) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    //return the customerID
    public int getCustomerID() {
        return customerID;
    }

    //return the orderID
    public int getOrderID() {
        return orderID;
    }

    //return the orderDate
    public String getOrderDate() {
        return orderDate;
    }

    //change the customerID
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    //change the orderID
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    //change the orderDate
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    //match this order with other order by ID
    public boolean match(int orderID) {
        return this.orderID == orderID;
    }

    //match this order with another order
    public boolean match(Order other) {
        return this.orderID == other.getOrderID();
    }

    //toString to show print the fields
    @Override
    public String toString() {
        return "OrderID: " + orderID + " | customerID: " + customerID + " | orderDate: " + orderDate;
    }

}
