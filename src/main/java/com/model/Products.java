package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products implements Serializable {
//declare the fields

    @XmlElement(name = "product")
    private List<Product> products;
//constructor to initialize list of products

    public Products() {
        products = new ArrayList<>();
    }
// add one product

    public void add(Product product) {
        this.products.add(product);
    }
//add list of products

    public void addAll(List<Product> temp) {
        this.products.addAll(temp);
    }
// search for product by id 

    public Product product(int productID) {
        return products.stream().filter(p -> p.match(productID)).findAny().orElse(null);
    }
    // search for product by name 

    public Product product(String productName) {
        return products.stream().filter(p -> p.match(productName)).findAny().orElse(null);
    }
//get list of products

    public List<Product> getProducts() {
        return products;
    }
// set value for the products

    public void setProducts(List<Product> products) {
        this.products = products;
    }
// remove product if exist

    public void remove(Product other) {
        products.removeIf(product -> product.match(other));
    }
// show products

    public void show() {
        this.products.forEach(product -> System.out.println(product));
    }
}
