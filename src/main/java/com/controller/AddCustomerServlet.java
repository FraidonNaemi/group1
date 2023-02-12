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

/**
 *
 * @author group1
 */
public class AddCustomerServlet extends HttpServlet {
    // Get all the data and check it in within the database, if customer exists, redirect to add customer with
    // appropriate error message. Else add the customer.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession(true);
            CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
            
            String customerName = request.getParameter("customerName");
            String customerEmail = request.getParameter("customerEmail");
            String customerPassword = request.getParameter("customerPassword");
            String customerDOB = request.getParameter("customerDOB");
            String customerPhoneNumber = request.getParameter("customerPhoneNumber");
            String customerAddress = request.getParameter("customerAddress");
            
            Customer customerSql = customerSqlDAO.getCustomer(customerEmail);

            if (customerSql != null) {
                session.setAttribute("addError", "Customer already exist");
                request.getRequestDispatcher("addCustomer.jsp").include(request, response);
            } else {
                customerSqlDAO.create(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
                Customer customer = customerSqlDAO.getCustomer(customerEmail);
                session.setAttribute("customer", customer);
                request.getRequestDispatcher("adminCustomerView.jsp").include(request, response); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
