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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" />
    </head>
    <body>
        <!-- Navigation Bar -->
        <nav>
            <div class="logo">
                Ab | Fr
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a class="active" href="#">Admin</a></li>
                <li><a href="registerProduct.jsp">Add Product</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
       <% String productError = (String) session.getAttribute("productError");%>
        <div class="string">
            <header>Search by ID</header>
            <form class="strings" method="post" action="/group1/ProductSearchServlet">
                <div class="input-area-string">
                    <input id="productID" class="input-area-string" name="productID" type="number" placeholder="product ID">
                    <%if(productError != null){%>
                    <h4><%= productError %><h4/>
                        <%}%>
                </div> 
        
        <%
            Admin admin = (Admin) session.getAttribute("admin");
        %>
        
        <% if (admin != null) { %>
        
        <%
           // request.setAttribute("email", null);
            //request.removeAttribute("email");
        %>

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
        
        <% response.sendRedirect("adminLogin.jsp");%>
        
        <% } %>
       <%= productError="" %>
        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        <script src="js/clock.js"></script>
    </body>
</html>