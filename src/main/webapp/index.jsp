<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/index.css"/>
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
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
        
        <!-- Body -->
        <div class="content home-content">
            <div>
                <p class="welcome"> Welcome!</p>
                <p class="description">AFSY Store Description</p>
            </div>
        </div>
        
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>

        <jsp:include page="/InitServlet" flush="true" />
    </body>
</html>
