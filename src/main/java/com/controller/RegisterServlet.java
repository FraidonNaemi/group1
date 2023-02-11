
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
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
      
       //we sent 3 variables from login.jsp into the session 
      //getting the values of the parameters passed in an HTTP request and storing them in local variables.
        String customerName = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");

        session.setAttribute("email", email);
        session.setAttribute("pass", password);
        session.setAttribute("name", customerName);
        

        //checking if Usertype is customer or admin 
        if (userType.equals("customer")) {
            request.getRequestDispatcher("/CustomerRegisterServlet").include(request, response);
        } else {
            request.getRequestDispatcher("/AdminRegisterServlet").include(request, response);
        }
    }
}
