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
        <title>View Customer</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/viewCustomers.css">
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
                <li><a href="adminCustomerView.jsp">Customer Management</a></li>
                <li><a class="active" href="#">View Customers</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
        
        <% String customerError = (String) session.getAttribute("customerError");%>
        
        <!-- Search customer by ID -->
        <div class="searchBox"> 
            <form method="POST" action="/group1/CustomerSearchServlet">
                <div class="search-box">
                    <i class="uil uil-search"></i>
                    <input type="text" name="customerID" placeholder="Search by ID..." />
                    <button class="button">Search</button>
                    <%if(customerError != null) {%>
                        <h4 style="color: red; margin-left: 200px;"><%= customerError%></h4>    
                    <%}%>
                </div>
            </form>
        </div>
        
        <!-- Show the customers list -->
        <%
            Admin admin = (Admin) session.getAttribute("admin");
        %>

        <% if (admin != null) { %>

        <%
            request.setAttribute("email", null);
            request.removeAttribute("email");
        %>

        <% String xslPath = application.getRealPath("/xsl/customers.xsl");%>

        <%
            CustomerSqlDAO customerSqlDAO = (CustomerSqlDAO) session.getAttribute("customerSqlDAO");
        %>

        <%
            Customers customers = new Customers();
            customers.addAll(customerSqlDAO.getCustomers());
            XmlTransformer transformer = new XmlTransformer();
            transformer.transform(xslPath, customers, new StreamResult(out));
        %>

        <% 
            } else {
                response.sendRedirect("login.jsp");
            }
        %>

        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>