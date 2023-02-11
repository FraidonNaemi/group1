/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236369
 */
//xml annotations for the transformer
@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders implements Serializable {

    //xml annotations for the transformer
    @XmlElement(name = "order")
    private List<Order> orders = new ArrayList<>();

    //default constructor
    public Orders() {
    }

    //adding order to the ist of order
    public void add(Order order) {
        this.orders.add(order);
    }

    //take list of order and add it to the orders list
    public void addAll(List<Order> temp) {
        this.orders.addAll(temp);
    }

    //match order by ID and return it if found
    public Order order(int orderID) {
        return this.orders.stream().filter(o -> o.match(orderID)).findAny().orElse(null);
    }

    //match order by ID and 
    public boolean isOrder(int orderID) {
        return this.orders.stream().anyMatch(order -> (order.getOrderID() == orderID));
    }

    // return the orders list
    public List<Order> getOrders() {
        return orders;
    }

    //chnage or update the list of orders
    public void setOrders(List<Order> order) {
        this.orders = orders;
    }

    //remove one order if found
    public void remove(Order other) {
        orders.removeIf(o -> o.match(other));
    }

    //show all the orders
    public void show() {
        this.orders.forEach(System.out::println);
    }

}
