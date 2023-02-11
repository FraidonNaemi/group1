/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Customer;
import com.model.dao.CustomerSqlDAO;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author 236367
 */
public class CustomerLoginServlet extends HttpServlet {

            
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
        Customer customer = null;
        try {
            customer = customerSqlDAO.login(email, password);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerLoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (customer != null) {
            session.setAttribute("customer", customer);
            // response.sendRedirect("main.jsp");
            request.getRequestDispatcher("main.jsp").include(request, response);
        } else {
            session.setAttribute("userError", "Customer does not exist");
            // response.sendRedirect("login.jsp");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
    }
}

  