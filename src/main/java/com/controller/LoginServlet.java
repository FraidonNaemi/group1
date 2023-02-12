package com.controller;

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
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //getting the variables that sent using post method
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        //set Regex roles
        String emailRegEx = "([a-zA-Z]+)[.]([a-zA-Z]+)@store.com";
        String passRegEx = "([A-Z][a-z]{5,14})([\\d]{3,6})";
//
       if (!email.matches(emailRegEx) && !password.matches(passRegEx)) {
            session.setAttribute("emailPasswordError", "Incorrect format");
            request.getRequestDispatcher("login.jsp").include(request, response);
            // response.sendRedirect("login.jsp");
        } else if (!email.matches(emailRegEx)) {
            session.setAttribute("emailError", "Incorrect email format");
            request.getRequestDispatcher("login.jsp").include(request, response);
            // response.sendRedirect("login.jsp");
       } else if (!password.matches(passRegEx)) {
            session.setAttribute("passwordError", "Incorrect password format");
                request.getRequestDispatcher("login.jsp").include(request, response);
       }
        // response.sendRedirect("login.jsp");
            //set the variables to the session
            session.setAttribute("email", email);
            session.setAttribute("password", password);
            //check the user type
            if (userType.equals("customer")) {
                request.getRequestDispatcher("/CustomerLoginServlet").include(request, response);
            } else {
                request.getRequestDispatcher("/AdminLoginServlet").include(request, response);
            }
        }
    }

