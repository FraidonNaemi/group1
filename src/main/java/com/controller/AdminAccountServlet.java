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

public class AdminAccountServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        AdminSqlDAO adminSqlDAO = (AdminSqlDAO) session.getAttribute("adminSqlDAO");
        String emailView = request.getParameter("emailView");
        String submitted = request.getParameter("submitted");

        Admin admin = null;

        if (submitted != null && submitted.equals("submitted")) {
            try {
                int adminID = Integer.parseInt(request.getParameter("adminID"));
                String adminName = request.getParameter("adminName");
                String adminEmail = request.getParameter("adminEmail");
                String adminPassword = request.getParameter("adminPassword");
                String adminDOB = request.getParameter("adminDOB");
                String adminPhoneNumber = request.getParameter("adminPhoneNumber");
                String adminAddress = request.getParameter("adminAddress");

                String adminNameRegEx = "([A-Za-z]{2,25})[ ]([A-Za-z]{2,24})";
                String adminPasswordRegEx = "([A-Z][a-z]{5,14})([\\d]{3,6})";
                String adminDOBRegEx = "";
                String adminPhoneNumberRegEx = "^[\\+\\d]\\d{9,11}$";
                String adminAddressRegEx = "([\\d]{1,4})([A-Za-z\\s\\d\\,\\-\\/]{10,97})";

                boolean adminNameError = false;
                boolean adminPasswordError = false;
                boolean adminDOBError = false;
                boolean adminPhoneNumberError = false;
                boolean adminAddressError = false;
                if (!adminName.matches(adminNameRegEx)) {
                    session.setAttribute("adminNameError", "Incorrect format");
                    adminNameError = true;

                }
                if (!adminPassword.matches(adminPasswordRegEx)) {
                    session.setAttribute("adminPasswordError", "Incorrect format");
                    adminPasswordError = true;
                }
                if (!adminDOB.matches(adminDOBRegEx)) {
                    session.setAttribute("adminDOBError", "Incorrect format");
                    //adminDOBError = true;
                }
                if (!adminPhoneNumber.matches(adminPhoneNumberRegEx)) {
                    session.setAttribute("adminPhoneNumberError", "Incorrect format");
                    adminPhoneNumberError = true;
                }
                if (!adminAddress.matches(adminAddressRegEx)) {
                    session.setAttribute("adminAddressError", "Incorrect format");
                    adminAddressError = true;
                }

                if (emailView != null) {
                    admin = adminSqlDAO.getAdmin(emailView);
                } else {
                    admin = (Admin) session.getAttribute("admin");
                }

                if (adminNameError
                        || adminPasswordError
                        || adminDOBError
                        || adminPhoneNumberError
                        || adminAddressError) {
                    request.getRequestDispatcher("adminAccount.jsp").include(request, response);
                } else {
                    admin.update(adminID, adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress);
                    adminSqlDAO.update(adminName, adminEmail, adminPassword, adminDOB, adminPhoneNumber, adminAddress, adminID);
                    session.setAttribute("admin", admin);
                    request.getRequestDispatcher("adminAccount.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
