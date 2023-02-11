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
@XmlRootElement(name = "orderProducts")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderProducts implements Serializable {

    @XmlElement(name = "OrderProduct")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    public OrderProducts() {
    }

    public void add(OrderProduct orderProduct) {
        this.orderProducts.add(orderProduct);
    }

    public void addAll(List<OrderProduct> temp) {
        this.orderProducts.addAll(temp);
    }

//    public OrderProduct OrderProduct(int orderProductID) {
//        return this.orderProducts.stream().filter(obj -> obj.match(orderProductID)).findAny().orElse(null);
//    }

    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

//    public void remove(OrderProduct other) {
//        orderProducts.removeIf(o -> o.match(other));
//    }
    
    public OrderProduct orderProduct(int orderID ,int productID) {
    return orderProducts.stream().filter(o -> o.match(orderID,productID)).findAny().orElse(null);
    }
    
    
      public void remove(int orderID ,int productID) {
        orderProducts.removeIf(o -> o.match(orderID,productID));
    }

    public void show() {
        this.orderProducts.forEach(System.out::println);
    }

}
