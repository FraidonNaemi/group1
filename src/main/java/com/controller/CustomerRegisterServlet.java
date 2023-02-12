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
            String customerPhoneNumber = request.getParameter("phoneNumber");
            String customerAddress = request.getParameter("address");
            

               
                   Customer customerSql = null;
            try {
                customerSql = customerSqlDAO.getCustomer(customerEmail);
            } catch (SQLException ex) {
                Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (customerSql != null) {
                session.setAttribute("addError", "Customer already exists");
                
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else {

                try {
                    customerSqlDAO.create(customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
                    Customer customer = customerSqlDAO.getCustomer(customerEmail);
                    session.setAttribute("customer", customer);
                    
                    System.out.println(customer);
                    request.getRequestDispatcher("customerMain.jsp").include(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }

