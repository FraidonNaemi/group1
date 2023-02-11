/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.Admin;
import com.model.Customer;
import com.model.dao.AdminSqlDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminDeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminSqlDAO adminSqlDAO = (AdminSqlDAO) session.getAttribute("adminSqlDAO");
//        String emailView = (String) session.getAttribute("emailView");

         Admin admin = (Admin) session.getAttribute("admin");

         if (admin != null) {
            try {
                adminSqlDAO.delete(admin.getAdminID());
                
            } catch (SQLException ex) {
                Logger.getLogger(AdminDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            session.invalidate();
                request.getRequestDispatcher("index.jsp").include(request, response);
            
        }

//        if (emailView != null) {
//            request.getRequestDispatcher("adminView.jsp").include(request, response);
    }
}

