package com.controller;

import com.model.Admin;
import com.model.dao.CustomerSqlDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author group1
 */
public class AddCustomerRegexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String customerName = request.getParameter("customerName");
        String customerEmail = request.getParameter("customerEmail");
        String customerPassword = request.getParameter("customerPassword");
        String customerDOB = request.getParameter("customerDOB");
        String customerPhoneNumber = request.getParameter("customerPhoneNumber");
        String customerAddress = request.getParameter("customerAddress");

        // set Regex roles
        String customerNameRegEx = "([A-Za-z]{2,25})[ ]([A-Za-z]{2,24})";
        String customerEmailRegEx = "([a-zA-Z]+)[.]([a-zA-Z]+)@store.com";
        String customerPasswordRegEx = "([A-Z][a-z]{5,14})([\\d]{3,6})";
        String customerDOBRegEx = "^(19[2-9][3-9]|20[0-1][0-3])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
        String customerPhoneNumberRegEx = "^[\\+\\d]\\d{9,11}$";
        String customerAddressRegEx = "([\\d]{1,4})([A-Za-z\\s\\d\\,\\-\\/]{10,97})";

        boolean customerNameError = false;
        boolean customerEmailError = false;
        boolean customerPasswordError = false;
        boolean customerDOBError = false;
        boolean customerPhoneNumberError = false;
        boolean customerAddressError = false;

        if (!customerName.matches(customerNameRegEx)) {
            session.setAttribute("customerNameError", "Incorrect format");
            customerNameError = true;
        } if (!customerEmail.matches(customerEmailRegEx)) {
            session.setAttribute("customerEmailError", "Incorrect format");
            customerEmailError = true;
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

        if (customerNameError == true
                || customerEmailError == true
                || customerPasswordError == true
                || customerDOBError == true
                || customerPhoneNumberError == true
                || customerAddressError == true) {
            request.getRequestDispatcher("addCustomer.jsp").include(request, response);
        } else {
            request.getRequestDispatcher("/AddCustomerServlet").include(request, response);
        }
    }
}
