<%@page import="java.util.List"%>
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
                <li><a href="customerMain.jsp">Dashboard</a></li>
                <li><a class="active" href="#">Orders</a></li>
                <li><a href="/group1/CreateOrderServlet">Create Order</a></li>
                <li><a href="shopPage.jsp">Shop</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <!-- Error Messages -->
        <h3 style="color: red; text-align: center; margin-top: 5%;">
        <%
            String orderNotification = (String) session.getAttribute("orderNotification");
            String opDeleteNotification = (String) session.getAttribute("opDeleteNotification");
            if (opDeleteNotification != null) {
                out.print(opDeleteNotification);
            }
        %>
        </h3>
        <h3 style="color: green; text-align: center; margin-top: 5%;">
            <%
                if (orderNotification != null) {
                out.print(orderNotification);
            }%>
        </h3>
        
        <!-- View all orders -->
        <%
            Customer customer = (Customer) session.getAttribute("customer");
            String xslPath = application.getRealPath("/xsl/orders.xsl");
            OrderSqlDAO orderSqlDAO = (OrderSqlDAO) session.getAttribute("orderSqlDAO");
            Orders orders = new Orders();
            List<Order> ordersList = orderSqlDAO.getAllOrders(customer.getCustomerID());
            orders.addAll(ordersList);
            if (!ordersList.isEmpty()) {
                XmlTransformer transformer = new XmlTransformer();
                transformer.transform(xslPath, orders, new StreamResult(out));
            } else {
                %> <h3 style="text-align: center; margin-top: 5%;"> <%out.print("No Orders To View!");%></h3><%
            }
        %>
        
        <!-- Reset -->
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
