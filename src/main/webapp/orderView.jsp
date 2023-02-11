
<%-- 
    Document   : orderView
    Created on : 01-Feb-2023, 12:56:04 PM
    Author     : 236369
--%>

<%@page import="java.util.List"%>
<%@page import="com.model.dao.OrderProductSqlDAO"%>
<!--here, customer can see the current order and remove, add the products from that order
customer can update the order name here too-->

<%@page import="com.model.dao.OrderSqlDAO"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="com.model.dao.XmlTransformer"%>
<%@page import="com.model.Orders"%>
<%@page import="com.model.Order"%>
<%@page import="com.model.OrderProduct"%>
<%@page import="com.model.OrderProducts"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/style.css"/>
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
                <li><a href="myOrders.jsp">back</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
                <li><a href="shopPage.jsp">Shop</a></li>
            </ul>
        </nav>

        <% String xslPath = application.getRealPath("/xsl/orderProducts.xsl");
            OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            session.setAttribute("orderID", orderID);
            OrderProducts orderProducts = new OrderProducts();
            orderProducts.addAll(orderProductSqlDAO.getAllOrderProducts(orderID));
            XmlTransformer transformer = new XmlTransformer();
            transformer.transform(xslPath, orderProducts, new StreamResult(out));
        %>
        <!-- Remove a product for the order -->
        <span><a href="/group1/DeleteOrderServlet?orderID=<%= orderID%>">Delete this Order</a></span>
        <!-- Clock - Footer -->
        <div class="clock">
            <span class="clock-time"></span>
            <span class="clock-ampm"></span>
        </div>
        <script src="js/clock.js"></script>
    </body>
</html>