package com.controller;

import com.model.Admin;
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

/**
 *
 * @author group1
 */
public class AdminRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
            HttpSession session = request.getSession();
            AdminSqlDAO adminSqlDAO = (AdminSqlDAO) session.getAttribute("adminSqlDAO");
            
            String adminName = request.getParameter("name");
            String adminEmail = request.getParameter("email");
            String adminPassword = request.getParameter("password");
            String adminDOB = request.getParameter("dob");
            String adminPhoneNumber = request.getParameter("phoneNumber");
            String adminAddress = request.getParameter("address");
            
                    
                
               
                   Admin adminSql = null;
            try {
                adminSql = adminSqlDAO.getAdmin(adminEmail);
            } catch (SQLException ex) {
                Logger.getLogger(AdminRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (adminSql != null) {
                session.setAttribute("addError", "admin already exists");
                
                request.getRequestDispatcher("register.jsp").include(request, response);
            } else {

                try {
                    adminSqlDAO.create(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress);
                    Admin admin = adminSqlDAO.getAdmin(adminEmail);
                    session.setAttribute("admin", admin);
                    
                    System.out.println(admin);
                    request.getRequestDispatcher("adminMain.jsp").include(request, response);

                } catch (SQLException ex) {
                    Logger.getLogger(AdminRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
            
            
            
            
            
            
    }

