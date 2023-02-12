<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Management</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/adminCustomerView.css">
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
                <li><a href="adminMain.jsp">Dashboard</a></li>
                <li><a class="active" href="#">Customer Management</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <!-- Link Buttons to perform CRUD operations on customer/s -->
        <div class="container">
                <a href="addCustomer.jsp"><button class="btn btn1">Add Customer</button></a>
            <a href="viewCustomers.jsp"><button class="btn btn2">View Customers</button></a>
        </div>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
