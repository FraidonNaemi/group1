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
//annotations for the xml transformer
@XmlRootElement(name = "orderProducts")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderProducts implements Serializable {

    //annotation for the transformer
    @XmlElement(name = "orderProduct")
    private List<OrderProduct> orderProducts = new ArrayList<>();

    //default constructor
    public OrderProducts() {
    }

    //add one orderProduct to the list of orderProduct
    public void add(OrderProduct orderProduct) {
        this.orderProducts.add(orderProduct);
    }

    //add list of orderProduct into the list of OrderProduct
    public void addAll(List<OrderProduct> temp) {
        this.orderProducts.addAll(temp);
    }

    //return the list of orderProduct(the field)
    public List<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    //match orderProduct by orderID and productID
    public boolean isProductExsist(int orderID, int productID) {
        return this.orderProducts.stream().anyMatch(op -> ((op.getOrderID() == orderID) && (op.getProductID() == productID)));
    }

    //chnage or update the list
    

    public void setOrderProducts(List<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    //search for an OrderProduct into the list by an orderID and productID and return the orderProduct if found
    public OrderProduct orderProduct(int orderID, int productID) {
        return orderProducts.stream().filter(o -> o.match(orderID, productID)).findAny().orElse(null);
    }

    //lookup for a product in an order and delete it if found
    public void remove(int orderID, int productID) {
        orderProducts.removeIf(o -> o.match(orderID, productID));
    }

    //print the list of orderProducts
    public void show() {
        this.orderProducts.forEach(System.out::println);
    }

    //toString to show the fields
    @Override
    public String toString() {
        return "OrderProducts{" + "orderProducts=" + orderProducts + '}';
    }

}
