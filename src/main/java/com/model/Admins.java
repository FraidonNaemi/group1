package com.model;

import java.io.Serializable;
import java.util.*;
import javax.xml.bind.annotation.*;

/**
 *
 * @author group1
 */
@XmlRootElement(name = "admins")
@XmlAccessorType(XmlAccessType.FIELD)
public class Admins implements Serializable{
    @XmlElement(name = "admin")
    private List<Admin> admins;
    
    public Admins() {
        admins = new ArrayList();
    }
    
    public void add(Admin admin){
        this.admins.add(admin);
    }
    
    public Admin admin(String adminEmail, String adminPassword) {
        return this.admins.stream().filter(admin -> admin.login(adminEmail, adminPassword)).findAny().orElse(null);
    }
    
    public Admin admin (String adminEmail) {
        return this.admins.stream().filter(admin -> admin.match(adminEmail)).findAny().orElse(null);
    }
    
    public Admin admin (int adminID) {
        return this.admins.stream().filter(admin -> admin.match(adminID)).findAny().orElse(null);
    }
    
    public void remove(Admin other){
        admins.removeIf(admin -> admin.match(other));
    }
    
    public void show(){
        this.admins.forEach(admin -> System.out.println(admin));
    } 
}