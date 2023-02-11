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
@XmlRootElement(name = "orders")
@XmlAccessorType(XmlAccessType.FIELD)
public class Orders implements Serializable {

    @XmlElement(name = "order")
    private List<Order> orders = new ArrayList<>();

    public Orders() {
    }

    public void add(Order order) {
        this.orders.add(order);
    }

    public void addAll(List<Order> temp) {
        this.orders.addAll(temp);
    }

    public Order order(int orderID) {
        return this.orders.stream().filter(o -> o.match(orderID)).findAny().orElse(null);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setAdmins(List<Order> order) {
        this.orders = orders;
    }

    public void remove(Order other) {
        orders.removeIf(o -> o.match(other));
    }

    public void show() {
        this.orders.forEach(System.out::println);
    }

}
