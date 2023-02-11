<%-- 
    Document   : orderView
    Created on : 01-Feb-2023, 12:56:04 PM
    Author     : 236369
--%>

<!--here, the customer can see all his orders including the previous ones from the archive table-->
<%@page import="com.model.dao.OrderSqlDAO"%>
<%@page import="javax.xml.transform.stream.StreamResult"%>
<%@page import="com.model.dao.XmlTransformer"%>
<%@page import="com.model.Orders"%>
<%@page import="com.model.Order"%>
<%@page import="com.model.Customer"%>
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
                <li><a href="/group1/OrderCreateServlet">create order</a></li>
                <li><a href="/group1/LougoutServlet">Logout</a></li>
                
            </ul>
        </nav>

        <div>
            <!--                view all orders-->
            <%
                Customer customer = (Customer) session.getAttribute("customer");
            %>



            <% String xslPath = application.getRealPath("/xsl/orders.xsl");%>

            <%
                OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
            %>



            <%
                Orders orders = new Orders();
                orders.addAll(orderSqlDAO.getAllOrders(customer.getID()));
                XmlTransformer transformer = new XmlTransformer();
                transformer.transform(xslPath, orders, new StreamResult(out));
            %>


            <!--                delete one order(cancel an order )-->
            <%
//                Order order = null;
//                int orderID = Integer.parseInt(request.getParameter("orderID"));
//
//                orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
//                Order order = orderSqlDAO.getOrderByID(orderID, customer.getCustomerID());
//                order = (Order) session.getAttribute("order");

            %>

            <!--            resetting the uri var-->
            <% //                orderID = "";
//                session.setAttribute("orderID", orderID);
            %>

            <!-- Checkout the order -->



            <!-- Footer -->
            <div class="footer">
                AFSY © 2023
            </div>
    </body>
</html>
