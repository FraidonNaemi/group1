<%@page import="com.model.Customer"%>
<%@page import="com.model.dao.CustomerSqlDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
        <title>Customer Account</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/adminCustomerAccount.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    </head>
    <body>
        <!-- Navigation Bar -->
        <nav>
            <div class="logo">
                FASY
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li>
                    <a href="adminCustomerView.jsp">Customer Management</a>
                </li>
                <li><a class="active" href="#">Customer Account</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <%
            String customerNameError = (String) session.getAttribute("customerNameError");
            String customerPasswordError = (String) session.getAttribute("customerPasswordError");
            String customerDOBError = (String) session.getAttribute("customerDOBError");
            String customerPhoneNumberError = (String) session.getAttribute("customerPhoneNumberError");
            String customerAddressError = (String) session.getAttribute("customerAddressError");
            String submitted = (String) session.getAttribute("submitted");

            Customer customer = null;
            String emailView = request.getParameter("emailView");
            if (emailView != null) {
                CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
                customer = customerSqlDAO.getCustomer(emailView);
            } else {
                customer = (Customer) session.getAttribute("customer");
            }
            session.setAttribute("customer", customer);
        %>

        <!-- Update customer form -->
        <div class="container" style="text-align: left!important; margin: 10% 25%;">
            <header>Update Customer</header>
            <div class="confirm-field">
                <p><%= (submitted != null && !submitted.isEmpty()) ? "Updated successfully" : ""%></p>
            </div>
            <form class="updateForm" method="POST" action="/group1/AdminCustomerAccountServlet">
                <div class="form first">
                    <div class="personal-details">
                        <span class="title">ID <%=customer.getCustomerID()%></span>

                        <div class="fields">
                            <div class="input-field">
                                <label for="customerName">Full Name<span class="updateCustomerError">&emsp;<%= (customerNameError != null) ? customerNameError : ""%></span></label>
                                <input type="text" name="customerName" value="<%= (customerNameError != null && !customerNameError.isEmpty()) ? "" : customer.getCustomerName()%>">
                            </div>

                            <div class="input-field">
                                <label for="customerEmail">Email</label>
                                <input type="text" name="customerEmail" value="<%= customer.getCustomerEmail()%>" readonly="true">
                            </div>

                            <div class="input-field">
                                <label for="customerPassword">Password &emsp;<span class="updateCustomerError"> &emsp;<%= (customerPasswordError != null) ? customerPasswordError : ""%></span></label>
                                <input type="text" name="customerPassword" value="<%= (customerPasswordError != null && !customerPasswordError.isEmpty()) ? "" : customer.getCustomerPassword()%>">
                            </div>

                            <div class="input-field">
                                <label for="customerDOB">Date of Birth</label>
                                <input type="date" name="customerDOB" value="<%= customer.getCustomerDOB()%>">
                            </div>

                            <div class="input-field">
                                <label for="customerPhoneNumber">Phone Number &emsp;<span class="updateCustomerError">&emsp;<%= (customerPhoneNumberError != null) ? customerPhoneNumberError : ""%></span></label>
                                <input type="text" name="customerPhoneNumber" value="<%= (customerPhoneNumberError != null && !customerPhoneNumberError.isEmpty()) ? "" : customer.getCustomerPhoneNumber()%>">
                            </div>

                            <div class="input-field">
                                <label for="customerAddress">Address &emsp;<span class="updateCustomerError">&emsp;<%= (customerAddressError != null) ? customerAddressError : ""%></span></label>
                                <input type="text" name="customerAddress" value="<%= (customerAddressError != null && !customerAddressError.isEmpty()) ? "" : customer.getCustomerAddress()%>">
                            </div>

                            <input type="hidden" name="submitted" value="submitted">
                            <input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>">

                            <div class="buttons">
                                <button class="deleteBtn">
                                    <span class="btnText"><a href="/group1/DeleteCustomerServlet" style="text-decoration: none; color:#fff;">Delete</a></span>
                                </button>

                                <button class="updateBtn" type="submit">
                                    <span class="btnText">Update</span>
                                </button>
                            </div>
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
            submitted = "";

            session.setAttribute("customerNameError", customerNameError);
            session.setAttribute("customerPasswordError", customerPasswordError);
            session.setAttribute("customerDOBError", customerDOBError);
            session.setAttribute("customerPhoneNumberError", customerPhoneNumberError);
            session.setAttribute("customerAddressError", customerAddressError);
            session.setAttribute("submitted", submitted);
        %>

        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        <script src="js/clock.js"></script>
    </body>
</html>