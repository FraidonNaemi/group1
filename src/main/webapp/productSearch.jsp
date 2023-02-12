<%@page import="com.model.dao.ProductSqlDAO"%>
<%@page import="com.rest.client.ProductServiceClient"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="com.model.dao.XmlTransformer"%>
<%@page import="com.model.Products"%>
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
                AFSY
            </div>
            <input type="checkbox" id="click">
            <label for="click" class="menu-btn">
                <i class="fas fa-bars"></i>
            </label>
            <ul>
                <li><a href="adminView.jsp">Admin</a></li>
                <li><a class="active" href="#">Admin Search</a></li>
                <li><a href="/prototype/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
        
        <% String xslPath = application.getRealPath("/xsl/products.xsl");%>
        
        <%
            int productID = Integer.parseInt(request.getParameter("productID"));
            ProductSqlDAO productSqlDAO = (ProductSqlDAO) session.getAttribute("productSqlDAO");
            XmlTransformer transformer = new XmlTransformer(); 
            transformer.transform(xslPath, ProductServiceClient.getProduct(productID), new StreamResult(out));
        %>
        
        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        <script src="js/clock.js"></script>
    </body>
</html>