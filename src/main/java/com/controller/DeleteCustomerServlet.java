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
public class DeleteCustomerServlet extends HttpServlet {
    // Get the customer email and delete it from database by email
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
            String customerEmail = request.getParameter("customerEmail");
            
            Customer customer = (Customer) session.getAttribute("customer");
            
            customerSqlDAO.delete(customer.getCustomerEmail());
            request.getRequestDispatcher("viewCustomers.jsp").include(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteCustomerServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
