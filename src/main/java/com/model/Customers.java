package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author group1
 */
@XmlRootElement(name = "customers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers implements Serializable{
    @XmlElement(name = "customer")
    private List<Customer> customers;
    
    public Customers() {
        customers = new ArrayList();
    }
    
    public void add(Customer customer) {
        this.customers.add(customer);
    }
    
    public void addAll(List<Customer> temp) {
        this.customers.addAll(temp);
    }
    
    public Customer customer(String customerEmail, String customerPassword) {
        return this.customers.stream().filter(customer -> customer.login(customerEmail, customerPassword)).findAny().orElse(null);
    }
    
    public Customer customer(String customerEmail) {
        return this.customers.stream().filter(customer -> customer.match(customerEmail)).findAny().orElse(null);
    }
    
    public Customer customers(int CustomerID) {
        return this.customers.stream().filter(customer -> customer.match(CustomerID)).findAny().orElse(null);
    }
    
    public List<Customer> getCustomers() {
        return customers;
    }
    
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    
    public void remove(Customer other) {
        customers.removeIf(customer -> customer.match(other));
    }
    
    public void show() {
        this.customers.forEach(user -> System.out.println(user));
    }
}