<%@page import="com.model.Products"%>
<%@page import="com.model.Admin"%>
<%@page import="com.model.dao.ProductSqlDAO"%>
<%@page import="com.model.dao.AdminSqlDAO"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="com.model.dao.XmlTransformer"%>
<%@page import="com.model.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/adminProductView.css">
        <link rel="stylesheet" href="css/productSearchBox.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
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
                <li><a href="adminMain.jsp">Dashboard</a></li>
                <li><a href="productManagement.jsp">Product Management</a></li>
                <li><a class="active" href="#">View Products</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <% String productError = (String) session.getAttribute("productError");%>

        <!-- Search product by ID -->
        <form method="POST" action="/group1/ProductSearchServlet">
            <div class="search-box">
                <i class="uil uil-search"></i>
                <input id="productID" type="number" name="productID" placeholder="Search by ID..." />
                <button class="button ">Search</button>
                <%if (productError != null) {%>
                    <h4 style="color: red; margin-left: 200px;"><%= productError%></h4>
                <%}%>
            </div>
        </form>

        <%
            Admin admin = (Admin) session.getAttribute("admin");
        %>

        <% if (admin != null) { %>

        <% String xslPath = application.getRealPath("/xsl/products.xsl");%>

        <%
            ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
        %>

        <%
            Products products = new Products();
            products.addAll(productSqlDAO.getProducts());
            XmlTransformer transformer = new XmlTransformer();
            transformer.transform(xslPath, products, new StreamResult(out));
        %>

        <% } else { %>
        <% response.sendRedirect("login.jsp");%>
        <% }%>
        <%= productError = ""%>
        
        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>