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
public class AdminCustomerAccountServlet extends HttpServlet {
    // Get all the data from adminAccount.jsp page, validate them against regEx. If they do not meets the regEx;
    // redirect to adminAccount.jsp page with approprite error message. Else, update it.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
        String emailView = request.getParameter("emailView");
        String submitted = request.getParameter("submitted");

        Customer customer = null;

        if (submitted != null && submitted.equals("submitted")) {
            try {
                int customerID = Integer.parseInt(request.getParameter("customerID"));
                String customerName = request.getParameter("customerName");
                String customerEmail = request.getParameter("customerEmail");
                String customerPassword = request.getParameter("customerPassword");
                String customerDOB = request.getParameter("customerDOB");
                String customerPhoneNumber = request.getParameter("customerPhoneNumber");
                String customerAddress = request.getParameter("customerAddress");
                
                String customerNameRegEx = "([A-Za-z]{2,25})[ ]([A-Za-z]{2,24})";
                String customerPasswordRegEx = "([A-Z][a-z]{5,14})([\\d]{3,6})";
                String customerDOBRegEx = "^(19[2-9][3-9]|20[0-1][0-3])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
                String customerPhoneNumberRegEx = "^[\\+\\d]\\d{9,11}$";
                String customerAddressRegEx = "([\\d]{1,4})([A-Za-z\\s\\d\\,\\-\\/]{10,97})";
                
                boolean customerNameError = false;
                boolean customerPasswordError = false;
                boolean customerDOBError = false;
                boolean customerPhoneNumberError = false;
                boolean customerAddressError = false;
                
                if (!customerName.matches(customerNameRegEx)) {
                    session.setAttribute("customerNameError", "Incorrect format");
                    customerNameError = true;
                } if (!customerPassword.matches(customerPasswordRegEx)) {
                    session.setAttribute("customerPasswordError", "Incorrect format");
                    customerPasswordError = true;
                } if (!customerDOB.matches(customerDOBRegEx)) {
                    session.setAttribute("customerDOBError", "Incorrect format");
                    customerDOBError = true;
                } if (!customerPhoneNumber.matches(customerPhoneNumberRegEx)) {
                    session.setAttribute("customerPhoneNumberError", "Incorrect format");
                    customerPhoneNumberError = true;
                } if (!customerAddress.matches(customerAddressRegEx)) {
                    session.setAttribute("customerAddressError", "Incorrect format");
                    customerAddressError = true;
                } 
                
                if (emailView != null) {
                    customer = customerSqlDAO.getCustomer(emailView);
                } else {
                    customer = (Customer) session.getAttribute("customer");
                }
                
                if (customerNameError
                        || customerPasswordError
                        || customerDOBError
                        || customerPhoneNumberError
                        || customerAddressError) {
                    request.getRequestDispatcher("adminCustomerAccount.jsp").include(request, response);
                } else {
                    customer.update(customerID, customerName, customerEmail, customerPassword, customerDOB, customerPhoneNumber, customerAddress);
                    customerSqlDAO.update(customerName, customerPassword, customerDOB, customerPhoneNumber, customerAddress, customerID);
                    session.setAttribute("customer", customer);
                    request.getRequestDispatcher("adminCustomerView.jsp").include(request, response);
                }
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminCustomerAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}