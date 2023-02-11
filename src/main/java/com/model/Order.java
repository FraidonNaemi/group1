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
@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class Order implements Serializable {

    private int customerID;
    private int orderID;
    private String orderDate;

    public Order() {
    }

    public Order(int orderID, String orderDate, int customerID) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    public Order(String orderDate, int customerID) {
        this.customerID = customerID;
        this.orderDate = orderDate;
    }

    public void update(int customerID, int orderID, String orderDate) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.orderDate = orderDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getOrderID() {
        return orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public boolean match(int orderID) {
        return this.orderID == orderID;
    }

    public boolean match(Order other) {
        return this.orderID == other.getOrderID();
    }

    @Override
    public String toString() {
        return "OrderID: " + orderID + " | customerID: " + customerID + " | orderDate: " + orderDate;
    }

}
