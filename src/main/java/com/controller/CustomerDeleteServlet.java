/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Customer;
import com.model.dao.CustomerSqlDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
        
        Customer customer = (Customer) session.getAttribute("customer");

        if (customer != null) {
            try {
                customerSqlDAO.delete(customer.getCustomerID());

            } catch (SQLException ex) {
                Logger.getLogger(CustomerDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.invalidate();
            request.getRequestDispatcher("index.jsp").include(request, response);

        }

    }
}
