package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

    private int productID;
    private String productImage;
    private String productName;
    private double productPrice;
    private String productCategory;
    private String productDescription;
    private int productStock;

    public Product() {
    }

    public Product(String productImage, String productName, double productPrice, String productCtegory, String productDescription,int productStock) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock=productStock;

    }

    public Product(int productID, String productImage, String productName, double productPrice, String productCategory, String productDescription,int productStock) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock=productStock;
    }

    public void update(int productID, String productImage, String productName, double productPrice, String productCategory, String productDescription,int productStock) {
        this.productID = productID;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
        this.productDescription = productDescription;
        this.productStock=productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public int getProductStock() {
        return productStock;
    }

    public boolean match(int productID) {
        return this.productID == productID;
    }

    public boolean match(String productName) {
        return this.productName == productName;
    }

    public boolean match(Product other) {
        return this.productID == other.productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productImage=" + productImage + ", productName=" + productName + ", productPrice=" + productPrice + ", productCategory=" + productCategory + ", productDescription=" + productDescription + ", productStock=" + productStock + '}';
    }

    

   

}
