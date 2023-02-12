<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/addCustomer.css">
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
            String addError = (String) (request.getSession(true)).getAttribute("addError");
            String nameError = (String) session.getAttribute("nameError");
            String emailError = (String) session.getAttribute("emailError");
            String passwordError = (String) session.getAttribute("passwordError");
           // String dobError = (String) session.getAttribute("dobError");
            String phoneNumberError = (String) session.getAttribute("phoneNumberError");
            String addressError = (String) session.getAttribute("addressError");
        %>
        <!-- Add customer form -->
        <div class="container">
            <header>Add Customer</header>
            <div class="error-field-register">
                <p><%=(addError != null && !addError.isEmpty()) ? addError : ""%></p>
            </div>
            <form class="addForm" method="POST" action="/group1/RegexRegisterServlet">
                <div class="form first">
                    <div class="personal-details">
                        <div class="fields">
                            <div class="input-field">
                                <label for="name">Full Name <span class="addCustomerError">&emsp;<%= (nameError != null) ? nameError : ""%></span></label>
                                <input type="text" name="name" placeholder="Full Name">
                            </div>
                            <div class="input-field">
                                <label for="email">Email<span class="addCustomerError">&emsp;<%= (emailError != null) ? emailError : ""%></span></label>
                                <input type="text" name="email" placeholder="Email Address">
                            </div>
                            <div class="input-field">
                                <label for="password">Password &emsp;<span class="addCustomerError">&emsp;<%= (passwordError != null) ? passwordError : ""%></span></label>
                                <input type="text" name="password" placeholder="Password">
                            </div>
                            <div class="input-field">
                                <label for="dob">Date of Birth</label>
                                <input type="date" name="dob" placeholder="Date of Birth">
                            </div>
                            <div class="input-field">
                                <label for="phoneNumber">Phone Number &nbsp;<span class="addCustomerError"><%= (phoneNumberError != null) ? phoneNumberError : ""%></span></label>
                                <input type="text" name="phoneNumber" placeholder="Phone Number">
                            </div>
                            <div class="input-field">
                                <label for="address">Address &emsp;<span class="addCustomerError">&emsp;<%= (addressError != null) ? addressError : ""%></span></label>
                                <input type="text" name="address" placeholder="Address">
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
                            <button class="addBtn" type="submit">
                                <span class="btnText">Sign Up</span>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <%
            nameError = "";
            emailError = "";
            passwordError = "";
            //dobError = "";
            phoneNumberError = "";
            addressError = "";
            addError = "";
            session.setAttribute("nameError", nameError);
            session.setAttribute("emailError", emailError);
            session.setAttribute("passwordError", passwordError);
            //session.setAttribute("dobError", dobError);
            session.setAttribute("phoneNumberError", phoneNumberError);
            session.setAttribute("addressError", addressError);
            session.setAttribute("addError", addError);
        %>
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>