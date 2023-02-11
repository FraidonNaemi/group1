<%-- 
    Document   : customerMain
    Created on : 11-Feb-2023, 2:51:39 PM
    Author     : 236367
--%>

<%@page import="com.model.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Dashboard</title>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <!-- Navigation Bar -->
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
                <li><a href="customerAccount.jsp">Account</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
        
        <!-- getting customer from the session-->
        <%
            Customer customer = (Customer) session.getAttribute("customer");
        %>

        <!-- Table Data -->
        <table class="content-table">
            <thead>
                <tr>
                    <th colspan="2"><h3>Customer Information</h3></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td class="td-title">Name: </td>
                    <td><%= customer.getCustomerName()%></td>
                </tr>

                <tr>
                    <td class="td-title">Email: </td>
                    <td><%= customer.getCustomerEmail()%></td>
                </tr>

                <tr>
                    <td class="td-title">Password: </td>
                    <td><%= customer.getCustomerPassword()%></td>
                </tr>
                <tr>
                    <td class="td-title">Date of Birth: </td>
                    <td><%= customer.getCustomerDOB()%></td>
                </tr>

                <tr>
                    <td class="td-title">Phone Number: </td>
                    <td><%= customer.getCustomerPhoneNumber()%></td>
                </tr>
                <tr>
                    <td class="td-title">Address: </td>
                    <td><%= customer.getCustomerAddress()%></td>
                </tr>
            </tbody>
        </table>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
