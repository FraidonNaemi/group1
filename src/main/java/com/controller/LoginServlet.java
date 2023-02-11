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
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        
        if (userType.equals("customer")) {
            request.getRequestDispatcher("/CustomerLoginServlet").include(request, response);
        } else {
            request.getRequestDispatcher("/AdminLoginServlet").include(request, response);
        }
    }
}