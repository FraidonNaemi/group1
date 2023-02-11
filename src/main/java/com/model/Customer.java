package com.model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "customer")
public class Customer implements Serializable {

    private int ID;
    private String customerName;
    private String customerEmail;
    private String customerPassword;
    private String customerDOB;
    private String customerPhoneNumber;
    private String customerAddress;

    public Customer() {
    }

    public void update(int ID, String name, String email, String password, String DOB, String phonenumber, String address) {
        this.ID = ID;
        this.customerName = name;
        this.customerEmail = email;
        this.customerPassword = password;
        this.customerDOB = DOB;
        this.customerPhoneNumber = phonenumber;
        this.customerAddress = address;

    }

    public Customer(String name, String email, String password, String DOB, String phonenumber, String address) {
        this.customerName = name;
        this.customerEmail = email;
        this.customerPassword = password;
        this.customerDOB = DOB;
        this.customerPhoneNumber = phonenumber;
        this.customerAddress = address;

    }

    public Customer(int ID, String name, String email, String password, String DOB, String phonenumber, String address) {
        this.ID = ID;
        this.customerName = name;
        this.customerEmail = email;
        this.customerPassword = password;
        this.customerDOB = DOB;
        this.customerPhoneNumber = phonenumber;
        this.customerAddress = address;

    }

    public void setName(String customerName) {
        this.customerName = customerName;
    }

    public String getName() {
        return customerName;
    }

    public boolean login(String email, String password) {
        return this.customerEmail.equals(email) && this.customerPassword.equals(password);
    }

    public boolean match(int ID) {
        return this.ID == ID;
    }

    public boolean match(String email) {
        return this.customerEmail.equals(email);
    }

    public boolean match(Customer other) {
        return this.ID == other.ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return customerEmail;
    }

    public void setEmail(String email) {
        this.customerEmail = email;
    }

    public String getPassword() {
        return customerPassword;
    }

    public void setPassword(String password) {
        this.customerPassword = password;
    }

    public String getDOB() {
        return customerDOB;
    }

    public void setDOB(String DOB) {
        this.customerDOB = DOB;
    }

    public String getPhonenumber() {
        return customerPhoneNumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.customerPhoneNumber = phonenumber;
    }

    public String getAddress() {
        return customerAddress;
    }

    public void setAddress(String address) {
        this.customerAddress = address;
    }

    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", name=" + customerName + ", email=" + customerEmail + ", password=" + customerPassword + ", DOB=" + customerDOB + ", phonenumber=" + customerPhoneNumber + ", address=" + customerAddress + '}';
    }

}
