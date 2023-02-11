/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.Order;
import com.model.Orders;
import java.sql.PreparedStatement;
import java.time.LocalDate;

/**
 *
 * @author 236369
 */
public class OrderSqlDAO {

    private Statement st;
    private PreparedStatement deleteSt;
    private String deleteQuery = "delete from store.orders where orderID = ?";

    public OrderSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteSt = connection.prepareStatement(deleteQuery);
    }

    //Create Order for a Customer by customerID
    public void create(int customerID, String orderDate) throws SQLException {
        String columns = "INSERT INTO store.orders (customerID , orderDate)";
        String values = "VALUES('" + customerID + "','" + orderDate + "')";
        st.executeUpdate(columns + values);
    }


    public int lastOrderID(int customerID) throws SQLException {
        String fetch = "select orderID from store.orders where customerID ="+customerID+" order by orderID desc limit 1";
        ResultSet rs = st.executeQuery(fetch);

        int orderID = 0;
        while (rs.next()) {
            orderID = Integer.parseInt(rs.getString(1));

        }
        return orderID;
    }

    //Read All Orders for a Customer
    public List<Order> getAllOrders(int customerID) throws SQLException {
        String fetch = "SELECT * FROM store.orders where customerID=" + customerID;
        ResultSet rs = st.executeQuery(fetch);

        List<Order> temp = new ArrayList<>();

        while (rs.next()) {
            int orderID = Integer.parseInt(rs.getString(1));
            String orderDate = rs.getString(2);
            customerID = Integer.parseInt(rs.getString(3));

            temp.add(new Order(orderID, orderDate, customerID));
        }
        return temp;
    }
//
    //Read All Orders for a Customer

    public Order getOrderByID(int customerID) throws SQLException {
        String fetch = "SELECT * FROM store.orders where customerID = " + customerID;
        ResultSet rs = st.executeQuery(fetch);
        Order order = new Order();

        while (rs.next()) {
            customerID = Integer.parseInt(rs.getString(1));
            int orderID = Integer.parseInt(rs.getString(2));
            String orderDate = rs.getString(3);
            order = (new Order(orderID, orderDate, customerID));
        }
        return order;
    }
    
//
//    //delete All Orders for a Customer
//    public void deleteAllOrders(int customerID) throws SQLException {
//        String fetch = "delete orders from store.orders where customerID=" + customerID;
//        ResultSet rs = st.executeQuery(fetch);
//    }
//
    //delete one Order for a Customer by ID

    public void deleteOrder( int orderID) throws SQLException {
        
        deleteSt.setInt(1, orderID);
        int row = deleteSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly deleted");
    }

    //archive Order
//    public void archive(int customerID) throws SQLException{
//        List<Order> orders = getOrder(cusomerID);
//        
//        for(Order order:orders)
//            create(customerID, order.getOrderDate(), "store.ordersArchive");
//    }
}
