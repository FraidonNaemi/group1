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
        
        <div class="welcomeMessage">Welcome to AFSY Store.</div>
        
        <!--  Slider -->
        <div class="mainSlider">
            <div class="slider">
                <span style="--i:1;"><img src="img/2084.jpg" alt="2084"></span>
                <span style="--i:2;"><img src="img/artifactSpace.jpg" alt="artifact space"></span>
                <span style="--i:3;"><img src="img/cosmicCareers.jpg" alt="cosmic careers"></span>
                <span style="--i:4;"><img src="img/howToDieInSpace.jpg" alt="how to die in space"></span>
                <span style="--i:5;"><img src="img/space2069.jpg" alt="space 2069"></span>
                <span style="--i:6;"><img src="img/theGodOfEquation.jpg" alt="the god of equation"></span>
                <span style="--i:7;"><img src="img/theLastAstronaunt.jpg" alt="the last astronaunt"></span>
                <span style="--i:8;"><img src="img/theQuantumSeries.jpg" alt="the quantum series"></span>
            </div>
        </div>
        
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>

        <jsp:include page="/InitServlet" flush="true" />
    </body>
</html>
