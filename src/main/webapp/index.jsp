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
                <li><a href="register.jsp">Register</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
        
        <div class="welcomeMessage">Welcome to AFSY Store!</div>
        
        <!--  Slider -->
        <div class="mainSlider">
            <div class="slider">
                <span style="--i:1;"><img src="img/pantene-shampoo.jpg" alt="pantene shampoo"></span>
                <span style="--i:2;"><img src="img/punch-bag.jpg" alt="punch bag"></span>
                <span style="--i:3;"><img src="img/apple-watch.jpg" alt="apple watch"></span>
                <span style="--i:4;"><img src="img/apple-ipad.jpg" alt="apple ipad"></span>
                <span style="--i:5;"><img src="img/sport-bag.jpg" alt="sport bag"></span>
                <span style="--i:6;"><img src="img/homedics-massager.jpg" alt="homedics massager"></span>
                <span style="--i:7;"><img src="img/men-shoes.jpg" alt="men sport shoes"></span>
                <span style="--i:8;"><img src="img/dove-body-wash.jpg" alt="dove body wash"></span>
            </div>
        </div>
        
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>

        <jsp:include page="/InitServlet" flush="true" />
    </body>
</html>
