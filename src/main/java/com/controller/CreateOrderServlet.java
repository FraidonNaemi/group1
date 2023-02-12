/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Customer;
import com.model.dao.OrderSqlDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class CreateOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            HttpSession session = request.getSession();
            OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
            Customer customer = (Customer) session.getAttribute("customer");

            LocalDate orderDate = java.time.LocalDate.now();
            orderSqlDAO.create(customer.getCustomerID(), orderDate.toString());
            int orderID = orderSqlDAO.lastOrderID(customer.getCustomerID());
            session.setAttribute("orderID", orderID);
            
            session.setAttribute("orderNotification", "Order "+orderID+" Is Created!");
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("myOrders.jsp").include(request, response);

    }
}
