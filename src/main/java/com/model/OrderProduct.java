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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 236369
 */
@XmlRootElement(name = "orderProduct")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderProduct implements Serializable {

    //private List<Product> products = new ArrayList<>();
    private int orderID;
    private int productID;
   private int quantity;

    public OrderProduct() {
    }

    public OrderProduct(int orderID, int productID, int quantity) {
       // this.products = products;
        this.orderID = orderID;
        this.quantity = quantity;
        this.productID = productID;
    }

    public void update( int quantity) {
        this.quantity = quantity;
    }

   
//    public int getQuantity() {
//        return quantity;
//    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public int getOrderID() {
        return orderID;
    }

    public int getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public boolean match(int orderID, int productID ) {
        return (this.orderID==orderID && this.productID == productID );
    }

   

//
//    public List<Product> addProduct(int productID) {
//        List<Product> temp = new ArrayList<>();
//        Products products = new Products();
//        this.products.add(products.product(productID));
//        return temp;
//    }
//
//    public void addProduct(Product product) {
//        this.products.add(product);
//    }
//
//    public void addProducts(List<Product> products) {
//        this.products.addAll(products);
//    }
//
//    public void deleteProductByID(int productID) {
//        Products products = new Products();
//        this.products.remove(products.product(productID));
//    }
//
//    public void deleteAllProducts() {
//        List<Product> temp = products;
//        products.removeAll(temp);
//    }
//
////    public boolean match(int orderProductID) {
////        return this.orderProductID == orderProductID;
////    }
////
////    public boolean match(OrderProduct other) {
////        return this.orderProductID == other.getOrderProductID();
////    }
//    public void show() {
//        this.products.forEach(p -> p.toString());
//    }

    @Override
    public String toString() {
        return "OrderProduct{" + "orderID=" + orderID + ", productID=" + productID + ", quantity=" + quantity + '}';
    }

    
}
