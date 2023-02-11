<%-- 
    Document   : index
    Created on : Jan 24, 2023, 9:43:17 AM
    Author     : group1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
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
                <li><a class="active" href="#">Home</a></li>
                <li><a href="register.jsp">Register</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="shopPage.jsp">shop</a></li>

            </ul>
        </nav>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>

        <jsp:include page="/InitServlet" flush="true" />
    </body>
</html>
