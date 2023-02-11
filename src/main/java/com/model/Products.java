package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class Products implements Serializable {

    @XmlElement(name = "product")
    private List<Product> products;

    public Products() {
        products = new ArrayList<>();
    }

    public void add(Product product) {
        this.products.add(product);
    }

    public void addAll(List<Product> temp) {
        this.products.addAll(temp);
    }

    public Product product(int productID) {
    return products.stream().filter(p -> p.match(productID)).findAny().orElse(null);
    }
    
     public Product product(String productName) {
       return products.stream().filter(p -> p.match(productName)).findAny().orElse(null);
      }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void remove(Product other) {
        products.removeIf(product -> product.match(other));
    }

    public void show() {
        this.products.forEach(product -> System.out.println(product));
    }
}
