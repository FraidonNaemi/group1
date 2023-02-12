/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.OrderProduct;
import com.model.Product;
import com.model.dao.OrderProductSqlDAO;
import com.model.dao.ProductSqlDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 236369
 */
public class DeleteOrderProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            HttpSession session = request.getSession();
            OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
            ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");

            int orderID = (Integer) session.getAttribute("orderID");
            int productID = Integer.parseInt(request.getParameter("productID"));
            Product product = productSqlDAO.getProduct(productID);
            OrderProduct orderProduct = orderProductSqlDAO.getOrderProduct(orderID, productID);

            int newStock = product.getProductStock() + orderProduct.getQuantity();
            product.setProductStock(newStock);
            productSqlDAO.updateStock(productID, newStock);
            orderProduct.setQuantity(0);
            session.setAttribute("opDeleteNotification", "Product " + orderProduct.getProductID() + " Is Deleted From "+orderID+"!");
            orderProductSqlDAO.delete(orderID, productID);

        } catch (SQLException ex) {
            Logger.getLogger(DeleteOrderProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("myOrders.jsp").include(request, response);

    }
}
