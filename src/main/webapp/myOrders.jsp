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
                <li><a class="active" href="index.jsp">Home</a></li>
                <li><a href="/group1/CreateOrderServlet">Checkout</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>
        <div>
            <!--                view all orders-->
            <div>
                <%
                    String orderNotification = (String) session.getAttribute("orderNotification");
                    String opDeleteNotification = (String) session.getAttribute("opDeleteNotification");
                    if (opDeleteNotification != null) {
                        out.print(opDeleteNotification);
                    }
                    if (orderNotification != null) {
                        out.print(orderNotification);
                    }
                %>
            </div>
            <%
                Customer customer = (Customer) session.getAttribute("customer");
                String xslPath = application.getRealPath("/xsl/orders.xsl");
                OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
                Orders orders = new Orders();
                orders.addAll(orderSqlDAO.getAllOrders(customer.getCustomerID()));
                XmlTransformer transformer = new XmlTransformer();
                transformer.transform(xslPath, orders, new StreamResult(out));
            %>
        </div>
        <%
            session.setAttribute("orderNotification", "");
            session.setAttribute("opDeleteNotification", "");
        %>
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>
