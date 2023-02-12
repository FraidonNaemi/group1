/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.dao.CustomerSqlDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author group1
 */
public class RegexRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");

// get the parameter from(register.jsp) from the session 
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //String dob = request.getParameter("dob");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String userType = request.getParameter("userType");

        // set Regex roles
        String nameRegEx = "([A-Za-z]{2,25})[ ]([A-Za-z]{2,24})";
        String emailRegEx = "([a-zA-Z]+)[.]([a-zA-Z]+)@store.com";
        String passwordRegEx = "([A-Z][a-z]{5,14})([\\d]{3,6})";
        //String dobRegEx = "^\\\\d{4}-\\\\d{2}-\\\\d{2}$";
        String phoneNumberRegEx = "^[\\+\\d]\\d{9,11}$";
        String addressRegEx = "([\\d]{1,4})([A-Za-z\\s\\d\\,\\-\\/]{10,97})";

//track the error state of different fields in a form
        boolean nameError = false;
        boolean emailError = false;
        boolean passwordError = false;
        //boolean dobError = false;
        boolean phoneNumberError = false;
        boolean addressError = false;

        if (!name.matches(nameRegEx)) {
            session.setAttribute("nameError", "Incorrect format");
            nameError = true;

        }

        if (!email.matches(emailRegEx)) {
            session.setAttribute("emailError", "Incorrect format");
            emailError = true;

        }

        if (!password.matches(passwordRegEx)) {
            session.setAttribute("passwordError", "Incorrect format");
            passwordError = true;
        }
//        if (!dob.matches(dobRegEx)) {
//            session.setAttribute("dobError", "Incorrect format");
//            dobError = true;
//        }
        if (!phoneNumber.matches(phoneNumberRegEx)) {
            session.setAttribute("phoneNumberError", "Incorect format");
            phoneNumberError = true;
        }
        if (!address.matches(addressRegEx)) {
            session.setAttribute("addressError", "Incorrect  format");
            addressError = true;
        }

        if (nameError == true
                || emailError == true
                || passwordError == true
                // || dobError == true
                || phoneNumberError == true
                || addressError == true) {

            request.getRequestDispatcher("register.jsp").include(request, response);

        } else {
            if (userType.equals("customer")) {
                request.getRequestDispatcher("/CustomerRegisterServlet").include(request, response);
            } else {
                request.getRequestDispatcher("/AdminRegisterServlet").include(request, response);

            }

        }
    }
}