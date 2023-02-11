<%-- 
    Document   : login
    Created on : Jan 24, 2023, 11:33:35 AM
    Author     : group1
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/loginRadioButton.css"/>
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
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="">Login</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>

        <%
            String userError = (String) session.getAttribute("userError");
        %>

        <!-- Login  -->
        <div class="wrapper-login">
            <header>Login</header>
            <div class="error-field-login"> 
                <p><%= (userError != null) ? userError : ""%></p>
            </div>

            <form method="POST" action="/group1/LoginServlet">
                <div class="field email">
                    <div class="input-area">
                        <input type="text" name="email" placeholder="Email Address">
                        <i class="icon fas fa-envelope"></i>
                        <i class="error error-icon fas fa-exclamation-circle"></i>
                    </div>
                </div>
                <div class="field password">
                    <div class="input-area">
                        <input type="password" name="password" placeholder="Password">
                        <i class="icon fas fa-lock"></i>
                        <i class="error error-icon fas fa-exclamation-circle"></i>
                    </div>
                </div>

                <div class="radio-group field userType">
                    <p class="iam">I am:</p> 
                    <label class="radio">
                        <input type="radio" value="customer" name="userType" checked>
                        customer
                        <span></span>
                    </label>
                    <label class="radio">
                        <input type="radio" value="admin" name="userType">
                        admin
                        <span></span>
                    </label>
                </div>

                <div class="field login">
                    <input type="submit" value="Login">
                </div>

            </form>
            <div class="sign-txt">Don’t have an account? <a href="#">Sign Up</a></div>
        </div>
        <%
            userError = "";
            session.setAttribute("userError", userError);
        %>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
