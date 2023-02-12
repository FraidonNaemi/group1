package com.model.dao;

import com.model.Customer;
import com.model.Customers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CustomerSqlDAO {

    private Statement st;
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.customers SET customerName=?, customerPassword=?, customerDOB=?, customerPhoneNumber=?, customerAddress=? WHERE customerID=?";
    private PreparedStatement deleteSt;
    private String deleteQuery = "DELETE FROM store.customers WHERE customerEmail=?";

    public CustomerSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.updateSt = connection.prepareStatement(updateQuery);
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    // Create Customer Query
    public void create(String customerName, String customerEmail, String customerPassword, String customerDOB, String customerPhoneNumber, String customerAddress) throws SQLException {
        String columns = "INSERT INTO store.customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress)";
        String values = "VALUES('" + customerName + "','" + customerEmail + "','" + customerPassword + "','" + customerDOB + "','" + customerPhoneNumber + "','" + customerAddress + "')";
        
        st.executeUpdate(columns + values);
    }
    // Create Customer Query
    public void create(String customerEmail) throws SQLException {
        String columns = "INSERT INTO store.customers(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress)";
        String values = "VALUES('Example Example','" + customerEmail + "','Helloexample123','2000-02-03', '0450179669', '51 George St, Sydney NSW 2002')";
        // String values = "VALUES('Test Test','" + customerEmail + "','Hellotest123','2000-02-03', '0450179669', '51 George St, Sydney NSW 2002')";
        st.executeUpdate(columns + values);
    }
    
    // Read Customer Query - Read One
    public Customer getCustomer(int customerID) throws SQLException {
        String query = "SELECT * FROM store.customers WHERE customerID=" + customerID;
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (customerID == currentID) {
                String customerName = rs.getString(2);
                String customerEmail = rs.getString(3);
                String customerPassword = rs.getString(4);
                String customerDOB = rs.getString(5);
                String customerPhoneNumber = rs.getString(6);
                String customerAddress = rs.getString(7);
                
                return new Customer(customerID, customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
            }
        }
        
        return null;
    }

    // Read Customer Query - Read One
    public Customer getCustomer(String customer_email) throws SQLException {
        String query = "SELECT * FROM store.customers WHERE customerEmail='" + customer_email + "'";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String currentEmail = rs.getString(3);

            if (customer_email.equals(currentEmail)) {
                int customerID = Integer.parseInt(rs.getString(1));
                String customerName = rs.getString(2);
                String customerEmail = rs.getString(3);
                String customerPassword = rs.getString(4);
                String customerDOB = rs.getString(5);
                String customerPhoneNumber = rs.getString(6);
                String customerAddress = rs.getString(7);
                
                return new Customer(customerID, customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
            }
        }
        
        return null;
    }
    
    // Read Customer Query - Read One by Name
    public Customer login(String customer_email, String customer_password) throws SQLException {
        String query = "SELECT * FROM store.customers WHERE customerEmail='" + customer_email+ "' AND customerPassword='" + customer_password + "'";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String currentEmail = rs.getString(3);
            String currentPassword = rs.getString(4);

            if (customer_email.equals(currentEmail) && customer_password.equals(currentPassword)) {
                int customerID = Integer.parseInt(rs.getString(1));
                String customerName = rs.getString(2);
                String customerEmail = rs.getString(3);
                String customerPassword = rs.getString(4);
                String customerDOB = rs.getString(5);
                String customerPhoneNumber = rs.getString(6);
                String customerAddress = rs.getString(7);
                
                return new Customer(customerID, customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
            }
        }
        
        return null;
    }

    // Read Customers Query - Read All
    public List<Customer> getCustomers() throws SQLException {
        String query = "SELECT * FROM store.customers";
        ResultSet rs = st.executeQuery(query);
        List<Customer> temp = new ArrayList<>();

        while (rs.next()) {
            int customerID = Integer.parseInt(rs.getString(1));
            String customerName = rs.getString(2);
            String customerEmail = rs.getString(3);
            String customerPassword = rs.getString(4);
            String customerDOB = rs.getString(5);
            String customerPhoneNumber = rs.getString(6);
            String customerAddress = rs.getString(7);
            
            temp.add(new Customer(customerID, customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress));
        }
        
        return temp;
    }
   
    // Update Customer Query (Name, Password) by ID
    public void update(String customerName, String customerPassword, String customerDOB, String customerPhoneNumber, String customerAddress, int customerID) throws SQLException {
        updateSt.setString(1, customerName);
        updateSt.setString(2, customerPassword);
        updateSt.setString(3, customerDOB);
        updateSt.setString(4, customerPhoneNumber);
        updateSt.setString(5, customerAddress);
        updateSt.setString(6, Integer.toString(customerID));
        
        int row = updateSt.executeUpdate();
        
        System.out.println("Row " + row + " has been successflly updated");
    }

    // Delete Customer Query - by email
    public void delete(String customerEmail) throws SQLException {
        deleteSt.setString(1, customerEmail);
        
        int row = deleteSt.executeUpdate();
        
        System.out.println("Row " + row + " has been successflly deleted");
    }
}