package com.model.dao;

import com.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminSqlDAO {

    private Statement st;
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.admin SET adminName=?, adminPassword=?, adminDOB=?, adminphoneNumber=?, adminAddress=? WHERE adminID=?";
    private PreparedStatement deleteSt;
    private String deleteQuery = "DELETE FROM store.admin WHERE adminID=?";

    public AdminSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.updateSt = connection.prepareStatement(updateQuery);
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    // Create Admin Query
    public void create( String adminName, String adminEmail, String adminPassword, String adminDOB, String adminPhoneNumber, String adminAddress) throws SQLException {
        String columns = "INSERT INTO store.admin(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress)";
        String values = "VALUES('" + adminName + "','" + adminEmail + "','" + adminPassword + "','" + adminDOB + "','" + adminPhoneNumber + "','" + adminAddress + "')";
        
        st.executeUpdate(columns + values);
    }

    // Read Admin Query - Read One
    public Admin getAdmin(int adminID) throws SQLException {
        String query = "SELECT * FROM store.admin WHERE adminID=" + adminID;
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            int currentID = Integer.parseInt(rs.getString(1));

            if (adminID == currentID) {
                String adminName = rs.getString(2);
                String adminEmail = rs.getString(3);
                String adminPassword = rs.getString(4);
                String adminDOB = rs.getString(5);
                String adminPhoneNumber = rs.getString(6);
                String adminAddress = rs.getString(7);
                
                return new Admin(adminID, adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress);
            }
        }
        
        return null;
    }

    // Read Admin Query - Read One
    public Admin getAdmin(String admin_email) throws SQLException {
        String query = "SELECT * FROM store.admin WHERE adminEmail='" + admin_email + "'";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String currentEmail = rs.getString(3);

            if (admin_email.equals(currentEmail)) {
                int adminID = Integer.parseInt(rs.getString(1));
                String adminName = rs.getString(2);
                String adminEmail = rs.getString(3);
                String adminPassword = rs.getString(4);
                String adminDOB = rs.getString(5);
                String adminPhoneNumber = rs.getString(6);
                String adminAddress = rs.getString(7);
                
                return new Admin(adminID, adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress);
            }
        }
        
        return null;
    }

    // Read Admin Query - Read One by Email and Password
    public Admin login(String admin_email, String admin_password) throws SQLException {
        String query = "SELECT * FROM store.admin WHERE adminEmail='" + admin_email + "' AND adminPassword='" + admin_password + "'";
        ResultSet rs = st.executeQuery(query);
        
        while (rs.next()) {
            String currentEmail = rs.getString(3);
            String currentPassword = rs.getString(4);

            if (admin_email.equals(currentEmail) && admin_password.equals(currentPassword)) {
                int adminID = Integer.parseInt(rs.getString(1));
                String adminName = rs.getString(2);
                String adminEmail = rs.getString(3);
                String adminPassword = rs.getString(4);
                String adminDOB = rs.getString(5);
                String adminPhoneNumber = rs.getString(6);
                String adminAddress = rs.getString(7);
                
                return new Admin(adminID, adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress);
            }
        }
        
        return null;
    }
}