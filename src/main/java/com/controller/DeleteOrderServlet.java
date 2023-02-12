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
public class DeleteOrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
//            int orderID = (int) session.getAttribute("orderID");
            OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
            Customer customer = (Customer) session.getAttribute("customer");
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            orderSqlDAO.deleteOrder(customer.getCustomerID(), orderID);
            
            session.setAttribute("orderNotification", "Order "+orderID+" Is Deleted!");
        } catch (SQLException ex) {
            Logger.getLogger(DeleteOrderServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("myOrders.jsp").include(request, response);
    }
}
