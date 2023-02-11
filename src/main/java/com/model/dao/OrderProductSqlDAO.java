/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.OrderProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 236369
 */
public class OrderProductSqlDAO {

    private Statement st;
    private PreparedStatement deleteSt;
    private String deleteQuery = "delete from store.orderproducts where orderID = ? and productID= ?";
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.orderproducts SET orderproducts.quantity = ? WHERE orderID =? and productID =?";

    public OrderProductSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteSt = connection.prepareStatement(deleteQuery);
        this.updateSt = connection.prepareStatement(updateQuery);
    }

    //Create OrderProduct into an order
    public void create(int orderID, int productID, int quantity) throws SQLException {
        String columns = "INSERT INTO store.orderproducts(orderID,productID,quantity)";
        String values = "VALUES('" + orderID + "','" + productID + "','" + quantity + "')";
        st.executeUpdate(columns + values);
    }

    //Read All orderProducts for an order
    public List<OrderProduct> getAllOrderProducts(int orderID) throws SQLException {
        String fetch = "SELECT productID,quantity from store.orderProducts"
                + " WHERE orderID =" + orderID;
        ResultSet rs = st.executeQuery(fetch);
        List<OrderProduct> ops = new ArrayList<>();
        while (rs.next()) {
            int productID = Integer.parseInt(rs.getString(1));
            int quantity = Integer.parseInt(rs.getString(2));
            OrderProduct orderProduct = new OrderProduct(orderID, productID, quantity);
            ops.add(orderProduct);
        }
        return ops;
    }

    //Update Query (Name, Password) by ID
    public void update(int quantity, int orderID, int productID) throws SQLException {
        updateSt.setInt(1, quantity);
        updateSt.setInt(2, orderID);
        updateSt.setInt(3, productID);
        int row = updateSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly updated");
    }

    //delete All orderproducts form an order(reset order)
    public void deleteAllOrderProducts(int orderID) throws SQLException {
        String fetch = "delete from store.orderproducts where orderID=" + orderID;
        int row = st.executeUpdate(fetch);
        System.out.println("Row " + row + " has been successflly deleted");

    }

    //return order product by orderID and productID
    public OrderProduct getOrderProduct(int orderID, int productID) throws SQLException {
        String fetch = "select quantity from store.orderproducts where orderID=" + orderID + " and productID= " + productID;
        ResultSet rs = st.executeQuery(fetch);

        int quantity = 0;
        while (rs.next()) {
            quantity = Integer.parseInt(rs.getString(1));

        }
        OrderProduct orderProduct = new OrderProduct(orderID, productID, quantity);
        return orderProduct;
    }

    //Delete Query - by ID (one product)
    public void delete(int orderID, int productID) throws SQLException {
        deleteSt.setInt(1, orderID);
        deleteSt.setInt(2, productID);
        int row = deleteSt.executeUpdate();
        System.out.println("Row " + row + " has been successflly deleted");
    }

}
