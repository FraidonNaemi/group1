package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {
//declare the fields

    private int productID;
    private String productImage;
    private String productName;
    private double productPrice;
    private String productCategory;
    private String productDescription;
    private int productStock;
//empty constructor

    public Product() {
    }

    public Product(String productImage, String productName, double productPrice, String productCtegory, String productDescription, int productStock) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock = productStock;
    }
//constructor create product

    public Product(int productID, String productImage, String productName, double productPrice, String productCategory, String productDescription, int productStock) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock = productStock;
    }
// update product

    public void update(int productID, String productImage, String productName, double productPrice, String productCategory, String productDescription, int productStock) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock = productStock;
    }
//decrease the stock amount

    public void decProductStock(int qunatity) {
        this.productStock = this.productStock - qunatity;
    }
//increase the stock amount

    public void incProductStock(int qunatity) {
        this.productStock = this.productStock + qunatity;
    }
//match product by id

    public boolean match(int productID) {
        return this.productID == productID;
    }
//match product by the name

    public boolean match(String productName) {
        return this.productName == productName;
    }
//match product by the other product

    public boolean match(Product other) {
        return this.productID == other.productID;
    }
// getter and setters

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductID() {
        return productID;
    }

    public String getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public String getProductDescription() {
        return productDescription;
    }
//toString 

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productImage=" + productImage + ", productName=" + productName + ", productPrice=" + productPrice + ", productCategory=" + productCategory + ", productDescription=" + productDescription + ", productStock=" + productStock + '}';
    }

}
