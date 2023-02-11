package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "admin")
@XmlAccessorType(XmlAccessType.FIELD)
public class Admin implements Serializable {

    private int ID;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private String adminDOB;
    private String adminPhonenumber;
    private String adminAddress;

    public Admin() {
    }

    public void update(int ID, String name, String email, String password, String DOB, String phonenumber, String address) {
        this.ID = ID;
        this.adminName = name;
        this.adminEmail = email;
        this.adminPassword = password;
        this.adminDOB = DOB;
        this.adminPhonenumber = phonenumber;
        this.adminAddress = address;

    }

    public Admin(String name, String email, String password, String DOB, String phonenumber, String address) {
        this.adminName = name;
        this.adminEmail = email;
        this.adminPassword = password;
        this.adminDOB = DOB;
        this.adminPhonenumber = phonenumber;
        this.adminAddress = address;

    }

    public Admin(int ID, String name, String email, String password, String DOB, String phonenumber, String address) {
        this.ID = ID;
        this.adminName = name;
        this.adminEmail = email;
        this.adminPassword = password;
        this.adminDOB = DOB;
        this.adminPhonenumber = phonenumber;
        this.adminAddress = address;

    }

    public void setName(String adminName) {
        this.adminName = adminName;
    }

    public String getName() {
        return this.adminName;
    }

    public boolean login(String email, String password) {
        return this.adminEmail.equals(email) && this.adminPassword.equals(password);
    }

    public boolean match(int ID) {
        return this.ID == ID;
    }

    public boolean match(String email) {
        return this.adminEmail.equals(email);
    }

    public boolean match(Admin other) {
        return this.ID == other.ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return adminEmail;
    }

    public void setEmail(String email) {
        this.adminEmail = email;
    }

    public String getPassword() {
        return adminPassword;
    }

    public void setPassword(String password) {
        this.adminPassword = password;
    }

    public String getDOB() {
        return adminDOB;
    }

    public void setDOB(String DOB) {
        this.adminDOB = DOB;
    }

    public String getPhonenumber() {
        return adminPhonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.adminPhonenumber = phonenumber;
    }

    public String getAddress() {
        return adminAddress;
    }

    public void setAddress(String address) {
        this.adminAddress = address;
    }

    @Override
    public String toString() {
        return "Admin{" + "ID=" + ID + ", name=" + adminName + ", email=" + adminEmail + ", password=" + adminPassword + ", DOB=" + adminDOB + ", phonenumber=" + adminPhonenumber + ", address=" + adminAddress + '}';
    }

}
