<%@page import="com.model.Customer"%>
<%@page import="com.model.dao.AdminSqlDAO"%>
<%@page import="com.model.Admin"%>

<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
        <title>Main</title>
        <link rel="stylesheet" href="css/style.css">

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
                <li><a href="/group1/LogoutServlet">Logout</a></li>
                <li><a href="account.jsp">Account</a></li>
                <li><a href="myOrders.jsp">My Orders</a></li>
                
            </ul>

        </nav>

        <!-- customer object pull from database-->
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
                    <td class="td-title">Name </td>
                    <td><%= customer.getName()%></td>
                </tr>

                <tr>
                    <td class="td-title">Email: </td>
                    <td><%= customer.getEmail()%></td>
                </tr>

                <tr>
                    <td class="td-title">Password: </td>
                    <td><%= customer.getPassword()%></td>
                </tr>
                <tr>
                    <td class="td-title">DOB </td>
                    <td><%= customer.getDOB()%></td>
                </tr>

                <tr>
                    <td class="td-title">Phone</td>
                    <td><%= customer.getPhonenumber()%></td>
                </tr>
                <tr>
                    <td class="td-title">Address </td>
                    <td><%= customer.getAddress()%></td>
                </tr>

            </tbody>
        </table>
    

        

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
