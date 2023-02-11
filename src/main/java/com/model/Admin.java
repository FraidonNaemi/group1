package com.model;

/**
 *
 * @author group1
 */
public class Admin {
    private int adminID;
    private String adminName;
    private String adminEmail;
    private String adminPassword;
    private String adminDOB;
    private String adminPhoneNumber;
    private String adminAddress;

    public Admin(int adminID, String adminName, String adminEmail, String adminPassword, String adminDOB, String adminPhoneNumber, String adminAddress) {
        this.adminID = adminID;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminDOB = adminDOB;
        this.adminPhoneNumber = adminPhoneNumber;
        this.adminAddress = adminAddress;
    }
    
    public boolean login(String adminEmail, String adminPassword) {
        return this.adminEmail.equals(adminEmail) && this.adminPassword.equals(adminPassword);
    }
    
    public boolean match(int adminID) {
        return this.adminID == adminID;
    }
    
    public boolean match(String adminEmail) {
        return this.adminEmail.equals(adminEmail);
    }
    
    public boolean match(Admin other) {
        return this.adminID == other.adminID;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminDOB() {
        return adminDOB;
    }

    public void setDOB(String adminDOB) {
        this.adminDOB = adminDOB;
    }

    public String getAdminPhoneNumber() {
        return adminPhoneNumber;
    }

    public void setPhoneNumber(String adminPhoneNumber) {
        this.adminPhoneNumber = adminPhoneNumber;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    @Override
    public String toString() { 
        return adminID + "\t" + adminName + "\t" + adminEmail + "\t" + adminDOB + "\t" + adminPhoneNumber + "\t" + adminAddress;
    }
}
