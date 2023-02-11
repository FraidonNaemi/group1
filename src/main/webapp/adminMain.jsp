<%@page import="com.model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
    </head>
    <body>
        <nav>
            <div class="logo">
                AFSY
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li><a class="active" href="#">Dashboard</a></li>
                <li><a href="adminAccount.jsp">Account</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <!-- getting admin from the session-->
        <%
            Admin admin = (Admin) session.getAttribute("admin");
        %>

        <!-- Table Data -->
        <table class="content-table">

            <thead>
                <tr>
                    <th colspan="2"><h3>Admin Information</h3></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="td-title">Name: </td>
                    <td><%= admin.getAdminName()%></td>
                </tr>
                <tr>
                    <td class="td-title">Email: </td>
                    <td><%= admin.getAdminEmail()%></td>
                </tr>
                <tr>
                    <td class="td-title">Password: </td>
                    <td><%= admin.getAdminPassword()%></td>
                </tr>
                <tr>
                    <td class="td-title">Date of Birth: </td>
                    <td><%= admin.getAdminAddress()%></td>
                </tr>
                <tr>
                    <td class="td-title">Phone Number: </td>
                    <td><%= admin.getAdminPhoneNumber()%></td>
                </tr>
                <tr>
                    <td class="td-title">Address: </td>
                    <td><%= admin.getAdminAddress()%></td>
                </tr>
            </tbody>
        </table> 

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
