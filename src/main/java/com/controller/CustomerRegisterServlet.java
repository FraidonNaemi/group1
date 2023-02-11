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
public class CustomerRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            HttpSession session = request.getSession();
            CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
           

            String customerName = request.getParameter("name");
            String customerEmail = request.getParameter("email");
            String customerPassword = request.getParameter("password");
            String customerDOB = request.getParameter("dob");
            String customerPhoneNumber = request.getParameter("phonenumber");
            String customerAddress = request.getParameter("address");
            

            
            String customerEmailRegEx = "([a-zA-Z]+)[.]([a-zA-Z]+)@store.com";
            String customerPasswordRegEx = "([A-Z][a-z]{5,12})\\d{3,6}";
            

            
            if (!customerEmail.matches(customerEmailRegEx) && !customerPassword.matches(customerPasswordRegEx)) {
                session.setAttribute("emailPassError", "Incorrect email and password format");
                response.sendRedirect("register.jsp");
            } else if (!customerEmail.matches(customerEmailRegEx)) {
                session.setAttribute("emailError", "Incorrect email format");
                response.sendRedirect("register.jsp");
            } else if (!customerPassword.matches(customerPasswordRegEx)) {
                session.setAttribute("passError", "Incorrect password format");
                response.sendRedirect("register.jsp");
               
            } else {
                
               
                   Customer customerSql = null;
            try {
                customerSql = customerSqlDAO.getCustomer(customerEmail);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (customerSql != null) {
                session.setAttribute("emailError", "Customer already exists");
                
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else {

                try {
                    customerSqlDAO.create(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
                    Customer customer = customerSqlDAO.getCustomer(customerEmail);
                    session.setAttribute("customer", customer);
                    
                    System.out.println(customer);
                    request.getRequestDispatcher("main.jsp").include(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

}
