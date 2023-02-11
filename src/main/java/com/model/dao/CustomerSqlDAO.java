/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 236367
 */
public class CustomerSqlDAO {

    private Statement st;
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.customers SET CUSTOMERNAME=?,CUSTOMEREMAIL=?,CUSTOMERPASSWORD=?,CUSTOMERDOB=?,CUSTOMERPHONENUMBER=?,CUSTOMERADDRESS=? WHERE CUSTOMERID=?";
    private PreparedStatement deleteSt;
    private String deleteQuery = "DELETE FROM store.customers WHERE customerID=?";

    public CustomerSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.updateSt = connection.prepareStatement(updateQuery);
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    // Create Query
    public void create(String name, String email, String password, String DOB, String phonenumber, String address) throws SQLException {
        String columns = "INSERT INTO store.customers(customerName,customerEmail,customerPassword,customerDOB,customerPhoneNumber,customerAddress)";
        String values = "VALUES('" + name + "', '" + email + "','" + password + "','" + DOB + "','" + phonenumber + "','" + address + "')";
        System.out.println(values);
        st.executeUpdate(columns + values);
    }
    


    public void update(String name, String email, String password, String DOB, String phonenumber, String address,
             int ID) throws SQLException {
        updateSt.setString(1, name);
        updateSt.setString(2, email);
        updateSt.setString(3, password);
        updateSt.setString(4, DOB);
        updateSt.setString(5, phonenumber);
        updateSt.setString(6, address);
        updateSt.setString(7, Integer.toString(ID));
        int row = updateSt.executeUpdate();
        System.out.println("Row " + row + " Customer has been successflly updated");
    }

    // Read Query - Read One
    public Customer getCustomer(int ID) throws SQLException {
        String query = "SELECT * FROM store.customers WHERE customerID=" + ID;
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (ID == currentID) {

                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String dob = rs.getString(5);
                String phonenumber = rs.getString(6);
                String address = rs.getString(7);
                return new Customer(ID, name, email, password, dob, phonenumber, address);
            }
        }
        return null;
    }

    // Read Query - Read One
    public Customer getCustomer(String email) throws SQLException {
        String query = "SELECT * FROM store.customers WHERE customerEmail='" + email + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);

            if (email.equals(currentEmail)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String password = rs.getString(4);
                String dob = rs.getString(5);
                String phonenumber = rs.getString(6);
                String address = rs.getString(7);
                return new Customer(ID, name, email, password, dob, phonenumber, address);
            }
        }
        return null;
    }

    // Read Query - Read One by Email and Password
    public Customer login(String email, String password) throws SQLException {
        String query = "SELECT * FROM store.customers WHERE customerEmail='" + email + "' AND customerPassword='" + password + "'";
        ResultSet rs = st.executeQuery(query);
        while (rs.next()) {
            String currentEmail = rs.getString(3);
            String currentPassword = rs.getString(4);

            if (email.equals(currentEmail) && password.equals(currentPassword)) {
                int ID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String dob = rs.getString(5);
                String phonenumber = rs.getString(6);

                String address = rs.getString(7);
                return new Customer(ID, name, email, password, dob, phonenumber, address);

            }
        }
        return null;

    }
//Delete Query - by ID

    public void delete(int ID) throws SQLException {
        deleteSt.setString(1, "" + ID);
        int x = deleteSt.executeUpdate();

        System.out.println("User has been successflly deleted");
    }
    //Read Customers Query - Read All
    public List<Customer> getCustomers() throws SQLException {
        String query = "SELECT * FROM store.customers";
        ResultSet rs = st.executeQuery(query);
        List<Customer> temp = new ArrayList<>();
        
        while (rs.next()) {
            int customerID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String DOB = rs.getString(5);
                String phonenumber = rs.getString(6);
                String address = rs.getString(7);
            temp.add(new Customer(customerID, name,email, password, DOB, phonenumber, address));
        }
        return temp;
    }
}
