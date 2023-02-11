<%@page import="com.model.Customer"%>
<%@page import="com.model.dao.CustomerSqlDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
        <title>Customer Account</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/account.css">
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    </head>
    <body>
        <%
            String emailView = (String) session.getAttribute("emailView");
        %>

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
                    <a href="customerMain.jsp">Dashboard</a>
                </li>
                <li><a class="active" href="#">Customer Account</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <%
            CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
            Customer customer = (Customer) session.getAttribute("customer");
            String submitted = request.getParameter("submitted");

            String customerNameError = (String) session.getAttribute("customerNameError");
            String customerPasswordError = (String) session.getAttribute("customerPasswordError");
            String customerDOBError = (String) session.getAttribute("customerDOBError");
            String customerPhoneNumberError = (String) session.getAttribute("customerPhoneNumberError");
            String customerAddressError = (String) session.getAttribute("customerAddressError");
        %>

        <!-- Update Customer Form -->
        <div class="container" style="text-align: left!important; margin: 10% 25%;">
        <header>Update Account</header>
        <form class="updateForm" method="POST" action="/group1/CustomerAccountServlet">
            <div class="form first">
                <div class="details personal">
                    <span class="title">ID: <%=customer.getCustomerID()%></span>

                    <div class="fields">
                        <div class="input-field">
                            <label for="customerName">Full Name <span style="color: red;">&emsp;<%= (customerNameError != null) ? customerNameError : "" %></span></label>
                            <input type="text" name="customerName" value="<%= (customerNameError != null && !customerNameError.isEmpty()) ? "" : customer.getCustomerName()%>">
                        </div>

                        <div class="input-field">
                            <label for="customerEmail">Email</label>
                            <input type="text" name="customerEmail" value="<%= customer.getCustomerEmail()%>" readonly="true">
                        </div>

                        <div class="input-field">
                            <label for="customerPassword">Password &emsp;<span style="color: red;">&emsp;<%= (customerPasswordError != null) ? customerPasswordError : "" %></span></label>
                            <input type="text" name="customerPassword" value="<%= (customerPasswordError != null && !customerPasswordError.isEmpty()) ? "" : customer.getCustomerPassword()%>">
                        </div>

                        <div class="input-field">
                            <label for="customerDOB">Date of Birth </label>
                            <input type="date" name="customerDOB" value="<%= customer.getCustomerDOB()%>">
                        </div>

                        <div class="input-field">
                            <label for="customerPhoneNumber">Phone Number &emsp;<span style="color: red;">&emsp;<%= (customerPhoneNumberError != null) ? customerPhoneNumberError : "" %></span></label>
                            <input type="text" name="customerPhoneNumber" value="<%= (customerPhoneNumberError != null && !customerPhoneNumberError.isEmpty()) ? "" : customer.getCustomerPhoneNumber()%>">
                        </div>

                        <div class="input-field">
                            <label for="customerAddress">Address &emsp;<span style="color: red;">&emsp;<%= (customerAddressError != null) ? customerAddressError : "" %></span></label>
                            <input type="text" name="customerAddress" value="<%= (customerAddressError != null && !customerAddressError.isEmpty()) ? "" : customer.getCustomerAddress()%>">
                        </div>
                        
                        <input type="hidden" name="submitted" value="submitted">
                        <input type="hidden" name="customerID" value="<%=customer.getCustomerID()%>">
                        
                        <div class="buttons">
                            <button class="deleteBtn">
                                 <span class="btnText"><a href="/group1/DeleteCustomerServlet?customerEmail=<%= customer.getCustomerEmail()%>" style="text-decoration: none; color:#fff;">Delete</a></span>
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

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>

