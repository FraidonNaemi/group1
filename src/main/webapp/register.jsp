<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/register.css">
        <link rel="stylesheet" href="css/loginRadioButton.css"/>
    </head>

    <body>
        <!-- Navigation Bar -->
        <nav>
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
                    <li><a class="active" href="#">Register</a></li>
                </ul>
            </nav>

            <!-- Downloading the errors -->
            <!--It retrieves three attributes from a session object and assigns their values to three different variables of type String. 
            These variables likely store error messages to be displayed to the user.-->
            <%
                String nameError = (String) session.getAttribute("nameError");
                String emailError = (String) session.getAttribute("emailError");
                String passError = (String) session.getAttribute("passError");
                String emailPassError = (String) session.getAttribute("emailPassError");
            %>

            <div class="wrapper">
                <header>Sign Up</header>
                <div class="error-field-register"> 
                    <p><%= (nameError != null) ? nameError : ""%></p>
                    <p><%= (emailError != null) ? emailError : ""%></p>
                    <p><%= (emailError != null) ? passError : ""%></p>
                    <p><%= (emailError != null && passError != null) ? emailPassError : ""%></p>
                </div>

                <!--when the form is submitted, the data will be sent to the server at this URL. 
                The server-side code located at this URL will process the form data.
                POST the data will be sent to the server in the body of the request.-->
                <form method="POST" action="/group1/RegisterServlet">
                    <div class="field name">
                        <div class="input-area">
                            <input type="text" name="name" placeholder="Name">
                            <i class="icon fas fa-user"></i>
                            <i class="error error-icon fas fa-exclamation-circle"></i>
                        </div>
                    </div>


                    <div class="field email">
                        <div class="input-area">
                            <input type="text" name="email" placeholder="EmailAddress">
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

                    <div class="field dateOfBirth">
                        <div class="input-area">
                            <input type="date" name="dob" placeholder="Date of Birth">
                        </div>
                    </div>

                    <div class="field phonenumber">
                        <div class="input-area">
                            <input type="text" name="phonenumber" placeholder="Phone">
                            <i class="icon fas fa-user"></i>
                            <i class="error error-icon fas fa-exclamation-circle"></i>
                        </div>
                    </div>   

                    <div class="field address">
                        <div class="input-area">
                            <input type="text" name="address" placeholder="Address">
                            <i class="icon fas fa-user"></i>
                            <i class="error error-icon fas fa-exclamation-circle"></i>
                        </div>
                    </div>  

                    <div class="radio-group field userType">
                        <p class="iam"> I am: </p>
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
                    <input type="submit" value="Sign Up">
                </form>
                <div class="sign-txt">Already have an account? <a href="login.jsp">Sign In</a></div>

            </div>

            <!-- Footer -->
            <div class="footer">
                AFSY © 2023
            </div>

            <!--initializes three error messages and sets their values to an empty string. 
            shows error messages to the user if the entered email or password are incorrect.
           sets these error messages as attributes in a session-->
            <%
                passError = "";
                emailError = "";
                emailPassError = "";
                session.setAttribute("emailError", emailError);
                session.setAttribute("passError", passError);
                session.setAttribute("emailPassError", emailPassError);
            %>

    </body>

</html>
