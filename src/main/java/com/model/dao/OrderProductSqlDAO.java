/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.dao;

import com.model.OrderProduct;
import com.model.OrderProducts;
import com.model.Product;
import com.model.Products;
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
    private String deleteQuery = "delete from store.orderproduct where orderID = ? and productID= ?";
    private PreparedStatement updateSt;
    private String updateQuery = "UPDATE store.orderproduct SET orderproduct.quantity = ? WHERE orderID =? and productID =?";

    public OrderProductSqlDAO(Connection connection) throws SQLException {
        this.st = connection.createStatement();
        this.deleteSt = connection.prepareStatement(deleteQuery);
        this.updateSt = connection.prepareStatement(updateQuery);
    }

    //Create OrderProduct into an order
    public void create(int orderID, int productID, int quantity) throws SQLException {
        String columns = "INSERT INTO store.orderproduct(orderID,productID,quantity)";
        String values = "VALUES('" + orderID + "','" + productID + "','" + quantity + "')";
        st.executeUpdate(columns + values);
    }

//   //Read All orderProducts for an order
//    public List<OrderProduct> getAllOrderProducts(int orderID) throws SQLException {
//        String fetch = "SELECT products.productID, products.productImage, products.productName, products.productPrice, products.productCategory, products.productDescription,orderProduct.quantity"
//                + " FROM store.orders "
//                + " INNER JOIN store.orderProduct "
//                + " ON orders.orderID = orderproduct.orderID"
//                + " INNER JOIN store.products "
//                + " ON products.productID = orderproduct.productID "
//                + " WHERE orders.orderID =" + orderID;
//        ResultSet rs = st.executeQuery(fetch);
//
//        List<OrderProduct> ops = new ArrayList<>();
////        List<Product> productsList = new ArrayList<>();
//        OrderProduct orderProducts = new OrderProduct();
//        
//        while (rs.next()) {
//            int productID = Integer.parseInt(rs.getString(1));
//            String productImage = rs.getString(2);
//            String productName = rs.getString(3);
//            double productPrice = Double.parseDouble(rs.getString(4));
//            String productCategory = rs.getString(5);
//            String productDescription = rs.getString(6);
////            int quantity = Integer.parseInt(rs.getString(7));
//            Product product = new Product(productID, productImage, productName, productPrice, productCategory, productDescription,0);
////            productsList.add(product);
//            orderProducts.addProduct(product);
//            ops.add(orderProducts);
//        }
//
//        return ops;
//    }
    //Read All orderProducts for an order
    public List<OrderProduct> getAllOrderProducts(int orderID) throws SQLException {
        String fetch = "SELECT productID,quantity from store.orderProduct"
                + " WHERE orderID =" + orderID;
        ResultSet rs = st.executeQuery(fetch);

        List<OrderProduct> ops = new ArrayList<>();
//        List<Product> productsList = new ArrayList<>();
      

        while (rs.next()) {
            int productID = Integer.parseInt(rs.getString(1));
            int quantity = Integer.parseInt(rs.getString(2));
            OrderProduct orderProduct = new OrderProduct(orderID,productID, quantity);
//            productsList.add(product);
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
        String fetch = "delete from store.orderproduct where orderID=" + orderID;
        int row = st.executeUpdate(fetch);
        System.out.println("Row " + row + " has been successflly deleted");

    }

    //delete one Order for a Customer by ID
//    public void deleteOneOrderProductByID(int orderID, int productID) throws SQLException {
//        String fetch = "delete from store.orderproduct where orderID = " + orderID + "and productID= " + productID;
//        ResultSet rs = st.executeQuery(fetch);
//    }
    //Delete Query - by ID (one product)
    public void delete(int orderID, int productID) throws SQLException {
        deleteSt.setInt(1, orderID);
        deleteSt.setInt(2, productID);
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
