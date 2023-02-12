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
public class CustomerSearchServlet extends HttpServlet {
    // Get the customer ID and search it within the database, if it exist; redirect to adminCustomerAccount.jsp page
    // for update. Else, redirect to viewCustomers.jsp page with appropraite message. 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
        int customerID = Integer.parseInt(request.getParameter("customerID"));
        
        Customer customer = null;
        try {
            customer = customerSqlDAO.getCustomer(customerID);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerSearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(customer != null) {
            session.setAttribute("customer", customer);
            request.getRequestDispatcher("adminCustomerAccount.jsp").include(request, response);
        } else {
            session.setAttribute("customerError", "Customer does not exist");
            request.getRequestDispatcher("viewCustomers.jsp");
        }
    
    }
}