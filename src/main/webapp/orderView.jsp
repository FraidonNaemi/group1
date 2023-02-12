<%@page import="java.util.List"%>
<%@page import="com.model.dao.OrderProductSqlDAO"%>
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
        <title>My Order</title>
        <link rel="stylesheet" href="css/style.css"/>
        <link rel="stylesheet" href="css/orderView.css"/>
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
                <li><a href="shopPage.jsp">Shop</a></li>
                <li><a class="active" href="#">My Order</a></li>
                <li><a href="myOrders.jsp">Orders</a></li>
                <li><a href="/group1/LogoutServlet">Logout</a></li>
            </ul>
        </nav>

        <% String xslPath = application.getRealPath("/xsl/orderProducts.xsl");
            OrderProductSqlDAO orderProductSqlDAO = (OrderProductSqlDAO) session.getAttribute("orderProductSqlDAO");
            int orderID = Integer.parseInt(request.getParameter("orderID"));
            OrderProducts orderProducts = new OrderProducts();
            List<OrderProduct> opList = orderProductSqlDAO.getAllOrderProducts(orderID);
            if (!opList.isEmpty()) {
                orderProducts.addAll(opList);
                XmlTransformer transformer = new XmlTransformer();
                transformer.transform(xslPath, orderProducts, new StreamResult(out));
            } else {
                out.print("No Product To View! Please Go To Shop To Add Some!");
            }
        %>
        
        <!-- Remove a product for the order -->
        <button class="deleteBtn" type="submit">
            <span class="btnText"><a class="deleteLink" href="/group1/DeleteOrderServlet?orderID=<%= orderID%>">Delete Order</a></span>
        </button>
        
        <% session.setAttribute("orderID", orderID);%>
        
        <!-- Footer -->
        <div class="footer">
            AFSY © 2023
        </div>
    </body>
</html>