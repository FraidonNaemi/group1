package com.model;
import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;
/**
 *
 * @author group1
 */
@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable{
    private int customerID;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerDOB;
    private String customerPhoneNumber;
    private String customerAddress;
    public Customer() { }
    public Customer(int customerID, String customerName, String customerEmail, String customerPassword, String customerDOB, String customerPhoneNumber, String customerAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerDOB = customerDOB;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
    }
    public Customer(String customerName, String customerEmail, String customerPassword, String customerDOB, String customerPhoneNumber, String customerAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerDOB = customerDOB;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
    }
    public void update(int customerID, String customerName, String customerEmail, String customerPassword, String customerDOB, String customerPhoneNumber, String customerAddress) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerDOB = customerDOB;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerAddress = customerAddress;
    }
    public boolean login(String customerEmail, String customerPassword) {
        return this.customerEmail.equals(customerEmail) && this.customerPassword.equals(customerPassword);
    }
    public boolean match(int customerID) {
        return this.customerID == customerID;
    }
    public boolean match(String customerEmail) {
        return this.customerEmail.equals(customerEmail);
    }
    public boolean match(Customer other) {
        return this.customerID == other.customerID;
    }
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }
    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    public String getCustomerDOB() {
        return customerDOB;
    }
    public void setCustomerDOB(String customerDOB) {
        this.customerDOB = customerDOB;
    }
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }
    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
    public String getCustomerAddress() {
        return customerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    @Override
    public String toString() {
        return customerID + "\t" + customerName + "\t" + customerEmail + "\t" + customerDOB + "\t" + customerPhoneNumber + "\t" + customerAddress;
    }
}