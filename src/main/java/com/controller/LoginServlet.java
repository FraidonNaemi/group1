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

        String emailRegEx = "([a-zA-Z]+)[.]([a-zA-Z]+)@store.com";
        String passwordRegEx = "([A-Z][a-z]{5,})\\d{2,}";
        
        // Matching the fields against regEx, and redirecting the user to its servlet
        if (!email.matches(emailRegEx) && !password.matches(passwordRegEx)) {
            session.setAttribute("emailPasswordError", "Incorrect email and password format");
            response.sendRedirect("login.jsp");
        } else if (!email.matches(emailRegEx)) {
            session.setAttribute("emailError", "Incorrect email format");
            response.sendRedirect("login.jsp");
        } else if (!password.matches(passwordRegEx)) {
            session.setAttribute("passwordError", "Incorrect password format");
            response.sendRedirect("login.jsp");
        } else {
            session.setAttribute("email", email);
            session.setAttribute("password", password);

            if (userType.equals("customer")) {
                // request.getRequestDispatcher("/CustomerServlet").include(request, response);
                response.sendRedirect("afterLogin.jsp");
            } else if (userType.equals("admin")) {
                // request.getRequestDispatcher("/AdminServlet").include(request, response);
                response.sendRedirect("afterLogin.jsp");
            } else {
                session.setAttribute("userError", "User does not exist");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        }
    }
}
