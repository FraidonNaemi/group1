package com.model.dao;

import com.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author group1
 */
public class AdminSqlDAO {

    private Statement st;
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.admins SET adminName=?,adminEmail=?,adminPassword=?,adminDOB=?,adminPhoneNumber=?,adminAddress=? WHERE adminID=?";
    private PreparedStatement deleteSt;
    private String deleteQuery = "DELETE FROM store.admins WHERE adminID=?";

    public AdminSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.updateSt = connection.prepareStatement(updateQuery);
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    // Create Query
    public void create(String adminName, String adminEmail, String adminPassword, String adminDOB, String adminPhoneNumber, String adminAddress) throws SQLException {
        String columns = "INSERT INTO store.admins(adminName,adminEmail,adminPassword,adminDOB,adminPhoneNumber,adminAddress)";
        String values = "VALUES('" + adminName + "', '" + adminEmail + "','" + adminPassword + "','" + adminDOB + "','" + adminPhoneNumber + "','" + adminAddress + "')";
        System.out.println(values);
        st.executeUpdate(columns + values);
    }
    
    public void create(String adminEmail) throws SQLException {
        String columns = "INSERT INTO store.admins(adminName,adminEmail,adminPassword,adminDOB,adminPhoneNumber,adminAddress)";
        String values = "VALUES('matt smith' , '" + adminEmail + "','Hellomatt123','1999-08-20','0435678976','54 Victoria avenue, Sydney 2222')";
        System.out.println(values);
        st.executeUpdate(columns + values);
    }


    public void update(String adminName, String adminEmail, String adminPassword, String adminDOB, String adminPhoneNumber, String adminAddress,
             int adminID) throws SQLException {
        updateSt.setString(1, adminName);
        updateSt.setString(2, adminEmail);
        updateSt.setString(3, adminPassword);
        updateSt.setString(4, adminDOB);
        updateSt.setString(5, adminPhoneNumber);
        updateSt.setString(6, adminAddress);
        updateSt.setString(7, Integer.toString(adminID));
        int row = updateSt.executeUpdate();
        System.out.println("Row " + row + " Admin has been successflly updated");
    }

    // Read Query - Read One
    public Admin getAdmin(int ID) throws SQLException {
        String query = "SELECT * FROM store.admins WHERE adminID=" + ID;
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
                return new Admin(ID, name, email, password, dob, phonenumber, address);
            }
        }
        return null;
    }

    // Read Query - Read One
    public Admin getAdmin(String email) throws SQLException {
        String query = "SELECT * FROM store.admins WHERE adminEmail='" + email + "'";
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
                return new Admin(ID, name, email, password, dob, phonenumber, address);
            }
        }
        return null;
    }

    // Read Query - Read One by Email and Password
    public Admin login(String email, String password) throws SQLException {
        String query = "SELECT * FROM store.admins WHERE adminEmail='" + email + "' AND adminPassword='" + password + "'";
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
                return new Admin(ID, name, email, password, dob, phonenumber, address);

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
    //Read Admins Query - Read All
    public List<Admin> getAdmins() throws SQLException {
        String query = "SELECT * FROM store.admins";
        ResultSet rs = st.executeQuery(query);
        List<Admin> temp = new ArrayList<>();
        while (rs.next()) {
            int adminID = Integer.parseInt(rs.getString(1));
                String name = rs.getString(2);
                String email = rs.getString(3);
                String password = rs.getString(4);
                String DOB = rs.getString(5);
                String phonenumber = rs.getString(6);
                String address = rs.getString(7);
            temp.add(new Admin(adminID, name,email, password, DOB, phonenumber, address));
        }
        return temp;
    }
}
