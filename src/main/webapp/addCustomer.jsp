<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="com.model.dao.XmlTransformer"%>
<%@page import="com.model.Customers"%>
<%@page import="com.model.dao.CustomerSqlDAO"%>
<%@page import="com.model.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Customer</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/addCustomer.css">
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
                <li><a class="active" href="#">Add Customer</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <!-- Downloading the errors -->
        <%
            String addError = (String) (request.getSession(true)).getAttribute("addError");
            String customerNameError = (String) session.getAttribute("customerNameError");
            String customerPasswordError = (String) session.getAttribute("customerPasswordError");
            String customerDOBError = (String) session.getAttribute("customerDOBError");
            String customerPhoneNumberError = (String) session.getAttribute("customerPhoneNumberError");
            String customerAddressError = (String) session.getAttribute("customerAddressError");
        %>
        
        <!-- Add customer form -->
        <div class="container">
            <header>Add Customer</header>
            <div class="error-field-register"> 
                <p><%=(addError != null && !addError.isEmpty()) ? addError : ""%></p>
            </div>
            <form class="addForm" method="POST" action="/group1/AddCustomerRegexServlet">
                <div class="form first">
                    <div class="details personal">
                        <div class="fields">
                            <div class="input-field">
                                <label for="customerName">Full Name <span class="addCustomerError">&emsp;<%= (customerNameError != null) ? customerNameError : ""%></span></label>
                                <input type="text" name="customerName" placeholder="Full Name">
                            </div>
   
                            <div class="input-field">
                                <label for="customerEmail">Email</label>
                                <input type="text" name="customerEmail" placeholder="Email Address">
                            </div>
                                
                            <div class="input-field">
                                <label for="customerPassword">Password &emsp;<span class="addCustomerError">&emsp;<%= (customerPasswordError != null) ? customerPasswordError : ""%></span></label>
                                <input type="text" name="customerPassword" placeholder="Password">
                            </div>
                                
                            <div class="input-field">
                                <label for="customerDOB">Date of Birth</label>
                                <input type="date" name="customerDOB" placeholder="Date of Birth">
                            </div>
                                
                            <div class="input-field">
                                <label for="customerPhoneNumber">Phone Number &emsp;<span class="addCustomerError">&emsp;<%= (customerPhoneNumberError != null) ? customerPhoneNumberError : ""%></span></label>
                                <input type="text" name="customerPhoneNumber" placeholder="Phone Number">
                            </div>
                                
                            <div class="input-field">
                                <label for="customerAddress">Address &emsp;<span class="addCustomerError">&emsp;<%= (customerAddressError != null) ? customerAddressError : ""%></span></label>
                                <input type="text" name="customerAddress" placeholder="Address">
                            </div>
                                
                            <button class="addBtn" type="submit">
                                <span class="btnText">Add</span>
                            </button>
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <%
            customerNameError = "";
            customerPasswordError = "";
            customerDOBError = "";
            customerPhoneNumberError = "";
            customerAddressError = "";
            addError = "";
            
            session.setAttribute("customerNameError", customerNameError);
            session.setAttribute("customerPasswordError", customerPasswordError);
            session.setAttribute("customerDOBError", customerDOBError);
            session.setAttribute("customerPhoneNumberError", customerPhoneNumberError);
            session.setAttribute("customerAddressError", customerAddressError);
            session.setAttribute("addError", addError);
        %>    

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
